package com.example.OnlineFlight_Booking;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Location;
import com.model.LocationDAO;

@EnableTransactionManagement
@SpringBootTest
class LocationTesting {
	@Autowired
	LocationDAO locationDAOImpl;
    Location location;
	@BeforeEach
	void doInit()
	{
		location=new Location();
		location.setName("Gayatri");
		location.setCode("500011");
		location.setCountry("Hyd");
		location.setAirportName("Rajiv");
		locationDAOImpl.saveLocation(location);
	}
	@Test
	void testLocationSave() {
		location=new Location();
		location.setName("Gayatri");
		location.setCode("500011");
		location.setCountry("Hyd");
		location.setAirportName("Rajiv");
		locationDAOImpl.saveLocation(location);
		Location location1=locationDAOImpl.findLocation(location.getId());
		assertThat(location1.getCode()==(location.getCode()));
		assertThat(location.getCode()=="500011");
		Location location2=new Location();
		location2.setCode("50949");
		locationDAOImpl.saveLocation(location2);
		locationDAOImpl.updateLocation(location2);
		assertThat(location.getCode()=="50949");
		
		Location location3=new Location();
		location3.setName("Adb");
		location3.setCode("504001");
		location3.setAirportName("Rajiv gandhi domestic");
		location3.setCountry("india");
		boolean result=locationDAOImpl.deleteLocation(location3);
		assertTrue(result);

	}
	
}