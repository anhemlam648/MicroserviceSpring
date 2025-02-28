package com.example.Microservice_order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebConfig {

    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }
//    @Bean
//    public WebClient webClient(WebClient){
////        return WebClient.builder().baseUrl("http://localhost:8082").build();
//        return WebClient.builder().baseUrl("http://inventory-service").build();
//    }
    @Bean
    public WebClient webClient(WebClient.Builder webClientBuilder) {
        return webClientBuilder.baseUrl("http://inventory-service").build();
    }
}
