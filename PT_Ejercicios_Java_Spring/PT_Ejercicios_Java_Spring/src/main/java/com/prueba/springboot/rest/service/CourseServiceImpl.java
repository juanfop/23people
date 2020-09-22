package com.prueba.springboot.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.prueba.springboot.rest.dao.CourseDAO;
import com.prueba.springboot.rest.entity.Course;

@Service
public class CourseServiceImpl implements CourseService {
	
	@Autowired
	private CourseDAO courseDAO;

	@Override
	public List<Course> findAll() {
		List<Course> listCourse =  courseDAO.findAll();
		return listCourse;
	}

	@Override
	public Course findById(int id) {
		Course course = courseDAO.findById(id);
		return course;
	}

	@Override
	public void save(Course course) {
		courseDAO.save(course);
		
	}

	@Override
	public void deleteById(int id) {
		courseDAO.deleteById(id);
		
	}

	
}
