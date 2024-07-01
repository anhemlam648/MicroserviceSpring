package com.example.Microservice_order.controller;

import com.example.Microservice_order.dto.DtoOrder;
import com.example.Microservice_order.model.Order;
import com.example.Microservice_order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity createOrder (@RequestBody() DtoOrder dtoOrder){
        try {
            Order createdOrder = orderService.createOrder(dtoOrder);
            return ResponseEntity.ok(createdOrder);
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create order: " + ex.getMessage());
        }
    }
    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Object> getAllOrders(){
        try{
            return ResponseEntity.ok(orderService.getAllOrders());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve orders: " + ex.getMessage());
        }
    }

}
