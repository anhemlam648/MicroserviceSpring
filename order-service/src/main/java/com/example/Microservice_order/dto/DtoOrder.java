package com.example.Microservice_order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DtoOrder {
    private Long id;
    private String orderNumber;
    private List<DtoOrderLineItems> orderLineItemsList;
}
