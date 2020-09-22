package com.prueba.springboot.rest.service;

import java.util.List;

import com.prueba.springboot.rest.entity.Student;

public interface StudentService {
	
    public List<Student> findAll();
	
	public Student findById(int id);
	
	public boolean save(Student student);
	
	public void deleteById(int id);
	
}
