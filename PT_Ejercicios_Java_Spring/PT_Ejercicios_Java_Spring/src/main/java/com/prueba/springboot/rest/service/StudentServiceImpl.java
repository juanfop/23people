package com.prueba.springboot.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.springboot.rest.dao.StudentDAO;
import com.prueba.springboot.rest.entity.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDAO studentDAO;

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
	public void save(Student student) {
		studentDAO.save(student);
		
	}

	@Override
	public void deleteById(int id) {
		studentDAO.deleteById(id);
	}

}
