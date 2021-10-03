package com.example.OnlineFlight_Booking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.FlightStatus;
import com.model.FlightStatusDAO;


@EnableTransactionManagement
@SpringBootTest
class FlightStatusTesting {
	
	@Autowired
	FlightStatusDAO flightStatusDAOImpl;
	FlightStatus flightstatus;
	
	@BeforeEach
	void doInit()
	{
		flightstatus=new FlightStatus();
		flightstatus.setRemainingBusinessSeats(20);
		flightstatus.setRemainingEconomySeats(35);
		flightstatus.setRemainingPremiumSeats(45);
		
		flightStatusDAOImpl.saveFlightStatus(flightstatus);
		
	}

	@Test
	void testFlightStatusSave() {
		flightstatus=new FlightStatus();
		flightstatus.setRemainingBusinessSeats(20);
		flightstatus.setRemainingEconomySeats(35);
		flightstatus.setRemainingPremiumSeats(45);
		flightStatusDAOImpl.saveFlightStatus(flightstatus);
		FlightStatus status1=flightStatusDAOImpl.findFlightStatus(flightstatus.getId());
		//assertThat(20).isEqualTo(flightstatus.getRemainingBusinessSeats());
		assertThat(status1.getRemainingBusinessSeats()==flightstatus.getRemainingBusinessSeats());
		
		FlightStatus statusobj=new FlightStatus();
		statusobj.setRemainingBusinessSeats(50);
		statusobj.setRemainingEconomySeats(60);
		statusobj.setRemainingPremiumSeats(10);
		flightStatusDAOImpl.saveFlightStatus(statusobj);
		
		//updating
		statusobj.setRemainingBusinessSeats(45);
		flightStatusDAOImpl.updateFlightStatus(statusobj);
		assertThat(statusobj.getRemainingBusinessSeats()==45);
		//deleting
		FlightStatus statusobj1=new FlightStatus();
		statusobj1.setRemainingBusinessSeats(20);
		boolean result=flightStatusDAOImpl.deleteFlightStatus(statusobj1);
		assertThat(result==true);

	}
	
	
}
