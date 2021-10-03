package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class FlightStatus {
	@Id
	@GeneratedValue
	private int id;
	private int remainingEconomySeats;
	private int remainingPremiumSeats;
	private int remainingBusinessSeats;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRemainingEconomySeats() {
		return remainingEconomySeats;
	}
	public void setRemainingEconomySeats(int remainingEconomySeats) {
		this.remainingEconomySeats = remainingEconomySeats;
	}
	public int getRemainingPremiumSeats() {
		return remainingPremiumSeats;
	}
	public void setRemainingPremiumSeats(int remainingPremiumSeats) {
		this.remainingPremiumSeats = remainingPremiumSeats;
	}
	public int getRemainingBusinessSeats() {
		return remainingBusinessSeats;
	}
	public void setRemainingBusinessSeats(int remainingBusinessSeats) {
		this.remainingBusinessSeats = remainingBusinessSeats;
	}
	
	@Override
	public String toString() {
		return "FlightStatus [id=" + id + ", remainingEconomySeats=" + remainingEconomySeats
				+ ", remainingPremiumSeats=" + remainingPremiumSeats + ", remainingBusinessSeats="
				+ remainingBusinessSeats + "]";
	}
	public FlightStatus() {
		super();
	}
	

}