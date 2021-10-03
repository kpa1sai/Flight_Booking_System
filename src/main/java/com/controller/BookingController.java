package com.controller;


import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Flight;
import com.model.Passenger;
import com.model.repo.BookingRepo;
import com.model.repo.PassengerRepo;
import com.services.BookingService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("booking")
@Api(value = "Book Tickets" ,description = "Search Flights And Booking")
public class BookingController {
	@Autowired
	BookingRepo bookingRepo;
	@Autowired
	PassengerRepo passengerRepo;
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/searchFlights")
	@ApiOperation(value = "search based on location and date",httpMethod = "GET")
	public ResponseEntity<?> searchFlights(String arrivalLocation,String departureLocation,Date date){
		List<Flight> flightList= bookingService.getFutureFlights(arrivalLocation, departureLocation, date);
		return new ResponseEntity<>(flightList,HttpStatus.OK);
	}
	@PostMapping("/addPassenger")
	@ApiOperation(value = "Add new Passenger",httpMethod = "POST")
	    public ResponseEntity<?> addPassenger(@RequestBody Passenger passenger){
	        passengerRepo.save(passenger);
	        return new ResponseEntity<>(passenger,HttpStatus.OK);
	    }
	
}
