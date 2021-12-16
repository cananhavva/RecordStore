package com.canan.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.canan.entity.RecordEntity;

public class RecordEntityController implements Controllable<RecordEntity> {
	@Override
	public void create(RecordEntity entity) {
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
	public void delete(RecordEntity entity) {
		
		try {
			RecordEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Ba�ar�l� " + RecordEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(RecordEntity entity) {
		try {
			RecordEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setName(entity.getName());
				findEntity.setYear(entity.getYear());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Başarılı " + RecordEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("güncelleme anında hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public ArrayList<RecordEntity> list(int rowCount) {
		Session session = databaseConnectionHibernate();
		
		if (rowCount == -1) {
			String hql = "select str from RecordEntity as str where str.id>=:key";
			TypedQuery<RecordEntity> typedQuery = session.createQuery(hql, RecordEntity.class);
			
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<RecordEntity> arrayList = (ArrayList<RecordEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + RecordEntity.class);
			return arrayList;
		} else {
			String hql = "select str from RecordEntity as str where str.id>=:key";
			TypedQuery<RecordEntity> typedQuery = session.createQuery(hql, RecordEntity.class);
			typedQuery.setMaxResults(rowCount);
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<RecordEntity> arrayList = (ArrayList<RecordEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + RecordEntity.class);
			return arrayList;
		}
	}
	
	@Override
	public RecordEntity find(long id) {
		Session session = databaseConnectionHibernate();
		RecordEntity entity;
		try {
			entity = session.find(RecordEntity.class, id);
			
			if (entity != null) {
				System.out.println("bulundu... " + entity);
				return entity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			System.out.println("find anında hata meydana geldi !!!!! " + Controllable.class);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public RecordEntity singleResult(long id) {
		return Controllable.super.singleResult(id);
	}
	
}