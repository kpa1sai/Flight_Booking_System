package com.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.model.Booking;
import com.model.BookingDAO;
import com.model.Passenger;
import com.model.PassengerDAO;
import com.model.UserDAO;
import com.model.Users;
import com.model.repo.UserRepo;

@Component
@Service
public class UserService {
	@Autowired
	PassengerDAO PassengerDAOImpl;
	@Autowired
	UserDAO UserDAOImpl;
	@Autowired
	BookingDAO BookingDAOImpl;
	@Autowired
	UserRepo userRepo;
	
	

	public void updateUser(Users users) {
		userRepo.saveAndFlush(users);
		//UserDAOImpl.updateUser(users);
		System.out.println("User Updated");
	}
	public Users getUserByEmail(String email) {
		return userRepo.findUsersByemail(email).get();
	}
	public boolean validateLogin(String email,String password) {
		Optional<Users> validate = userRepo.findUsersByemailAndPassword(email, password);
		if(validate.isPresent()) {
			return true;
		}return false;
		
	}
	/*
	public List<Booking> getBookedTicketDetails(Date date){
		return BookingDAOImpl.getBookedTicketDetails(date);
	}
	public List<Booking> getPreviousBookedTicketDetails(Date date){
		return BookingDAOImpl.getPreviousBookedTicketDetails(date);
	}*/
	public void addPassenger(Passenger passenger) {
		PassengerDAOImpl.savePassenger(passenger);
	}
	
			public void cancelBooking(int booking_id) {
			Booking booking = BookingDAOImpl.findBooking(booking_id);
			booking.setBookingStatus(false);
			BookingDAOImpl.update(booking);
			}


}