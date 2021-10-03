package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface BookingDAO {

	
	public void saveBooking(Booking booking);
	public Booking findBooking(int id);
	
	public boolean update(Booking booking);
	public boolean delete(Booking booking);
	public boolean makepayment(Booking booking);
	public String cancelpayment();
	
	
}
