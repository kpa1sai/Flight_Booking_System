package com.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public interface PassengerDAO {
	public Passenger findPassenger(int id);
	
	public boolean updatePassenger(Passenger passenger);
	public boolean deletePassenger(Passenger passenger);
	public void savePassenger(Passenger passenger);
}