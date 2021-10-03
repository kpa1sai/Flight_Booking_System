package com.model;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class FlightDAOImpl implements FlightDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override

	public void saveFlight(Flight flight) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(flight);
		session.flush();
		tx.commit();
		session.close();
	}

	@Override

	public boolean updateFlight(Flight flight) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(flight);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override

	public boolean deleteFlight(Flight flight) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(flight);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override

	public Flight findFlight(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Flight flight = session.find(Flight.class, id);
		tx.commit();
		return flight;
	}
	
	

}