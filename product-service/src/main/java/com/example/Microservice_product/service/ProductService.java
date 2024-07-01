package com.example.Microservice_product.service;

import com.example.Microservice_product.dto.ProductReponse;
import com.example.Microservice_product.dto.ProductRequest;
import com.example.Microservice_product.mapper.MapProduct;
import com.example.Microservice_product.mapper.MapProductReponse;
import com.example.Microservice_product.model.Product;
import com.example.Microservice_product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
//@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final MapProductReponse mapProductReponse;
    private final MapProduct mapProduct;

    @Autowired
    private ProductService(ProductRepository productRepository, MapProduct mapProduct, MapProductReponse mapProductReponse){
        this.productRepository = productRepository;
        this.mapProduct = mapProduct;
        this.mapProductReponse = mapProductReponse;
    }

    public Product createProduct(ProductRequest productRequest) {
        Product product = mapProduct.mapToProduct(productRequest);
        product = productRepository.save(product);
        log.info("Product {} is saved", product.getId());
        return product;
    }

    public List<ProductReponse> getAllProduct() {
        List<ProductReponse> productResponseList = productRepository.findAll()
                .stream()
                .map(mapProductReponse::mapToProductResponseDto) // Method reference to mapToProductResponseDto
                .collect(Collectors.toList());
        return productResponseList;
    }
}
