package com.example.Microservice_order.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dtoinventory {
    private String skuCode;
    private boolean isInStock;
}

