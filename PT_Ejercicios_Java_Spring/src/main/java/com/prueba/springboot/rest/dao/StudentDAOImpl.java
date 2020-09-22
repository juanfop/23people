package com.prueba.springboot.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.springboot.rest.entity.Student;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	@Autowired
	private EntityManager entityManager;

	// The SQL statement is implemented with JPA to list all students
	@Override
	public List<Student> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
		List<Student> student = theQuery.getResultList();
		return student;
	}

	// The SQL statement is implemented with JPA to list all students according an Id
	@Override
	public Student findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student student = currentSession.get(Student.class, id);
		return student;
	}

	// The SQL statement is implemented with JPA to UPDATE a student record
	@Override
	@Transactional
	public void save(Student student) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(student);	
		
	}

	// The SQL statement is implemented with JPA to DELETE a student record according an Id
	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		@SuppressWarnings("unchecked")
		Query<Student> theQuery = currentSession.createQuery("delete from Student where id=:idStudent");
		theQuery.setParameter("idStudent", id);
		theQuery.executeUpdate();
	}

}
