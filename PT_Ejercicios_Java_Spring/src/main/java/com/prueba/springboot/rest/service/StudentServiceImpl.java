package com.prueba.springboot.rest.service;

//DTO implement

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.springboot.rest.dao.StudentDAO;
import com.prueba.springboot.rest.entity.Student;
import com.prueba.springboot.rest.util.ValidatorRUT;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Autowired
	private ValidatorRUT validatorRut;

	@Override
	public List<Student> findAll() {
		List<Student> listStudent =  studentDAO.findAll();
		return listStudent;
	}

	@Override
	public Student findById(int id) {
		Student student = studentDAO.findById(id);
		return student;
	}

	@Override
	public boolean save(Student student) {
		boolean validator = validatorRut.validarRut(student.getRut());

		if (!validator) {
			return false;
		}
		
		if (student.getAge() < 18) {
			return false;
		}
			
		studentDAO.save(student);
		return true;
		
	}

	@Override
	public void deleteById(int id) {
		studentDAO.deleteById(id);
	}

}
