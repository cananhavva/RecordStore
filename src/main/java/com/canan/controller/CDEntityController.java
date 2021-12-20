package com.canan.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.canan.entity.CDEntity;
import com.canan.util.IDatabaseCrud;

public class CDEntityController implements IDatabaseCrud<CDEntity> {
	@Override
	public void create(CDEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			System.out.println(session);
			session.persist(entity);
			session.getTransaction().commit();
			System.out.println("ekleme tamamdır" + IDatabaseCrud.class);
		} catch (Exception e) {
			System.out.println("ekleme anında hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
	}
	
	@Override
	public void delete(CDEntity entity) {
		
		try {
			CDEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Ba�ar�l� " + CDEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(CDEntity entity) {
		try {
			CDEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setAlbumName(entity.getAlbumName());
				findEntity.setGenres(entity.getGenres());
				findEntity.setPrice(entity.getPrice());
				findEntity.setStatus(entity.getStatus());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Başarılı " + CDEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("güncelleme anında hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
	}
	
	public ArrayList<CDEntity> list(int rowCount) {
		Session session = databaseConnectionHibernate();
		
		if (rowCount == -1) {
			String hql = "select str from CDEntity as str where str.id>=:key";
			TypedQuery<CDEntity> typedQuery = session.createQuery(hql, CDEntity.class);
			
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<CDEntity> arrayList = (ArrayList<CDEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + CDEntity.class);
			return arrayList;
		} else {
			String hql = "select str from CDEntity as str where str.id>=:key";
			TypedQuery<CDEntity> typedQuery = session.createQuery(hql, CDEntity.class);
			typedQuery.setMaxResults(rowCount);
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<CDEntity> arrayList = (ArrayList<CDEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + CDEntity.class);
			return arrayList;
		}
	}
	
	@Override
	public CDEntity find(long id) {
		Session session = databaseConnectionHibernate();
		CDEntity entity;
		try {
			entity = session.find(CDEntity.class, id);
			
			if (entity != null) {
				System.out.println("bulundu... " + entity);
				return entity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			System.out.println("find anında hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public CDEntity singleResult(long id) {
		return IDatabaseCrud.super.singleResult(id);
	}
	
}