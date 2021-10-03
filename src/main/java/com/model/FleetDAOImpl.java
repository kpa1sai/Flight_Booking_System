package com.model;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class FleetDAOImpl implements FleetDAO {

@Autowired
SessionFactory sessionFactory;

@Override

public void saveFleet(Fleet fleet) {
Session session = sessionFactory.openSession();
Transaction tx=session.beginTransaction();
session.save(fleet);
session.flush();
tx.commit();
session.close();
}

@Override

public boolean updateFleet(Fleet fleet) {
Session session = sessionFactory.openSession();
Transaction tx=session.beginTransaction();
session.update(fleet);
session.flush();
tx.commit();
session.close();
return true;
}



@Override

public boolean deleteFleet(Fleet fleet) {
Session session = sessionFactory.openSession();
Transaction tx=session.beginTransaction();
session.delete(fleet);
session.flush();
tx.commit();
session.close();
return true;
}
@Override
@Transactional

public Fleet findFleet(int id) {
	Session session = sessionFactory.openSession();
	Transaction tx=session.beginTransaction();
	Fleet fleet= session.find(Fleet.class, id);
	tx.commit();
	return new Fleet();
}

}