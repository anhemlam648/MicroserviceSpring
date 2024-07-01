package com.example.Microservice_product.mapper;

import com.example.Microservice_product.dto.ProductReponse;
import com.example.Microservice_product.dto.ProductRequest;
import com.example.Microservice_product.model.Product;
import org.springframework.stereotype.Component;

@Component
public class MapProductReponse {
    public ProductReponse mapToProductResponseDto(Product product) {
        ProductReponse productResponse = new ProductReponse();
        productResponse.setId(product.getId());
        productResponse.setDescription(product.getDescription());
        productResponse.setName(product.getName());
        productResponse.setPrice(product.getPrice());
        return productResponse;
    }

    public Product mapToProduct(ProductReponse productResponse) {
        Product product = new Product();
        product.setId(productResponse.getId());
        product.setDescription(productResponse.getDescription());
        product.setName(productResponse.getName());
        product.setPrice(productResponse.getPrice());
        return product;
    }
}
