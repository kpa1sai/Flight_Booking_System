package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LocationDAOImpl implements LocationDAO {

	@Autowired 
	SessionFactory sessionFactory;
	@Override
	@Transactional
	public void saveLocation(Location location) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(location);
		session.flush();
		tx.commit();
		session.close();
	}

	@Override
	public boolean deleteLocation(Location location) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(location);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override

	public boolean updateLocation(Location location) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(location);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override

	public Location findLocation(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Location location=session.get(Location.class,id);
		tx.commit();
		return new Location();
	
	}

	

}