package com.canan.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.canan.entity.ArtistEntity;
import com.canan.util.IDatabaseCrud;

public class ArtistEntityController implements IDatabaseCrud<ArtistEntity> {
	@Override
	public void create(ArtistEntity entity) {
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
	public void delete(ArtistEntity entity) {
		
		try {
			ArtistEntity findEntity = find(entity.getArtistId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Ba�ar�l� " + ArtistEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(ArtistEntity entity) {
		try {
			ArtistEntity findEntity = find(entity.getArtistId());
			if (findEntity != null) {
				findEntity.setArtistName(entity.getArtistName());
				findEntity.setArtistLastName(entity.getArtistLastName());
				findEntity.setDesc(entity.getDesc());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Başarılı " + ArtistEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("güncelleme anında hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
	}
	
	public ArrayList<ArtistEntity> list(int rowCount) {
		Session session = databaseConnectionHibernate();
		
		if (rowCount == -1) {
			String hql = "select str from ArtistEntity as str where str.id>=:key";
			TypedQuery<ArtistEntity> typedQuery = session.createQuery(hql, ArtistEntity.class);
			
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<ArtistEntity> arrayList = (ArrayList<ArtistEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + ArtistEntity.class);
			return arrayList;
		} else {
			String hql = "select str from ArtistEntity as str where str.id>=:key";
			TypedQuery<ArtistEntity> typedQuery = session.createQuery(hql, ArtistEntity.class);
			typedQuery.setMaxResults(rowCount);
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<ArtistEntity> arrayList = (ArrayList<ArtistEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + ArtistEntity.class);
			return arrayList;
		}
	}
	
	@Override
	public ArtistEntity find(long id) {
		Session session = databaseConnectionHibernate();
		ArtistEntity entity;
		try {
			entity = session.find(ArtistEntity.class, id);
			
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
	public ArtistEntity singleResult(long id) {
		return IDatabaseCrud.super.singleResult(id);
	}
	
}