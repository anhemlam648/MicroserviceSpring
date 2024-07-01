package com.example.Microservice_order.service;

import com.example.Microservice_order.dto.DtoOrderLineItems;
import com.example.Microservice_order.mapper.MapOrderLineItems;
import com.example.Microservice_order.model.OrderLineItems;
import com.example.Microservice_order.repository.OrderLineRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class OrderLineItemss {
    private final OrderLineRepository orderLineRepository;
    private final MapOrderLineItems mapOrderLineItems;

    @Autowired
    public OrderLineItemss(OrderLineRepository orderLineRepository, MapOrderLineItems mapOrderLineItems) {
        this.orderLineRepository = orderLineRepository;
        this.mapOrderLineItems = mapOrderLineItems;
    }

    @Transactional
    public OrderLineItems createOrderLineItem(DtoOrderLineItems dtoOrderLineItems) {
        OrderLineItems orderLineItems = mapOrderLineItems.mapToOderLineItems(dtoOrderLineItems);
        orderLineItems = orderLineRepository.save(orderLineItems);
        log.info("OrderLineItem {} is saved", orderLineItems.getId());
        return orderLineItems;
    }

    @Transactional(readOnly = true)
    public List<DtoOrderLineItems> getAllOrderLineItems() {
        List<OrderLineItems> orderLineItems = orderLineRepository.findAll();
        return orderLineItems.stream().map(mapOrderLineItems::mapToOderLineDto).collect(Collectors.toList());
    }
}
