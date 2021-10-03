package com.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Booking {
	@Id
	@GeneratedValue
	private int id;
	private long bookingNumber;
	private Date bookingDate;
	private Date travleDate;
	private double totalCost;
	private boolean BookingStatus;
	public boolean isBookingStatus() {
		return BookingStatus;
	}

	public void setBookingStatus(boolean bookingStatus) {
		BookingStatus = bookingStatus;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	@OneToOne
	public Payment payment;
	
	@ManyToOne
	private Users users;
	@OneToOne
	 private Flight flightBooked;
    @OneToOne
    private Passenger passenger;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getBookingNumber() {
		return bookingNumber;
	}

	public void setBookingNumber(long bookingNumber) {
		this.bookingNumber = bookingNumber;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}

	public Date getTravleDate() {
		return travleDate;
	}

	public void setTravleDate(Date travleDate) {
		this.travleDate = travleDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public Flight getFlightBooked() {
		return flightBooked;
	}

	public void setFlightBooked(Flight flightBooked) {
		this.flightBooked = flightBooked;
	}

	

	public Booking(long bookingNumber, Date bookingDate, Date travleDate, double totalCost, boolean bookingStatus,
			Payment payment, Users users, Flight flightBooked, Passenger passenger) {
		super();
		this.bookingNumber = bookingNumber;
		this.bookingDate = bookingDate;
		this.travleDate = travleDate;
		this.totalCost = totalCost;
		BookingStatus = bookingStatus;
		this.payment = payment;
		this.users = users;
		this.flightBooked = flightBooked;
		this.passenger = passenger;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", bookingNumber=" + bookingNumber + ", bookingDate=" + bookingDate
				+ ", travleDate=" + travleDate + ", totalCost=" + totalCost + ", flightBooked=" + flightBooked + "]";
	}

	public Booking() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
