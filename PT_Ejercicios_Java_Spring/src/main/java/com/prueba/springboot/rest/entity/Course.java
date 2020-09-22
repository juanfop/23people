package com.prueba.springboot.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//The Course class is implemented
@Entity
@Table(name="Course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="code")
	private String code;
	
	// Default constructor
	public Course() {
	}

	// Constructor with corresponding attributes and parameters
	public Course(int id, String name, String code) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
	}
	
	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", code=" + code + "]";
	}
}
