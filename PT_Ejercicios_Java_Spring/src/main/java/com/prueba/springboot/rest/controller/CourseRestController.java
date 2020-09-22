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

import com.prueba.springboot.rest.entity.Course;
import com.prueba.springboot.rest.service.CourseService;

@RestController
@RequestMapping("/api")
public class CourseRestController {

	// The service is injected
	@Autowired
	private CourseService courseService;

	// GET method to list all course's record
	@GetMapping("/course")
	public ResponseEntity<?> findAll() {

		List<Course> course = null;

		course = courseService.findAll();

		if (course.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	// GET method to list a course's record according to id
	@GetMapping("/course/{courseId}")
	public ResponseEntity<?> getCourse(@PathVariable int courseId) {
		Course course = courseService.findById(courseId);

		if (course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	// POST method to create new course's record
	@PostMapping("/course")
	public ResponseEntity<?> addCourse(@RequestBody Course course) {

		course.setId(0);
		boolean result = courseService.save(course);

		if (result == false) {
			return new ResponseEntity<>(course, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(course, HttpStatus.CREATED);
	}

	// PUT method to update a course's record
	@PutMapping("/course/{courseId}")
	public ResponseEntity<?> updateCourse(@RequestBody Course course, @PathVariable int courseId) {

		course.setId(courseId);
		boolean result = courseService.save(course);

		if (result == false) {
			return new ResponseEntity<>(course, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

	// DELETE method to delete a course's record according to Id
	@DeleteMapping("course/{courseId}")
	public ResponseEntity<?> deleteCourse(@PathVariable int courseId) {

		Course course = courseService.findById(courseId);

		if (course == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		courseService.deleteById(courseId);

		return new ResponseEntity<>(course, HttpStatus.OK);
	}

}
