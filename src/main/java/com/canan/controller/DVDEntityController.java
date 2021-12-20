package com.canan.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.canan.entity.DVDEntity;
import com.canan.util.IDatabaseCrud;

public class DVDEntityController implements IDatabaseCrud<DVDEntity> {
	@Override
	public void create(DVDEntity entity) {
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
	public void delete(DVDEntity entity) {
		
		try {
			DVDEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Ba�ar�l� " + DVDEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(DVDEntity entity) {
		try {
			DVDEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setAlbumName(entity.getAlbumName());
				findEntity.setGenres(entity.getGenres());
				findEntity.setPrice(entity.getPrice());
				findEntity.setStatus(entity.getStatus());
				findEntity.setQuality(entity.getQuality());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Başarılı " + DVDEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("güncelleme anında hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
	}
	
	public ArrayList<DVDEntity> list(int rowCount) {
		Session session = databaseConnectionHibernate();
		
		if (rowCount == -1) {
			String hql = "select str from DVDEntity as str where str.id>=:key";
			TypedQuery<DVDEntity> typedQuery = session.createQuery(hql, DVDEntity.class);
			
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<DVDEntity> arrayList = (ArrayList<DVDEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + DVDEntity.class);
			return arrayList;
		} else {
			String hql = "select str from DVDEntity as str where str.id>=:key";
			TypedQuery<DVDEntity> typedQuery = session.createQuery(hql, DVDEntity.class);
			typedQuery.setMaxResults(rowCount);
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<DVDEntity> arrayList = (ArrayList<DVDEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + DVDEntity.class);
			return arrayList;
		}
	}
	
	@Override
	public DVDEntity find(long id) {
		Session session = databaseConnectionHibernate();
		DVDEntity entity;
		try {
			entity = session.find(DVDEntity.class, id);
			
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
	public DVDEntity singleResult(long id) {
		return IDatabaseCrud.super.singleResult(id);
	}
	
}