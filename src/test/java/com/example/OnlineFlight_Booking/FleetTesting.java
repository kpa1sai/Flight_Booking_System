package com.example.OnlineFlight_Booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Fleet;
import com.model.FleetDAO;

@SpringBootTest
@EnableTransactionManagement
 class FleetTesting {

	@Autowired
	FleetDAO fleetDAOImpl;
	Fleet fleet;
	
	@BeforeEach
	void doInit()
	{
		fleet=new Fleet();
		fleet.setCode("445599");
		fleet.setModel("private jet");
		fleet.setTotalBusinessSeats(5);
		fleet.setTotalEconomySeats(5);
		fleet.setTotalPremiumSeats(5);
		
		fleetDAOImpl.saveFleet(fleet);
		

	}
	
	@Test
	void FleetTest() {
		fleet=new Fleet();
		fleet.setCode("445599");
		fleet.setModel("private jet");
		fleet.setTotalBusinessSeats(5);
		fleet.setTotalEconomySeats(5);
		fleet.setTotalPremiumSeats(5);
		fleetDAOImpl.saveFleet(fleet);
		
		//saving
		Fleet fleetobj=fleetDAOImpl.findFleet(fleet.getId());
		assertThat(5).isEqualTo(fleet.getTotalBusinessSeats());
		assertThat(5).isEqualTo(fleet.getTotalBusinessSeats());
		//updating
		Fleet fleet1=new Fleet();
		fleet1.setTotalBusinessSeats(10);
		fleetDAOImpl.saveFleet(fleet1);
		fleet1.setTotalBusinessSeats(2);
		fleetDAOImpl.updateFleet(fleet1);
		assertThat(2).isEqualByComparingTo(fleet1.getTotalBusinessSeats());
		
		// deleting
		Fleet fleet2=new Fleet();
	   boolean result=fleetDAOImpl.deleteFleet(fleet2);
				assertTrue(result);
		
	}
	
	
}