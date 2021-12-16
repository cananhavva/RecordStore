package com.canan.controller;

import java.util.Optional;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.canan.entity.LoginEntity;

public class LoginController implements Controllable<LoginEntity> {
	
	@Override
	// create
	public void create(LoginEntity entity) {
		
	}
	
	// silmek
	@Override
	public void delete(LoginEntity entity) {
		
	}
	
	// güncellemek
	@Override
	public void update(LoginEntity entity) {
		
	}
	
	// find
	@Override
	
	public LoginEntity find(long id) {
		Session session = databaseConnectionHibernate();
		LoginEntity entity;
		try {
			entity = session.find(LoginEntity.class, id);
			
			if (entity != null) {
				System.out.println("bulundu... " + entity);
				return entity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı...");
				return null;
			}
		} catch (Exception e) {
			System.out.println("find anında hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		return null;
	}
	
	public Optional<LoginEntity> find(String username, String password) {
		try {
			Session session = databaseConnectionHibernate();
			String hql = "select u from LoginEntity as u where u.username=:uName and u.password=:password";
			
			TypedQuery<LoginEntity> typedQuery = session.createQuery(hql, LoginEntity.class);
			
			typedQuery.setParameter("uName", username.trim());
			typedQuery.setParameter("password", password);
			
			Optional<LoginEntity> user = Optional.of(typedQuery.getSingleResult());
			
			System.out.println(this.getClass().getSimpleName() + " - User found <<<" + user.get().getId() + ">>>");
			return user;
		} catch (Exception e) {
			System.err.println(this.getClass().getSimpleName() + " - " + e.getLocalizedMessage());
		}
		return Optional.empty();
	}
}