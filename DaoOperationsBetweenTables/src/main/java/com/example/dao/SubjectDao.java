package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Subject;

public interface SubjectDao extends JpaRepository<Subject, Integer> {

}
