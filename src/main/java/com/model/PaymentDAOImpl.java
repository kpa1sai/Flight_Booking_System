package com.model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PaymentDAOImpl implements PaymentDAO {
	
	
	@Autowired 
	SessionFactory sessionFactory;
	@Override

	public void savePayment(Payment payment) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(payment);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public Payment findPayment(int id) {
		Session session = sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Payment payment= session.find(Payment.class, id);
		tx.commit();
		return new Payment();
	}


	@Override
	public boolean update(Payment payment) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(payment);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public boolean delete(Payment payment) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(payment);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}
	

}
