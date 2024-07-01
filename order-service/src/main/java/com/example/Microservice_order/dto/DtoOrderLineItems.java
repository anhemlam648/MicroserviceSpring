package com.example.Microservice_order.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DtoOrderLineItems {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
