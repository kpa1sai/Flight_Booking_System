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

@SpringBootTest
@EnableTransactionManagement
class FareTesting {
	
	@Autowired
	FareDAO fareDAOImpl;
	Fare fare;
	@BeforeEach
	void doInit()
	{
		fare=new Fare();
		fare.setBussinessFare(10000);
		fare.setEconomyFare(3500);
		fare.setPremiumFare(7500);
		//saving
		fareDAOImpl.saveFare(fare);
		
	}
	
	@Test
	void FareTestCRUD() {
		fare=new Fare();
		fare.setBussinessFare(10000);
		fare.setEconomyFare(3500);
		fare.setPremiumFare(7500);
		//saving
		fareDAOImpl.saveFare(fare);
		assertThat(10000.0).isEqualTo(fare.getBussinessFare());
		//find
		Fare fareobj=fareDAOImpl.findFare(fare.getId());
		assertThat(3500.0).isEqualTo(fare.getEconomyFare());
		//update start
		Fare fareobj1=new Fare();
		fareobj1.setBussinessFare(20000);
		fareobj1.setEconomyFare(4000);
		fareobj1.setPremiumFare(6500);
		fareDAOImpl.saveFare(fareobj1);
		assertThat(4000.0).isEqualTo(fareobj1.getEconomyFare());
		//updating
		fareobj1.setEconomyFare(5000);
		fareDAOImpl.updateFare(fareobj1);
		assertThat(5000.0).isEqualTo(fareobj1.getEconomyFare());
		//deleting
		Fare fareobjdel=new Fare();
		fareobjdel.setEconomyFare(2000);
		boolean result=fareDAOImpl.deleteFare(fareobjdel);
		assertTrue(result);

	}
	
}