package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class PassengerDAOImpl implements PassengerDAO {

	@Autowired
	SessionFactory sessionfactory;
	@Override

	public void savePassenger(Passenger passenger) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(passenger);
		session.flush();
		tx.commit();
		session.close();

	}

	@Override

	public Passenger findPassenger(int id) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		Passenger passenger=session.get(Passenger.class, id);
		tx.commit();
		
		return new Passenger();
	}

	

	@Override

	public boolean updatePassenger(Passenger passenger) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(passenger);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean deletePassenger(Passenger passenger) {
		Session session=sessionfactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(passenger);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}



}