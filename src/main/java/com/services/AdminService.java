package com.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.repo.FareRepo;
import com.model.repo.FleetRepo;
import com.model.repo.FlightRepo;
import com.model.repo.FlightStatusRepo;

@Component
public class AdminService {
	
	
	@Autowired
	FlightRepo flightRepo;
	@Autowired
	FareRepo fareRepo;
	@Autowired
	FleetRepo fleetRepo;
	@Autowired
	FlightStatusRepo flightStatusRepo; 
	/*
	 * @Autowired FlightDAO FlightDAOImpl;
	 * 
	 * public List<Flight> getFlightList(){ return FlightDAOImpl.findAll(); } public
	 * void updateFlight(Flight flight) { FlightDAOImpl.updateFlight(flight); }
	 * public void addFlight(Flight flight) { FlightDAOImpl.saveFlight(flight); }
	 * public void updateFleet(Flight flight,Fleet fleet) { flight.setFleet(fleet);
	 * } public void updateFare(Flight flight,Fare fare) { flight.setFare(fare); }
	 */
}