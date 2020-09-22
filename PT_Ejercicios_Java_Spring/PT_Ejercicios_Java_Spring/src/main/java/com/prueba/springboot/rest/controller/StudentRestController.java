package com.prueba.springboot.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.prueba.springboot.rest.utility.ValidatorRUT;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	// Inyectamos el servicio para poder hacer uso de el
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ValidatorRUT validatorRut;

	@GetMapping("/student")
	public List<Student> findAll() {
		return studentService.findAll();
	}

	@GetMapping("/student/{studentId}")
	public Student getStudent(@PathVariable int studentId) {
		Student student = studentService.findById(studentId);

		if (student == null) {
			throw new RuntimeException("Student id not found -" + studentId);
		}
		return student;
	}

	@PostMapping("/student")
	public Student addStudent(@RequestBody Student student) {
		
		boolean validator = validatorRut.validarRut(student.getRut());
		
		if (!validator) {
			throw new RuntimeException("Student rut not validator -" + student.getId());
		}
		
		if (student.getAge() < 18 ) {
			throw new RuntimeException("Student age not  -" + student.getId());
		}
		
		student.setId(0);
		studentService.save(student);
		return student;
	}

	@PutMapping("/student/{studentId}")
	public Student updateStudent(@RequestBody Student student, @PathVariable int studentId) {
		
		boolean validator = validatorRut.validarRut(student.getRut());
		
		if (!validator) {
			throw new RuntimeException("Student rut not validator -" + student.getId());
		}
		
		if (student.getAge() < 18 ) {
			throw new RuntimeException("Student age not  -" + student.getId());
		}

		student.setId(studentId);
		studentService.save(student);
  	    return student;
	}


	@DeleteMapping("student/{studentId}")
	public String deleteStudent(@PathVariable int studentId) {

		Student student = studentService.findById(studentId);

		if (student == null) {
			System.out.println("Student id not found -" + studentId);
			throw new RuntimeException("Student id not found -" + studentId);
		}

		studentService.deleteById(studentId);
		return "Deleted user id - " + studentId;
	}

}
