package com.example.Microservice_product.controller;

import com.example.Microservice_product.dto.ProductReponse;
import com.example.Microservice_product.dto.ProductRequest;
import com.example.Microservice_product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    //call api Product Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
       productService.createProduct(productRequest);
    }
    //call api Product List
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductReponse> getAllProduct(){
        return productService.getAllProduct();
    }
}
