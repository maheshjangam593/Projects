package com.example.Json.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.Json.dto.OrderEvent;

@Service
public class OrderConsumer {

	private static final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);

	@KafkaListener(topics = "order_topics", groupId = "${spring.kafka.consumer.group-id}")
	public void consume(OrderEvent event) {

		logger.info(String.format("Order event recieved in stock service %s", event.toString()));
		
		// if we want to save data we can save using mysql and jpa save method with one entity class
	}

}
