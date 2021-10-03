package com.example.OnlineFlight_Booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Fare;
import com.model.FareDAO;
import com.model.Fleet;
import com.model.FleetDAO;
import com.model.Flight;
import com.model.FlightDAO;
import com.model.FlightStatus;
import com.model.FlightStatusDAO;

@SpringBootTest
@EnableTransactionManagement
class FlightTesting {
	@Autowired
	FlightDAO flightDAOImpl;
	Flight flight;
	@Autowired 
	FleetDAO fleetDAOImpl;
	@Autowired
	FlightStatusDAO flightStatusDAOImpl;
	@Autowired 
	FareDAO fareDAOImpl;
	
	Fleet fleet;
	Fare fare;
	FlightStatus flightstatus;
	
	@BeforeEach
	void doInit()
	{
		flight=new Flight();
		flight.setArrivalLocation("Hyd");
		flight.setDepartureLocation("Bang");
		flightDAOImpl.saveFlight(flight);;
	}
	@Test
	void FlightCRUD() {
		
	 fleet=new Fleet();
	 fleet.setCode("475897");
	 fleet.setModel("private jet");
	 fleet.setTotalBusinessSeats(12);
	 fleet.setTotalEconomySeats(7);
	 fleet.setTotalPremiumSeats(5);
	 fleetDAOImpl.saveFleet(fleet);
	 fare=new Fare();
	 fare.setBussinessFare(3400);
	 fare.setEconomyFare(5677);
	 fare.setPremiumFare(22334);
	 fareDAOImpl.saveFare(fare);
	 flightstatus=new FlightStatus();
		flightstatus.setRemainingBusinessSeats(20);
		flightstatus.setRemainingEconomySeats(35);
		flightstatus.setRemainingPremiumSeats(45);
	 
		flightStatusDAOImpl.saveFlightStatus(flightstatus);
		flight=new Flight();
		flight.setArrivalLocation("Hyd");
		flight.setDepartureLocation("Bang");
		flight.setFare(fare);
		flight.setFleet(fleet);
		flight.setFlightStatus(flightstatus);
		flightDAOImpl.saveFlight(flight);
		
		assertThat(fare).isEqualTo(flight.getFare());
		
		
		flightDAOImpl.saveFlight(flight);;
		Flight flight1=flightDAOImpl.findFlight(flight.getId());
	    assertThat(flight1.getArrivalLocation()).isEqualTo(flight.getArrivalLocation());

		//saving
		Flight flightobj=flightDAOImpl.findFlight(flight.getId());
		assertThat("Hyd").isEqualTo(flight.getArrivalLocation());
		assertThat("Hyd").isEqualTo(flight.getArrivalLocation());
		//updating
		Flight flight2=new Flight();
		flight2.setArrivalLocation("Bang");
		flightDAOImpl.saveFlight(flight2);
		flight2.setArrivalLocation("Chennai");
		flightDAOImpl.updateFlight(flight2);
		assertThat("Chennai").isEqualTo(flight2.getArrivalLocation());
		
		//delete
		Flight flight3=new Flight();
		   boolean result=flightDAOImpl.deleteFlight(flight3);
					assertTrue(result);
				
		
	}
}
