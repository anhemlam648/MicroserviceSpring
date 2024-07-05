package com.example.Inventory_service.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dtoinventory {
    private String skuCode;
    private boolean isInStock;
}

