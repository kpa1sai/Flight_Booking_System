package com.services;



import java.sql.Date;
import java.util.Collections;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Booking;
import com.model.BookingDAO;
import com.model.Flight;
import com.model.FlightDAO;
import com.model.Payment;
import com.model.PaymentDAO;
import com.model.repo.BookingRepo;
import com.model.repo.FlightRepo;
@Component
public class BookingService {
	@Autowired
	BookingDAO BookingDAOImpl;
	@Autowired
	FlightDAO FlightDAOImpl;
	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	PaymentDAO paymentDAOImpl;
	@Autowired
	BookingRepo bookingRepo;
	@Autowired
	FlightRepo flightRepo;
	
	public List<Flight> getFutureFlights(String arrivalLocation,String departureLocation,Date date){
		List<Flight> flightList = flightRepo.findByArrivalLocationAndDepartureLocationAndArrivalTime(arrivalLocation, departureLocation, date).map(Collections::singletonList).orElseGet(Collections::emptyList);
		
		return flightList;
	}
	
	public int[] checkAvailability(Flight flight) {
		int[] seatArray;
		seatArray = new int[] {flight.getFlightStatus().getRemainingEconomySeats(),flight.getFlightStatus().getRemainingBusinessSeats(),flight.getFlightStatus().getRemainingPremiumSeats()};
		return seatArray;
	}
	
	public void displayBookingDetails(int id) {
		Booking booking = BookingDAOImpl.findBooking(id);
		if(booking.isBookingStatus()) {
			System.out.println(booking);
		}
	}
	public boolean bookingStatus(Flight flight,int economyseats,int businessseats,int premiumseats,int paymentid) {
		Payment payment = paymentDAOImpl.findPayment(paymentid);
		if(calculateFare(flight, economyseats, businessseats, premiumseats) ==  payment.getAmount()) {
			return true;
		}
		return false;
	}
	
	public boolean validatePayment(int id) {
		Payment payment = paymentDAOImpl.findPayment(id);
		if(payment.isPaymentStatus()) {
			return true;
		}else
		return false;
	}
	
	public double calculateFare(Flight flight,int economyseats,int businessseats,int premiumseats) {
		double fare =0;
		double gst = 0.18;
		fare = flight.getFare().getEconomyFare()*economyseats + flight.getFare().getBussinessFare()*businessseats + flight.getFare().getPremiumFare()*premiumseats;
		fare *= gst;
		return fare;
	}
	
	public Flight searchFlight(int id) {
		return FlightDAOImpl.findFlight(id);
	}
	
}