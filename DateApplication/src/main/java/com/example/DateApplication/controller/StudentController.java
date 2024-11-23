package com.example.DateApplication.controller;

import com.example.DateApplication.entity.Student;
import com.example.DateApplication.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
        @Autowired
    private StudentService studentService;
        @PostMapping("/addStudent")
        public Student addStudent(@RequestBody String student)
        {
          return  studentService.addStudent(student);
        }
        @GetMapping("/getStudents")
        public List<Student> getStudents()
        {
            return studentService.getAllStudents();
        }
    @GetMapping("/getStudent/{id}")
    public Student getStudentById(@PathVariable int id)
    {
        return studentService.getStudentById(id);
    }
}

