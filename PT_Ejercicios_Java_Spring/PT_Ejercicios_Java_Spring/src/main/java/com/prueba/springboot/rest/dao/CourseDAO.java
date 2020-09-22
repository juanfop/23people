package com.prueba.springboot.rest.dao;

import java.util.List;

import com.prueba.springboot.rest.entity.Course;

public interface CourseDAO {
	
	public List<Course> findAll();

	public Course findById(int id);

	public void save(Course course);

	public void deleteById(int id);

}
