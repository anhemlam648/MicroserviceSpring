package com.example.Inventory_service.repository;

import com.example.Inventory_service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//    Optional<Inventory> findBySkuCode(String skuCode);

    List<Inventory> findBySkuCodeIn(List<String> skuCodes);
}
