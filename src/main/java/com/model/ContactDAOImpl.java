package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactDAOImpl implements ContactDAO {

	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public void saveContact(Contact contact) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(contact);
		session.flush();
		tx.commit();
		session.close();
		
	}

	@Override
	public boolean deleteContact(Contact contact) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(contact);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override

	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(contact);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override
	public Contact findContact(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Contact contact=session.get(Contact.class,id);
		tx.commit();
		return new Contact();
	}

	
	

}