package com.prueba.springboot.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.prueba.springboot.rest.entity.Course;

@Repository
public class CourseDAOImpl implements CourseDAO {
	
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Course> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Course> theQuery = currentSession.createQuery("from Course", Course.class);
		List<Course> course = theQuery.getResultList();
		return course;
	}

	@Override
	public Course findById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Course course = currentSession.get(Course.class, id);
		return course;
	}

	@Override
	@Transactional
	public void save(Course course) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(course);
		
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Course> theQuery = currentSession.createQuery("delete from Course where id=:idCourse");
		theQuery.setParameter("idCourse", id);
		theQuery.executeUpdate();
		
	}

}
