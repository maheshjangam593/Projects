package com.example.demo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	DaoInterface dao;

	@GetMapping("/dept")
	public ResponseEntity<List<List<Employee>>> getMultipleValues(@RequestParam List<String> dept) {
		// String[] split = list.split(",");
		List<List<Employee>> emp = new ArrayList<>();
		for (String string : dept) {
			emp.add(dao.findByDept(string));

		}
		return new ResponseEntity<List<List<Employee>>>(emp, HttpStatus.OK);
	}

	@GetMapping("/salary")
	public ResponseEntity<List<Employee>> getMultipleEmplyessSortBy(@RequestParam String salary) {
		// String[] split = list.split(",");
		// List<Employee> emp = new ArrayList();

		Sort ascending = Sort.by(salary).ascending();

		List<Employee> employees = dao.findAll(ascending);

		return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
	}

	@GetMapping("/dept/salary")
	public ResponseEntity<List<Employee>> getMultipleValuesBydeptAndBySalarySorting(@RequestParam List<String> dept,
			@RequestParam(defaultValue = "Hi") String salary) {
		// String[] split = list.split(",");
		List<List<Employee>> emp = new ArrayList<>();

		for (String string : dept) {
			emp.add(dao.findByDept(string));
		}
		List<Employee> employesSortedBySalary = emp.stream().flatMap(s -> s.stream())
				.sorted(Comparator.comparingLong((Employee::getSalary))).collect(Collectors.toList());
		return new ResponseEntity<List<Employee>>(employesSortedBySalary, HttpStatus.OK);
	}

	@GetMapping("/dept/sortBy")
	public ResponseEntity<List<Employee>> getMultipleValuesBydeptAndSortedByAny(@RequestParam List<String> dept,
			@RequestParam(defaultValue = "Hi") String sortBy) {
		// String[] split = list.split(",");
		List<List<Employee>> emp = new ArrayList<>();
		List<Employee> employesSortedBySalary = new ArrayList<Employee>();
		for (String string : dept) {
			emp.add(dao.findByDept(string));
		}
		if (sortBy.equalsIgnoreCase("salary")) {
			employesSortedBySalary = emp.stream().flatMap(s -> s.stream())
					.sorted(Comparator.comparingLong((Employee::getSalary))).collect(Collectors.toList());
		} else if (sortBy.equalsIgnoreCase("name")) {

			employesSortedBySalary = emp.stream().flatMap(s -> s.stream())
					.sorted(Comparator.comparing((Employee::getName))).collect(Collectors.toList());
		} else if (sortBy.equalsIgnoreCase("dept")) {

			employesSortedBySalary = emp.stream().flatMap(s -> s.stream())
					.sorted(Comparator.comparing((Employee::getDept))).collect(Collectors.toList());
		}
		return new ResponseEntity<List<Employee>>(employesSortedBySalary, HttpStatus.OK);
	}

	@GetMapping("/pathv/{id}")
	public void checkPathVariable(@PathVariable int id) {
		System.out.println("PathVariable ID  " + id);
	}

	@GetMapping("/pathp")
	public ResponseEntity<String> checkRequestParam(@RequestParam(defaultValue = "12") int id) {
		System.out.println("Request Param ID  " + id);
		return new ResponseEntity<String>("id " + id, HttpStatus.OK);

	}

	@GetMapping("/employees")
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@PostMapping("/post")
	public Employee addEmp(@RequestBody Employee emp) {
		return dao.save(emp);
	}

	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
		// return employeeRepository.findById(id).get();
		Optional<com.example.demo.Employee> employee = dao.findById(id);
		// return ResponseEntity.ok(employee);
		return new ResponseEntity<Employee>(HttpStatus.ACCEPTED);
	}

}
