package com.prueba.springboot.rest.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.prueba.springboot.rest.entity.Student;
import com.prueba.springboot.rest.service.StudentServiceImpl;


@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentRestController.class)
public class StudentRestControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Mock
    StudentServiceImpl studentService;
	
	String exampleStudentJson = "{\"id\":\6,\"rut\":\"20400628-8\",\"name\":\"student6\",\"lastName\":\"lastName6\",\"age\":\35,\"course\":\"course6\"}";

	Student mockStudent = new Student(6, "23261333-5", "student6", "lastName6", 35, "course6");
	
	@Test
	public void testAddStudent() throws Exception {
		
				Mockito.when(
						studentService.save(Mockito.any(Student.class))).thenReturn(true);

				RequestBuilder requestBuilder = MockMvcRequestBuilders
						.post("/student/")
						.accept(MediaType.APPLICATION_JSON).content(exampleStudentJson)
						.contentType(MediaType.APPLICATION_JSON);

				MvcResult result = mockMvc.perform(requestBuilder).andReturn();

				MockHttpServletResponse response = result.getResponse();

				assertEquals(HttpStatus.CREATED.value(), response.getStatus());

				assertEquals("http://localhost/api/student/",
						response.getHeader(HttpHeaders.LOCATION));
	}

}
