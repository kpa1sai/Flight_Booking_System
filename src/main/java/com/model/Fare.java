package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Fare {
	@Id
	@GeneratedValue
	private int id;
	private double economyFare;
	private double premiumFare;
	private double bussinessFare;
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getEconomyFare() {
		return economyFare;
	}

	public void setEconomyFare(double economyFare) {
		this.economyFare = economyFare;
	}

	public double getPremiumFare() {
		return premiumFare;
	}

	public void setPremiumFare(double premiumFare) {
		this.premiumFare = premiumFare;
	}

	public double getBussinessFare() {
		return bussinessFare;
	}

	public void setBussinessFare(double bussinessFare) {
		this.bussinessFare = bussinessFare;
	}

	

	public Fare(double economyFare, double premiumFare, double bussinessFare) {
		super();
		this.economyFare = economyFare;
		this.premiumFare = premiumFare;
		this.bussinessFare = bussinessFare;

	}

	@Override
	public String toString() {
		return "Fare [id=" + id + ", economyFare=" + economyFare + ", premiumFare=" + premiumFare + ", bussinessFare="
				+ bussinessFare +  "]";
	}

	public Fare() {
		super();
	}
	

}
