package com.example.Microservice_order.service;

import com.example.Microservice_order.config.WebConfig;
import com.example.Microservice_order.dto.DtoOrder;
import com.example.Microservice_order.mapper.MapOrder;
import com.example.Microservice_order.model.Order;
import com.example.Microservice_order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderService {
    private final OrderRepository orderRepository;
    private final MapOrder mapOrder;
    private final WebClient webClient;
    @Autowired
    public OrderService(OrderRepository orderRepository, MapOrder mapOrder, WebClient webClient) {
        this.orderRepository = orderRepository;
        this.mapOrder = mapOrder;
        this.webClient = webClient;
    }

    @Transactional
    public Order createOrder(DtoOrder dtoOrder) {
        Order order = mapOrder.mapToOrder(dtoOrder);
        Boolean callresult = webClient.get().uri("http://localhost:8082/api/inventory").retrieve().bodyToMono(Boolean.class).block();
        if(callresult){
            order = orderRepository.save(order);
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
}
