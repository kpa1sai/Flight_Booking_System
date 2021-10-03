package com.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Users {
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private String email;
	
	@OneToOne
	private Contact contact = null;
	
	@OneToMany(mappedBy = "id")
	private List<Booking> bookingList=new ArrayList<Booking>();

	public Users(String userName, String password, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
	}
	public void addBookings(Booking b) {
		bookingList.add(b);
	}
     public void removeBookings(Booking b) {
    	 bookingList.remove(b);
     }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	
	
	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", contact=" + contact + ", bookingList="
				+ bookingList + "]";
	}
	public Users() {
		super();
	}
	public Users(int i, String userName) {
		this.id=id;
		this.userName=userName;
	
	}
     
}
