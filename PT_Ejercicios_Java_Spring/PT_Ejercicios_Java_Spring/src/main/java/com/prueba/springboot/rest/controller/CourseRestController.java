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

import com.prueba.springboot.rest.entity.Course;
import com.prueba.springboot.rest.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseRestController {

	// Inyectamos el servicio para poder hacer uso de el
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/course")
	public List<Course> findAll() {
		return courseService.findAll();
	}

	@GetMapping("/course/{courseId}")
	public Course getCourse(@PathVariable int courseId) {
		Course course = courseService.findById(courseId);

		if (course == null) {
			throw new RuntimeException("Student id not found -" + courseId);
		}

		return course;
	}

	@PostMapping("/course")
	public Course addCourse(@RequestBody Course course) {
		
		if (course.getCode().length() > 4 ) {
			throw new RuntimeException("Course code to larger -" + course.getId());
		}
	
		course.setId(0);
		courseService.save(course);
		return course;
	}

	@PutMapping("/course/{courseId}")
	public Course updateCourse(@RequestBody Course course, @PathVariable int courseId) {
		
		if (course.getCode().length() > 4 ) {
			throw new RuntimeException("Course code to larger -" + course.getId());
		}

		course.setId(courseId);
		courseService.save(course);
		return course;
	}


	@DeleteMapping("course/{courseId}")
	public String deleteCourse(@PathVariable int courseId) {

		Course course = courseService.findById(courseId);

		if (course == null) {
			System.out.println("Student id not found -" + courseId);
			throw new RuntimeException("Student id not found -" + courseId);
		}

		courseService.deleteById(courseId);
		return "Deleted user id - " + courseId;
	}

}
