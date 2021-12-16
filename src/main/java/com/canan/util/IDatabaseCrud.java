package com.canan.util;

import java.util.ArrayList;

import org.hibernate.Session;

public interface IDatabaseCrud<T> {
	
	public void create(T entity);// ekleme
	
	public void delete(T entity);// silmek
	
	public void update(T entity);// güncelleme
	
	default ArrayList<T> list() {// listeleme
		return null;
	}
	
	default T find(long id) {
		return null;
	}
	
	default T singleResult(long id) {
		return null;
	}
	
	// gövdeli method
	default Session databaseConnectionHibernate() {
		return HibernateUtil.getSessionfactory().openSession();
	}
	
}
