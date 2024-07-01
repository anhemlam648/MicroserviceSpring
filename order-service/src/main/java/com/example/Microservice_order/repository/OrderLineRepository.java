package com.example.Microservice_order.repository;

import com.example.Microservice_order.model.OrderLineItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLineItems,Long> {
}
