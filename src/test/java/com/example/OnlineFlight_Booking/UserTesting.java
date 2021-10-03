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
import com.model.Contact;
import com.model.ContactDAO;
import com.model.Passenger;
import com.model.Payment;
import com.model.UserDAO;
import com.model.Users;
@SpringBootTest
@EnableTransactionManagement
class UserTesting {
	
	 @Autowired
	 UserDAO userDAOImpl;
	 @Autowired
	 BookingDAO bookingDAOImpl;
	 @Autowired
	 ContactDAO contactDAOImpl;
	 
	 Passenger passenger;
	 Users users;
	 @BeforeEach
		void doInit()
		{
		   users=new Users();
		   users.setFirstName("walter");
		   users.setLastName("white");
		   users.setUserName("jessypinckman");
		   users.setPassword("walterjessy");
		   //userDAOImpl.saveUsers(users);   
		   
		}
	 @Test
	 void UsersCRUD()
	 {
		 Contact contact=new Contact();
		 contact.setAddressLine("Bownela");
		 contact.setCity("Hyd");
		 contact.setCountry("India");
		 contact.setMobileNo(24992);
		 contact.setState("Telangana");
		 contact.setType("sd");
		 contact.setZipCode(332);
		 contact.getAddressLine();
		 contact.getCity();
		 contact.getCountry();
		 contact.getMobileNo();
		 contact.getState();
		 contact.getType();
		 contact.getZipCode();
		 contactDAOImpl.saveContact(contact);
		 Booking booking = new Booking();
		 booking.setBookingNumber(2332);
		 booking.setBookingStatus(true);
		 booking.setTotalCost(54);
		 passenger=new Passenger();
			passenger.setFirstName("Gayatri");
			passenger.setLastName("Pareek");
			passenger.setAge(21);
			passenger.setGender('F');
			passenger.setPassportNo("2940");
			passenger.setMealPref("Veg");
			
		Payment	payment=new Payment(200);

			booking.setPayment(payment);
			booking.setPassenger(passenger);
			//bookingDAOImpl.saveBooking(booking);
		 users=new Users();
		   users.setFirstName("walter");
		   users.setLastName("white");
		   users.setUserName("jessypinckman");
		   users.setPassword("walterjessy");
		   users.setContact(contact);
		   users.addBookings(booking);
		 assertThat(contact).isEqualTo(users.getContact());
		   //save 
		   userDAOImpl.saveUsers(users);
		   Users userobj=userDAOImpl.findUser(users.getId());
		   assertThat("walter").isEqualTo(users.getFirstName());
		   //updating
		   
		   Users users1=new Users();
		   users1.setFirstName("rahul");
		   userDAOImpl.saveUsers(users1);
		   users1.setFirstName("pavan");
		   boolean result=userDAOImpl.updateUser(users1);
		   assertTrue(result);
		
	 }
	 
	
}