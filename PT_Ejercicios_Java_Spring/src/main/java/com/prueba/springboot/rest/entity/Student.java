package com.prueba.springboot.rest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// The Student class is implemented
@Entity
@Table(name="Student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private int id;
	
	@Column(name="rut")
	private String rut;
	
	@Column(name="name")
	private String name;
	
	@Column(name="lastName")
	private String lastName;
	
	@Column(name="age")
	private int age;
	
	@Column(name="course")
	private String course;

	// Default constructor
	public Student() {
	}

	// Constructor with corresponding attributes and parameters
	public Student(int id, String rut, String name, String lastName, int age, String course) {
		super();
		this.id = id;
		this.rut = rut;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.course = course;
	}

	// Getters and Setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}
	
	// toString method
	@Override
	public String toString() {
		return "Student [id=" + id + ", rut=" + rut + ", name=" + name + ", lastName=" + lastName
				+ ", age=" + age + ", course=" + course + "]";
	}
	
}
