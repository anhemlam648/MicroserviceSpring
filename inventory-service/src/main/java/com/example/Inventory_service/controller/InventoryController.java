package com.example.Inventory_service.controller;

import com.example.Inventory_service.service.ServiceInventory;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final ServiceInventory serviceInventory;

//    @Autowired
//    private InventoryController(ServiceInventory serviceInventory){
//        this.serviceInventory = serviceInventory;
//    }

//    @GetMapping("/{sku-code}")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
//    public boolean isInStock(@PathVariable("sku-code") String skuCode){
//        return serviceInventory.isInStock(skuCode);
//    }
    public boolean isInStock(@RequestParam List<String> skuCode){
        return serviceInventory.isInStock(skuCode);
    }
}
