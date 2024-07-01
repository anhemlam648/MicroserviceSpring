package com.example.Inventory_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Dtoinventory {
    private Long id;
    private String skuCode;
    private Integer quantity;
}

