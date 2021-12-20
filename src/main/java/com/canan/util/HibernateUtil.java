package com.canan.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.canan.entity.ArtistEntity;
import com.canan.entity.CDEntity;
import com.canan.entity.DVDEntity;
import com.canan.entity.GenreEntity;
import com.canan.entity.ShopEntity;
import com.canan.entity.ShopRowEntity;
import com.canan.entity.UserEntity;
import com.canan.entity.VinylEntity;

public class HibernateUtil {
	// dış dünyada bununla bu classa erişim sağlayabileceğim.
	public static SessionFactory getSessionfactory() {
		return sessionFactory;
	}
	
	// hibernate ile bağlantı kuracağım yer
	private static final SessionFactory sessionFactory = sessionFactoryHibernate();
	
	// method
	private static SessionFactory sessionFactoryHibernate() {
		try {
			// instance
			Configuration configuration = new Configuration();
			
			// entity classlarımızı buraya ekleyeceğiz
			configuration.addAnnotatedClass(ArtistEntity.class);
			configuration.addAnnotatedClass(CDEntity.class);
			configuration.addAnnotatedClass(DVDEntity.class);
			configuration.addAnnotatedClass(GenreEntity.class);
			configuration.addAnnotatedClass(UserEntity.class);
			configuration.addAnnotatedClass(VinylEntity.class);
			configuration.addAnnotatedClass(ShopEntity.class);
			configuration.addAnnotatedClass(ShopRowEntity.class);
			
			SessionFactory factory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			return factory;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
