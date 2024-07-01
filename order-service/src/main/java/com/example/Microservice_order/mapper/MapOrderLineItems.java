package com.example.Microservice_order.mapper;

import com.example.Microservice_order.dto.DtoOrderLineItems;
import com.example.Microservice_order.model.OrderLineItems;
import org.springframework.stereotype.Component;

@Component
public class MapOrderLineItems {
    public DtoOrderLineItems mapToOderLineDto(OrderLineItems orderLineItems) {
        DtoOrderLineItems dtoOrderLineItems = new DtoOrderLineItems();
        dtoOrderLineItems.setId(orderLineItems.getId());
        dtoOrderLineItems.setSkuCode(orderLineItems.getSkuCode());
        dtoOrderLineItems.setPrice(orderLineItems.getPrice());
        dtoOrderLineItems.setQuantity(orderLineItems.getQuantity());
        return dtoOrderLineItems;
    }

    public OrderLineItems mapToOderLineItems(DtoOrderLineItems dtoOrderLineItems) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setId(dtoOrderLineItems.getId());
        orderLineItems.setSkuCode(dtoOrderLineItems.getSkuCode());
        orderLineItems.setPrice(dtoOrderLineItems.getPrice());
        orderLineItems.setQuantity(dtoOrderLineItems.getQuantity());
        return orderLineItems;
    }
}
