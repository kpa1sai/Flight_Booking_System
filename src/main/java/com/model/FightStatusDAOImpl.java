package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
@Component
public class FightStatusDAOImpl implements FlightStatusDAO {

	@Autowired 
	SessionFactory sessionFactory;
	@Override
	public void saveFlightStatus(FlightStatus flightstatus) {
				Session session=sessionFactory.openSession();
				Transaction tx=session.beginTransaction();
				session.save(flightstatus);
				session.flush();
				tx.commit();
				session.close();
	}

	@Override
	public boolean deleteFlightStatus(FlightStatus flightstatus) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(flightstatus);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean updateFlightStatus(FlightStatus flightstatus) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(flightstatus);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public FlightStatus findFlightStatus(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Location flightstatus=session.get(Location.class,id);
		tx.commit();
		return new FlightStatus();
		}


	

}