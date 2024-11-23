package com.example.DateApplication.service;

import com.example.DateApplication.dao.StudentDao;
import com.example.DateApplication.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentRepo;

    public Student addStudent(String student)
    {
        LocalDate parse = LocalDate.parse(student);
        Student student1=new Student();
        student1.setDate(parse);
        return studentRepo.save(student1);
    }
    public List<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }

    public Student getStudentById(Integer id) {
        Student student = studentRepo.findById(id).get();

        return student;
    }
}
