package com.example.Microservice_order.service;

import com.example.Microservice_order.config.WebConfig;
import com.example.Microservice_order.dto.DtoOrder;
import com.example.Microservice_order.dto.DtoOrderLineItems;
import com.example.Microservice_order.mapper.MapOrder;
import com.example.Microservice_order.model.Dtoinventory;
import com.example.Microservice_order.model.Order;
import com.example.Microservice_order.model.OrderLineItems;
import com.example.Microservice_order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;

import java.lang.reflect.Array;
import java.net.http.WebSocketHandshakeException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final MapOrder mapOrder;
    private final WebClient webClient;
    @Autowired
    public OrderService(OrderRepository orderRepository, MapOrder mapOrder, WebClient webClient,WebClient.Builder webClientBuilder) {
        this.orderRepository = orderRepository;
        this.mapOrder = mapOrder;
        this.webClient = webClient;
//        this.webClient = webClientBuilder.baseUrl("http://localhost:8082").build();
    }

    @Transactional
    public Order createOrder(DtoOrder dtoOrder) {
        Order order = mapOrder.mapToOrder(dtoOrder);
        order.setOrderNumber(UUID.randomUUID().toString());
        List<String> skuCodes = dtoOrder.getOrderLineItemsList().stream()
                .map(item -> item.getSkuCode())
                .collect(Collectors.toList());
//        Boolean callresult = webClient.get().uri("http://localhost:8082/api/inventory").retrieve().bodyToMono(Boolean.class).block();
        Boolean callresult = checkInventoryAvailability(skuCodes);
        if(callresult){
            order = orderRepository.save(order);
            log.info("Order {} is saved", order.getId());
        }else{
            throw new IllegalArgumentException("Is not stock from produc, please try again");
        }
//        order = orderRepository.save(order);
//        log.info("Order {} is saved", order.getId());
        return order;
    }

    @Transactional(readOnly = true)
    public List<DtoOrder> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(mapOrder::mapToOrderDto).collect(Collectors.toList());
    }
    private Boolean checkInventoryAvailability(List<String> skuCodes) {
//        return webClient.get()
//                .uri(uriBuilder -> uriBuilder.path("/api/inventory")
//                        .queryParam("skuCode", skuCodes.toArray())
////                        .queryParam("skuCoe",skuCodes)
//                        .build())
//                .retrieve()
//                .bodyToFlux(Boolean.class) //chuyển đổi thành một flux các giá trị Boolean để kiểm tra xem tất cả các giá trị có đúng là true hay không.
//                .all(result -> result) // Đảm bảo tất cả các phần tử trong flux đều là true
//                .block();
        try {
            Flux<Dtoinventory> inventoryResponses = webClient.get() // Flux xử lý bất đồng bộ
                    .uri(uriBuilder -> uriBuilder.path("/api/inventory")
                            .queryParam("skuCode", skuCodes.toArray())
                            .build())
                    .retrieve()
                    .bodyToFlux(Dtoinventory.class); // mỗi đối tượng chứa 1 thông tin chi tiết cụ thể
            // Kiểm tra các giá trị trong Dtoinventory và sử dụng
            return inventoryResponses.all(Dtoinventory::isInStock).block();  //để chuyển đổi thành một flux các đối tượng Dtoinventory để kiểm tra trạng thái isInStock.
        } catch (WebClientResponseException ex) {
            log.error("Error checking inventory availability: {}", ex.getRawStatusCode());
            throw new RuntimeException("Failed check from inventory availability", ex);
        }
    }



}
