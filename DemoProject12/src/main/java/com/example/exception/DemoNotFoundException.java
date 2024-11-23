package com.example.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemoNotFoundException extends RuntimeException {

	private int id;

	public DemoNotFoundException(int id) {
		super(String.format("Id with %s is not found ", id));
		this.id = id;
	}

}
