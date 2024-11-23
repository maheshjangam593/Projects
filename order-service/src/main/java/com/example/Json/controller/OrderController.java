package com.example.Json.controller;

import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Json.dto.Order;
import com.example.Json.dto.OrderEvent;
import com.example.Json.kafka.OrderProducer;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
	
	private OrderProducer orderProducer;

	public OrderController(OrderProducer orderProducer) {
		super();
		this.orderProducer = orderProducer;
	}
	 
	@PostMapping("/orders")
	public String placeOrder(@RequestBody Order order)
	{
		order.setOrderId(UUID.randomUUID().toString());
		
		OrderEvent orderEvent=new OrderEvent();
		orderEvent.setStatus("Pending");
		orderEvent.setMessage("Order status is in pending state");
		orderEvent.setOrder(order);
		
		orderProducer.sendMessage(orderEvent);
		
		return "Order Placed Successfully";
		
 
	}
	
	
	
	

}
