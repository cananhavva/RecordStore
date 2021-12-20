package com.canan.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.canan.entity.GenreEntity;
import com.canan.util.IDatabaseCrud;

public class GenreEntityController implements IDatabaseCrud<GenreEntity> {
	@Override
	public void create(GenreEntity entity) {
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
	public void delete(GenreEntity entity) {
		
		try {
			GenreEntity findEntity = find(entity.getGenreId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Ba�ar�l� " + GenreEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(GenreEntity entity) {
		try {
			GenreEntity findEntity = find(entity.getGenreId());
			if (findEntity != null) {
				findEntity.setGenreName(entity.getGenreName());
				findEntity.setGenreDescription(entity.getGenreDescription());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Başarılı " + GenreEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("güncelleme anında hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
	}
	
	public ArrayList<GenreEntity> list(int rowCount) {
		Session session = databaseConnectionHibernate();
		
		if (rowCount == -1) {
			String hql = "select str from GenreEntity as str where str.id>=:key";
			TypedQuery<GenreEntity> typedQuery = session.createQuery(hql, GenreEntity.class);
			
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<GenreEntity> arrayList = (ArrayList<GenreEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + GenreEntity.class);
			return arrayList;
		} else {
			String hql = "select str from GenreEntity as str where str.id>=:key";
			TypedQuery<GenreEntity> typedQuery = session.createQuery(hql, GenreEntity.class);
			typedQuery.setMaxResults(rowCount);
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<GenreEntity> arrayList = (ArrayList<GenreEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + GenreEntity.class);
			return arrayList;
		}
	}
	
	@Override
	public GenreEntity find(long id) {
		Session session = databaseConnectionHibernate();
		GenreEntity entity;
		try {
			entity = session.find(GenreEntity.class, id);
			
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
	public GenreEntity singleResult(long id) {
		return IDatabaseCrud.super.singleResult(id);
	}
	
}