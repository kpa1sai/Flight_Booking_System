package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Contact {
	@Id
	@GeneratedValue
	private int id;
	private String type;
	private String addressLine;
	private long zipCode;
	private String city;
	private String state;
	private String country;
	private long mobileNo;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddressLine() {
		return addressLine;
	}
	public void setAddressLine(String addressLine) {
		this.addressLine = addressLine;
	}
	public long getZipCode() {
		return zipCode;
	}
	public void setZipCode(long zipCode) {
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public Contact( String type, String addressLine, long zipCode, String city, String state, String country,
			long mobileNo) {
		super();

		this.type = type;
		this.addressLine = addressLine;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.country = country;
		this.mobileNo = mobileNo;
	}
	@Override
	public String toString() {
		return "Contact [id=" + id + ", type=" + type + ", addressLine=" + addressLine + ", zipCode=" + zipCode
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", mobileNo=" + mobileNo + "]";
	}
	public Contact() {
		super();
	}
	
	

}