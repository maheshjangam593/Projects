package com.example.Json.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
	private String orderId;
	private String name;
	private int quantity;
	private double price;
	

}
