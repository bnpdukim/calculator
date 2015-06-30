package com.bnpinnovation.calculator.dao.hibernate;

import java.io.Serializable;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class AbstractDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public boolean contains( Object entity ) {
		Session session = sessionFactory.getCurrentSession();
		return session.contains(entity);
	}
	
	public Serializable persist(Object entity) {
		Session session = sessionFactory.getCurrentSession();
		return session.save(entity);
	}

	public void delete(Object entity) {
		getSession().delete(entity);
	}

}
