package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.controller.Demo1;

public interface DemoRepo extends JpaRepository<Demo1, Integer> {

}
