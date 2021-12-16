package com.canan.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.canan.entity.UserEntity;

public class UserEntityController implements Controllable<UserEntity> {
	@Override
	public void create(UserEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			System.out.println(session);
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ekleme tamamdır" + Controllable.class);
		} catch (Exception e) {
			System.out.println("ekleme anında hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(UserEntity entity) {
		
		try {
			UserEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Basarili " + UserEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(UserEntity entity) {
		try {
			UserEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("G�ncelleme Ba�ar�l� " + UserEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("g�ncelleme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<UserEntity> list(int rowCount) {
		Session session = databaseConnectionHibernate();
		
		if (rowCount == -1) {
			String hql = "select str from UserEntity as str where str.id>=:key";
			TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
			
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<UserEntity> arrayList = (ArrayList<UserEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + UserEntity.class);
			return arrayList;
		} else {
			String hql = "select str from UserEntity as str where str.id>=:key";
			TypedQuery<UserEntity> typedQuery = session.createQuery(hql, UserEntity.class);
			typedQuery.setMaxResults(rowCount);
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<UserEntity> arrayList = (ArrayList<UserEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + UserEntity.class);
			return arrayList;
		}
	}
	
	@Override
	public UserEntity find(long id) {
		Session session = databaseConnectionHibernate();
		UserEntity entity;
		try {
			entity = session.find(UserEntity.class, id);
			
			if (entity != null) {
				System.out.println("bulundu... " + entity);
				return entity;
			} else {
				System.out.println("Arad���n�z kriterde sonu�lar bulunamad� ...");
				return null;
			}
		} catch (Exception e) {
			System.out.println("find an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public UserEntity singleResult(long id) {
		return Controllable.super.singleResult(id);
	}
	
}