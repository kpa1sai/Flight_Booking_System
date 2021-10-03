package com.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Flight {
	@Id
	@GeneratedValue
	private int id;
	private String departureLocation;
	private String arrivalLocation;
	@OneToOne
	Fleet fleet;
	@OneToOne
	FlightStatus flightStatus;
	private Date departureTime;
	private Date arrivalTime;
	//@OneToOne
	//private Booking booking;
    
	@OneToOne
	private Fare fare;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public Fleet getFleet() {
		return fleet;
	}

	public void setFleet(Fleet fleet) {
		this.fleet = fleet;
	}

	public Date getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Date departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(Date arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	/*public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
*/
	public Fare getFare() {
		return fare;
	}

	public void setFare(Fare fare) {
		this.fare = fare;
	}

	

	public FlightStatus getFlightStatus() {
		return flightStatus;
	}

	public void setFlightStatus(FlightStatus flightStatus) {
		this.flightStatus = flightStatus;
	}
	

	public Flight(String departureLocation, String arrivalLocation, Fleet fleet, FlightStatus flightStatus,
			Date departureTime, Date arrivalTime, Fare fare) {
		super();
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.fleet = fleet;
		this.flightStatus = flightStatus;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.fare = fare;
	}
	

	@Override
	public String toString() {
		return "Flight [id=" + id + ", departureLocation=" + departureLocation + ", arrivalLocation=" + arrivalLocation
				+ ", fleet=" + fleet + ", flightStatus=" + flightStatus + ", departureTime=" + departureTime
				+ ", arrivalTime=" + arrivalTime + ", fare=" + fare + "]";
	}

	public Flight() {
		super();
	}
	
	

}
