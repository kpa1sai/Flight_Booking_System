package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface FlightDAO {
	public void saveFlight(Flight flight);
	public boolean updateFlight(Flight flight);
	public boolean deleteFlight(Flight flight);
	public Flight findFlight(int id);

	
}