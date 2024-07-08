package com.example.Inventory_service.service;

import com.example.Inventory_service.dto.Dtoinventory;
import com.example.Inventory_service.model.Inventory;
import com.example.Inventory_service.repository.InventoryRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Service
public class ServiceInventory {

    private final InventoryRepository inventoryRepository;

    @Autowired
    public ServiceInventory(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }

//    @Transactional(readOnly = true)
//    public List<Dtoinventory> isInStock(List<String> skuCodes) {
////        Optional<Inventory> optionalInventory = inventoryRepository.findBySkuCodeStock(skuCodes);
////        for (String skuCode : skuCodes) {
////            Optional<Inventory> optionalInventory = inventoryRepository.findBySkuCodeStock(skuCode);
////            if (optionalInventory.isPresent()) {
////                return true;
////            }
////        }
//        //return optionalInventory.isPresent();
//        List<Inventory> inventories = inventoryRepository.findBySkuCodeIn(skuCodes);
//        List<Dtoinventory> dtoInventories = inventories.stream()
//                .map(inventory -> Dtoinventory.builder()
//                        .skuCode(inventory.getSkuCode())
//                        .isInStock(inventory.getQuantity() > 0) // Check if quantity is greater than 0
//                        .build())
//                .collect(Collectors.toList());
////        return !optionalInventory.isEmpty();
//        return dtoInventories;
//    }
    @Transactional(readOnly = true)
    public List<Dtoinventory> isInStock(List<String> skuCodes) {
        List<Inventory> inventories = inventoryRepository.findBySkuCodeIn(skuCodes);
        List<Dtoinventory> dtoInventories = inventories.stream()
                .map(inventory -> Dtoinventory.builder()
                        .skuCode(inventory.getSkuCode())
                        .isInStock(inventory.getQuantity() > 0) // kiểm tra nếu giá trị lớn hơn 0
                        .build())
                .collect(Collectors.toList());
        return dtoInventories;
    }


}
