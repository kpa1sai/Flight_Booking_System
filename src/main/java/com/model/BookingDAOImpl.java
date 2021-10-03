package com.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class BookingDAOImpl implements BookingDAO {
	
	@Autowired 
	SessionFactory sessionFactory;
	@Override
	@Transactional
	public void saveBooking(Booking booking) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(booking);
		session.flush();
		tx.commit();
		session.close();
		
	}
@Override
	
	public boolean update(Booking booking) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(booking);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}


	@Override

	public Booking findBooking(int id) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		Booking booking = session.find(Booking.class, id);
		session.flush();
		tx.commit();
		session.close();
		return booking;
	}

	
	
	@Override

	public boolean delete(Booking booking) {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.delete(booking);
		session.flush();
		tx.commit();
		session.close();
		return true;
	}

	@Override

	public boolean makepayment(Booking booking) {
	    Session session=sessionFactory.openSession();
	    //Transaction tx=session.beginTransaction();
        if(booking.getTotalCost()==booking.payment.getAmount()) {
            return true;
        }
     
		return true;
	}

	@Override

	public String cancelpayment() {
		Session session=sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
      
		//tx.commit();
        session.flush();
        session.close();
        tx.commit();
        return "Booking Cancelled";
	}
	
	

}