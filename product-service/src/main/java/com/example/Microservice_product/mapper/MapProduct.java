package com.example.Microservice_product.mapper;

import com.example.Microservice_product.dto.ProductRequest;
import com.example.Microservice_product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class MapProduct {
    public ProductRequest mapToProductDto(Product product) {
        ProductRequest productRequest = new ProductRequest();
        productRequest.setDescription(product.getDescription());
        productRequest.setName(product.getName());
        productRequest.setPrice(product.getPrice());
        return productRequest;
    }

    public Product mapToProduct(ProductRequest productRequest) {
        Product product = new Product();
        product.setDescription(productRequest.getDescription());
        product.setName(productRequest.getName());
        product.setPrice(productRequest.getPrice());
        return product;
    }
}
