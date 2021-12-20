package com.canan.controller;

import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.hibernate.Session;

import com.canan.entity.VinylEntity;
import com.canan.util.IDatabaseCrud;

public class VinylEntityController implements IDatabaseCrud<VinylEntity> {
	@Override
	public void create(VinylEntity entity) {
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
	public void delete(VinylEntity entity) {
		
		try {
			VinylEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				System.out.println("Silme Ba�ar�l� " + VinylEntity.class);
			}
		} catch (Exception e) {
			System.out.println("silme an�nda hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(VinylEntity entity) {
		try {
			VinylEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setAlbumName(entity.getAlbumName());
				findEntity.setGenres(entity.getGenres());
				findEntity.setPrice(entity.getPrice());
				findEntity.setStatus(entity.getStatus());
				findEntity.setPlaySpeed(entity.getPlaySpeed());
				
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				System.out.println("Güncelleme Başarılı " + VinylEntity.class);
			}
			
		} catch (Exception e) {
			System.out.println("güncelleme anında hata meydana geldi !!!!! " + IDatabaseCrud.class);
			e.printStackTrace();
		}
	}
	
	public ArrayList<VinylEntity> list(int rowCount) {
		Session session = databaseConnectionHibernate();
		
		if (rowCount == -1) {
			String hql = "select str from VinylEntity as str where str.id>=:key";
			TypedQuery<VinylEntity> typedQuery = session.createQuery(hql, VinylEntity.class);
			
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<VinylEntity> arrayList = (ArrayList<VinylEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + VinylEntity.class);
			return arrayList;
		} else {
			String hql = "select str from VinylEntity as str where str.id>=:key";
			TypedQuery<VinylEntity> typedQuery = session.createQuery(hql, VinylEntity.class);
			typedQuery.setMaxResults(rowCount);
			long id = 1L;
			typedQuery.setParameter("key", id);
			
			ArrayList<VinylEntity> arrayList = (ArrayList<VinylEntity>) typedQuery.getResultList();
			System.out.println("listelendi " + VinylEntity.class);
			return arrayList;
		}
	}
	
	@Override
	public VinylEntity find(long id) {
		Session session = databaseConnectionHibernate();
		VinylEntity entity;
		try {
			entity = session.find(VinylEntity.class, id);
			
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
	public VinylEntity singleResult(long id) {
		return IDatabaseCrud.super.singleResult(id);
	}
	
}