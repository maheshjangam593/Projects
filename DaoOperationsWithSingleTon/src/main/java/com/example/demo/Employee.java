package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
@Table(name = "Employee")
public class Employee {

	@Id
	// @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;
	private long salary;

	private String dept;

	public Employee() {
		super();
	}

	public Employee(int id, String name, long salary, String dept) {
		this.id = id;
		this.name = name;
		this.salary = salary;
		this.dept = dept;
	}

}
