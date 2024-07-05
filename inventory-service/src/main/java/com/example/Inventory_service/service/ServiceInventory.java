package com.example.Inventory_service.service;

import com.example.Inventory_service.model.Inventory;
import com.example.Inventory_service.repository.InventoryRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceInventory {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public ServiceInventory(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

    @Transactional(readOnly = true)
    public boolean isInStock(List<String> skuCodes) {
//        Optional<Inventory> optionalInventory = inventoryRepository.findBySkuCodeStock(skuCodes);
//        for (String skuCode : skuCodes) {
//            Optional<Inventory> optionalInventory = inventoryRepository.findBySkuCodeStock(skuCode);
//            if (optionalInventory.isPresent()) {
//                return true;
//            }
//        }
        //return optionalInventory.isPresent();
        List<Inventory> optionalInventory = inventoryRepository.findBySkuCodeStock(skuCodes);
        return !optionalInventory.isEmpty();
    }



}
