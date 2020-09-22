package com.prueba.springboot.rest.dao;

import java.util.List;
import com.prueba.springboot.rest.entity.Student;

//An INTERFACE class is implemented with method signatures
public interface StudentDAO {
	
    public List<Student> findAll();
	
	public Student findById(int id);
	
	public void save(Student student);
	
	public void deleteById(int id);

}
