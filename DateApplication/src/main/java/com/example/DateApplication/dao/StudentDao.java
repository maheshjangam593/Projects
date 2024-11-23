package com.example.DateApplication.dao;

import com.example.DateApplication.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
}
