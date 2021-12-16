package com.canan.controller;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.TypedQuery;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.canan.entity.CustomerEntity;
import com.canan.util.IDatabaseCrud;

public class CustomerController implements IDatabaseCrud<CustomerEntity>, Serializable {
	
	private static final long serialVersionUID = -2098198918778858300L;
	private static final Logger logger = LogManager.getLogger(CustomerController.class);
	
	public static void main(String[] args) {
		logger.trace("trace logger durumu");
		logger.debug("debug logger durumu");
		logger.info("info logger durumu");
		logger.warn("warn logger durumu");
		logger.error("error logger durumu");
		logger.fatal("fatal logger durumu");
	}
	
	@Override
	public void create(CustomerEntity entity) {
		try {
			Session session = databaseConnectionHibernate();
			session.getTransaction().begin();
			session.persist(entity);
			session.getTransaction().commit();
			logger.info("ekleme tamamdır" + CustomerController.class);
			
		} catch (Exception e) {
			logger.error("ekleme anında hata meydana geldi !!!!! " + CustomerController.class);
			
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void delete(CustomerEntity entity) {
		
		try {
			CustomerEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.remove(findEntity);
				session.getTransaction().commit();
				logger.info("Silme Başarılı " + CustomerEntity.class);
			}
		} catch (Exception e) {
			logger.error("silme anında hata meydana geldi !!!!! " + CustomerController.class);
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void update(CustomerEntity entity) {
		try {
			CustomerEntity findEntity = find(entity.getId());
			if (findEntity != null) {
				findEntity.setCustomerName(entity.getCustomerName());
				findEntity.setCustomerSurname(entity.getCustomerSurname());
				Session session = databaseConnectionHibernate();
				session.getTransaction().begin();
				session.merge(findEntity);
				session.getTransaction().commit();
				logger.info("Güncelleme Başarılı " + CustomerEntity.class);
			}
			
		} catch (Exception e) {
			logger.error("güncelleme anında hata meydana geldi !!!!! " + CustomerController.class);
			e.printStackTrace();
		}
	}
	
	// listelemek
	@Override
	public ArrayList<CustomerEntity> list() {
		Session session = databaseConnectionHibernate();
		
		// unutma: buradaki sorgulama entity sorgulaması yani java classına göre
		// çağıracağız.
		String hql = "select str from CustomerEntity as str where str.id>=:key";
		TypedQuery<CustomerEntity> typedQuery = session.createQuery(hql, CustomerEntity.class);
		
		int id = 1;
		typedQuery.setParameter("key", id);
		
		ArrayList<CustomerEntity> arrayList = (ArrayList<CustomerEntity>) typedQuery.getResultList();
		logger.info("listelendi " + CustomerEntity.class);
		return arrayList;
	}
	
	@Override
	
	public CustomerEntity find(long l) {
		Session session = databaseConnectionHibernate();
		CustomerEntity CustomerEntity;
		try {
			CustomerEntity = session.find(CustomerEntity.class, l);
			
			if (CustomerEntity != null) {
				System.out.println("bulundu... " + CustomerEntity);
				return CustomerEntity;
			} else {
				System.out.println("Aradığınız kriterde sonuçlar bulunamadı ...");
				return null;
			}
		} catch (Exception e) {
			logger.error("find anında hata meydana geldi !!!!! " + CustomerController.class);
			e.printStackTrace();
		}
		return null;
	}
	
}
