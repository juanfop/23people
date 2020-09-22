package com.prueba.springboot.rest.dao;

import java.util.List;
import com.prueba.springboot.rest.entity.Student;

public interface StudentDAO {
	
    public List<Student> findAll();
	
	public Student findById(int id);
	
	public void save(Student student);
	
	public void deleteById(int id);

}
