package com.example.Microservice_order.controller;

import com.example.Microservice_order.dto.DtoOrderLineItems;
import com.example.Microservice_order.model.OrderLineItems;
import com.example.Microservice_order.service.OrderLineItemss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/oderline")
public class OrderLineController {
    @Autowired
    private OrderLineItemss orderLineItemss;

    @PostMapping("/add")
    @ResponseBody
    private ResponseEntity createOderLine (@RequestBody() DtoOrderLineItems dtoOrderLineItems){
        try{
            OrderLineItems orderLineItems = orderLineItemss.createOrderLineItem(dtoOrderLineItems);
            return ResponseEntity.ok(orderLineItems);
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to create orderLineItems: " + ex.getMessage());
        }
    }
    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Object> getAllOrderLineItems(){
        try{
            return ResponseEntity.ok(orderLineItemss.getAllOrderLineItems());
        }catch(Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve orderLineItems: " + ex.getMessage());
        }
    }
}
