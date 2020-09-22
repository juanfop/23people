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

	@Override
	public List<Student> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
		List<Student> student = theQuery.getResultList();
		return student;
	}

	@Override
	public Student findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Student student = currentSession.get(Student.class, id);
		return student;
	}

	@Override
	@Transactional
	public void save(Student student) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(student);	
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Student> theQuery = currentSession.createQuery("delete from Student where id=:idStudent");
		theQuery.setParameter("idStudent", id);
		theQuery.executeUpdate();
	}

}
