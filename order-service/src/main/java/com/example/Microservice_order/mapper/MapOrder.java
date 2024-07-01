package com.example.Microservice_order.mapper;

import com.example.Microservice_order.dto.DtoOrder;
import com.example.Microservice_order.dto.DtoOrderLineItems;
import com.example.Microservice_order.model.Order;
import com.example.Microservice_order.model.OrderLineItems;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class MapOrder {
    public DtoOrder mapToOrderDto(Order order) {
        DtoOrder dtoOrder = new DtoOrder();
        dtoOrder.setId(order.getId());
        dtoOrder.setOrderNumber(order.getOrderNumber());
        // Map orderLineItemsList to DtoOrderLineItems list
        if (order.getOrderLineItemsList() != null) {
            List<DtoOrderLineItems> dtoOrderLineItemsList = new ArrayList<>();
            for (OrderLineItems orderLineItem : order.getOrderLineItemsList()) {
                DtoOrderLineItems dtoOrderLineItem = new DtoOrderLineItems();
                dtoOrderLineItem.setId(orderLineItem.getId());
                dtoOrderLineItem.setSkuCode(orderLineItem.getSkuCode());
                dtoOrderLineItem.setQuantity(orderLineItem.getQuantity());
                dtoOrderLineItem.setPrice(orderLineItem.getPrice());
                // add dtoOrderLineItem to list
                dtoOrderLineItemsList.add(dtoOrderLineItem);
            }
            dtoOrder.setOrderLineItemsList(dtoOrderLineItemsList);
        }

        return dtoOrder;
    }

    public Order mapToOrder(DtoOrder dtoOrder) {
        Order order = new Order();
        order.setId(dtoOrder.getId());
        order.setOrderNumber(dtoOrder.getOrderNumber());
        // Map orderLineItemsList to OrderLineItems list
        if (dtoOrder.getOrderLineItemsList() != null) {
            List<OrderLineItems> orderLineItemsList = new ArrayList<>();
            for (DtoOrderLineItems dtoOrderLineItem : dtoOrder.getOrderLineItemsList()) {
                OrderLineItems orderLineItem = new OrderLineItems();
                orderLineItem.setId(dtoOrderLineItem.getId());
                orderLineItem.setSkuCode(dtoOrderLineItem.getSkuCode());
                orderLineItem.setQuantity(dtoOrderLineItem.getQuantity());
                orderLineItem.setPrice(dtoOrderLineItem.getPrice());
                // Set the parent order for bidirectional mapping
                orderLineItem.setOrder(order);
                // Add orderLineItem to list
                orderLineItemsList.add(orderLineItem);
            }
            order.setOrderLineItemsList(orderLineItemsList);
        }

        return order;
    }
}
