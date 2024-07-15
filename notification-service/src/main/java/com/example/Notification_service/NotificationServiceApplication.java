package com.example.Notification_service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;

@SpringBootApplication
@Slf4j
public class NotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificationServiceApplication.class, args);
	}

	@KafkaListener(topics = "notification",groupId = "notificationId")
	public void handleNotification(PlaceOrderEvent placeOrderEvent){
		log.info("Notification for Order - {}", placeOrderEvent.getNumberOrder());
	}
}
