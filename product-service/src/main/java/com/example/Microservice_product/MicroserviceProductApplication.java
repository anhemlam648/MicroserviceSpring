package com.example.Microservice_product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MicroserviceProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProductApplication.class, args);
	}

}
