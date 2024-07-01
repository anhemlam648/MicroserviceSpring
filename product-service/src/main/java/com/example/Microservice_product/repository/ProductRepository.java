package com.example.Microservice_product.repository;

import com.example.Microservice_product.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {
}
