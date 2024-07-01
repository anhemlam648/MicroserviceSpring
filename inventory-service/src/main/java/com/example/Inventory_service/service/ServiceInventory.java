package com.example.Inventory_service.service;

import com.example.Inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceInventory {

    private final InventoryRepository inventoryRepository;

    @Autowired
    private ServiceInventory(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }
}
