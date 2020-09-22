package com.prueba.springboot.rest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.springboot.rest.entity.Student;
import com.prueba.springboot.rest.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// The service is injected
	@Autowired
	private StudentService studentService;

	// GET method to list all student's record
	@GetMapping("/student")
	public ResponseEntity<?> findAll() {

		List<Student> student = null;

		student = studentService.findAll();

		if (student.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	// GET method to list a student's record according to id
	@GetMapping("/student/{studentId}")
	public ResponseEntity<?> getStudent(@PathVariable int studentId) {

		Student student = studentService.findById(studentId);

		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	// POST method to create new student's record
	@PostMapping("/student")
	public ResponseEntity<?> addStudent(@RequestBody Student student) {

		student.setId(0);
		boolean result = studentService.save(student);

		if (result == false) {
			return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	// PUT method to update a student's record
	@PutMapping("/student/{studentId}")
	public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable int studentId) {

		student.setId(studentId);
		boolean result = studentService.save(student);

		if (result == false) {
			return new ResponseEntity<>(student, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(student, HttpStatus.OK);
	}

	// DELETE method to delete a student's record according to Id
	@DeleteMapping("student/{studentId}")
	public ResponseEntity<?> deleteStudent(@PathVariable int studentId) {

		Student student = studentService.findById(studentId);

		if (student == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		studentService.deleteById(studentId);

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
