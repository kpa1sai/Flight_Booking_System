package com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(value=BookingNotFoundException.class)
	public ResponseEntity<Object> exception(BookingNotFoundException exception)
	{
	return new ResponseEntity<>("Invalid BookingDetails",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=PassengerNotFoundException.class)
	public ResponseEntity<Object> exception(PassengerNotFoundException exception)
	{
	return new ResponseEntity<>("Invalid PassengerDetails",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=AddFlightNotFoundException.class)
	public ResponseEntity<Object> exception(AddFlightNotFoundException exception)
	{
	return new ResponseEntity<>("Invalid FlightDetails",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=AddFareNotFoundException.class)
	public ResponseEntity<Object> exception(AddFareNotFoundException exception)
	{
	return new ResponseEntity<>("Invalid FareDetails",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=AddFleetNotFoundException.class)
	public ResponseEntity<Object> exception(AddFleetNotFoundException exception)
	{
	return new ResponseEntity<>("Invalid FleetDetails",HttpStatus.NOT_FOUND);
	}
	@ExceptionHandler(value=AddFlightStatusNotFoundException.class)
	public ResponseEntity<Object> exception(AddFlightStatusNotFoundException exception)
	{
	return new ResponseEntity<>("Invalid FlightStatus",HttpStatus.NOT_FOUND);
	}
}
