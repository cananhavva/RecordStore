package com.canan.controller;

import java.util.ArrayList;

import org.hibernate.Session;

import com.canan.util.HibernateUtil;

public interface Controllable<T> {
	public void create(T entity);// ekleme
	
	public void delete(T entity);// silmek
	
	public void update(T entity);// g�ncelleme
	
	default ArrayList<T> list(int rowCount) {// listeleme
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
