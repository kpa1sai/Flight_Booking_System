package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FareDAOImpl implements FareDAO {

	@Autowired
	SessionFactory sessionfactory;
	@Override
	public void saveFare(Fare fare) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(fare);
		session.flush();
		tx.commit();
		session.close();
	}
	@Override
	public Fare findFare(int id) {
		Session session = sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		Fare  fare = session.find(Fare .class, id);
		tx.commit();
		return new Fare ();
}

	@Override
	public boolean updateFare(Fare fare) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(fare);
		session.flush();
		tx.commit();
		session.close();
	    return true;
	}
	@Override
	public boolean deleteFare(Fare fare) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(fare);
		session.flush();
		tx.commit();
		session.close();
	    return true;
	}
}