package com.example.demo.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ApiResponse {

	private String message;
	private boolean success;
}
