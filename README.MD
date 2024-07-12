# Microservice Product

![Microservice Product Logo](/image/LogoMicroservie.png)

Microservice Product is a simple microservice built with Spring Boot and MongoDB for managing product information.

## Installation

To run this project on your machine, you need to install Java Development Kit (JDK), Maven, and MongoDB.

```bash
# Navigate to the project directory
cd Microservice-product

# Run the application using Maven
mvn spring-boot:run

#Tracing zipkin
run docker run -d -p 9411:9411 openzipkin/zipkin
