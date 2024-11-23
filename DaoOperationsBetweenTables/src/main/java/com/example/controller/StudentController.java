package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.StudentDao;
import com.example.dao.SubjectDao;
import com.example.entity.Student;
import com.example.entity.StudentNotFoundException;
import com.example.entity.Subject;
import com.example.entity.SubjectNotFoundException;

@RestController
@RequestMapping("/api")
public class StudentController {

	@GetMapping("/size")
	public ResponseEntity<List<String>> getMultipleValues(@RequestParam List<String> list) {
		// String[] split = list.split(",");

		return new ResponseEntity<List<String>>(list, HttpStatus.OK);
	}

	@Autowired
	private StudentDao student;

	@Autowired
	private SubjectDao subject;

	@PostMapping("student/addStudent")
	public Student postStudent(@RequestBody Student record) {
		return student.save(record);

	}

	@PostMapping("subject/addSubject")
	public Subject postSubject(@RequestBody Subject record) {
		return subject.save(record);
	}

	@GetMapping("student/getAllStudents")
	public List<Student> postStudent() {
		return student.findAll();

	}

	@GetMapping("subject/getAllSubjects")
	public List<Subject> postSubject() {
		return subject.findAll();
	}

	/*
	 * @PutMapping("student/{sId}/subject/{subId}") public Student
	 * addSujectToStudent(@PathVariable int sId, @PathVariable int subId)
	 * 
	 * { Student student1 = student.findById(sId) .orElseThrow(() -> new
	 * StudentNotFoundException("Student Not found with Id " + sId)); Subject
	 * subject1 = subject.findById(subId) .orElseThrow(() -> new
	 * SubjectNotFoundException("Subject Not found with SID " + subId));
	 * 
	 * student1.setSubjects(Arrays.asList(subject1)); subject1.setStudent(student1);
	 * 
	 * student.save(student1);
	 * 
	 * return student1;
	 * 
	 * }
	 */

	@PostMapping("subject/{subId}/student/{sId}")
	public Subject addStudentToSubject(@PathVariable int subId, @PathVariable int sId)

	{
		Subject subject1 = subject.findById(subId)
				.orElseThrow(() -> new SubjectNotFoundException("Subject Not found with SID " + subId));

		Student student1 = student.findById(sId)
				.orElseThrow(() -> new StudentNotFoundException("Student Not found with Id " + sId));

		// subject1.setStudent(student1); //student.save(student1);
		subject.save(subject1);

		return subject1;

	}

	@DeleteMapping("student/{sId}")
	public ResponseEntity<String> deleteStudent(@PathVariable int sId)

	{
		Student student1 = student.findById(sId)
				.orElseThrow(() -> new StudentNotFoundException("Student Not found with Id " + sId));

		student.deleteById(sId);

		return new ResponseEntity<String>(HttpStatus.OK);

	}

}
