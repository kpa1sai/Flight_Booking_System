package com.example.OnlineFlight_Booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Booking;
import com.model.BookingDAO;
import com.model.Payment;
import com.model.PaymentDAO;

@SpringBootTest
@EnableTransactionManagement
class BookingTesting {
	
	@Autowired
	BookingDAO bookingDAOImpl;
	@Autowired
	PaymentDAO paymentDAOImpl;
	Booking booking;
	Payment payment;
	
	@BeforeEach
	void doInit()
	{
		
		booking=new Booking();
		booking.setBookingNumber(445566);
		booking.setBookingStatus(true);
		booking.setTotalCost(4587.80);
	     bookingDAOImpl.saveBooking(booking);
	}
	@Test
	void BookingCRUD() {
		booking=new Booking();
		booking.setBookingNumber(445566);
		booking.setBookingStatus(true);
		booking.setTotalCost(4587.80);
		//saving
	     bookingDAOImpl.saveBooking(booking);
	     Booking booking1=bookingDAOImpl.findBooking(booking.getId());
	     assertThat(booking1.getBookingNumber()).isEqualTo(booking.getBookingNumber());
	     
	     
	     //make payment
	     
	     payment=new Payment();
	     payment.setAmount(3500);
	     paymentDAOImpl.savePayment(payment);
	     Booking bookingobj2=new Booking();
	     bookingobj2.setTotalCost(3500);
	     bookingobj2.setPayment(payment);
	     bookingDAOImpl.saveBooking(bookingobj2);
	     boolean test1=bookingDAOImpl.makepayment(bookingobj2);
	     assertTrue(test1);
	     //cancel payment
	     
	     
	     
	     //update
	     Booking bookingobj=new Booking();
	     bookingobj.setBookingNumber(334455);
	     bookingobj.setBookingStatus(false);
	     bookingobj.setTotalCost(0);
	     bookingDAOImpl.saveBooking(bookingobj);
	      boolean result=bookingDAOImpl.update(bookingobj);
	     assertTrue(result);
			
			  //delete 
	     Booking book=new Booking(); 
	     book.setBookingNumber(44558); 
	     boolean  deleteobj=bookingDAOImpl.delete(book); 
	     assertTrue(deleteobj);
			 
	     
	     
	}

}