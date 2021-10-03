package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Fare;
import com.model.Fleet;
import com.model.Flight;
import com.model.FlightStatus;
import com.model.repo.FareRepo;
import com.model.repo.FleetRepo;
import com.model.repo.FlightRepo;
import com.model.repo.FlightStatusRepo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("admin")
@Api(value = "Admin Controller", description = "Control flights and Users")
public class AdminController {
	@Autowired
	FlightRepo flightRepo;
	@Autowired
	FareRepo fareRepo;
	@Autowired
	FleetRepo fleetRepo;
	@Autowired
	FlightStatusRepo flightStatusRepo; 
	
	@PostMapping("/addFlight")
	@ApiOperation(value = "Add new Flights",httpMethod = "POST")
	public ResponseEntity<?> addFlight(@RequestBody Flight flight){
		if(flight.getDepartureLocation()==null || flight.getArrivalLocation()==null || flight.getDepartureTime()==null || flight.getArrivalTime()==null) {
			 
			throw new AddFlightNotFoundException();
		}
		flightRepo.save(flight);
		return new ResponseEntity<Flight>(flight,HttpStatus.OK);
	}
	
	@GetMapping("/showFlights")
	@ApiOperation(value = "Get all Flights",httpMethod = "GET")
	public ResponseEntity<?> flightList(){
		List<Flight> flightList = flightRepo.findAll();
		return new ResponseEntity<>(flightList,HttpStatus.OK);
	}
	
	@PostMapping("/addFare")
	@ApiOperation(value = "Add fare of flight",httpMethod = "POST")
	public ResponseEntity<?> updateFare(int flight_id,@RequestBody Fare fare){
if(fare.getBussinessFare()==0 || fare.getEconomyFare()==0 || fare.getPremiumFare()==0) {
			
			throw new AddFareNotFoundException();
		}
		Flight flight = flightRepo.findById(flight_id).get();
		flight.setFare(fare);
		fareRepo.save(fare);
		flightRepo.save(flight);
		return new ResponseEntity<>(flight,HttpStatus.OK);
	}
	
	@PostMapping("/addFleet")
	@ApiOperation(value = "Add fleet of flight",httpMethod = "POST")
	public ResponseEntity<?> updateFleet(int flight_id,@RequestBody Fleet fleet){
		
		if(fleet.getTotalBusinessSeats()==0 || fleet.getTotalEconomySeats()==0 || fleet.getTotalPremiumSeats()==0) {
			
			throw new AddFleetNotFoundException();	
			}
		Flight flight = flightRepo.findById(flight_id).get();
		flight.setFleet(fleet);
		fleetRepo.save(fleet);
		flightRepo.save(flight);
		return new ResponseEntity<>(flight,HttpStatus.OK);
	}
	
	@PostMapping("/addFlightStatus")
	@ApiOperation(value = "Add flightStatus of flight",httpMethod = "POST")
	public ResponseEntity<?> updateFlightStatus(int flight_id,@RequestBody FlightStatus flightStatus){
		
		
		if(flightStatus.getRemainingBusinessSeats()==0 || flightStatus.getRemainingEconomySeats()==0 || flightStatus.getRemainingEconomySeats()==0) {
			throw new AddFlightStatusNotFoundException();
		}
		Flight flight = flightRepo.findById(flight_id).get();
		flight.setFlightStatus(flightStatus);
		flightStatusRepo.save(flightStatus);
		flightRepo.save(flight);
		return new ResponseEntity<>(flight,HttpStatus.OK);
	}
}
