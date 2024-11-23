package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


public interface DaoInterface extends JpaRepository<Employee, Integer>{

	List<Employee> findByDept(String string);

}
