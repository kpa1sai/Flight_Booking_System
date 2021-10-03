package com.example.OnlineFlight_Booking;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Passenger;
import com.model.PassengerDAO;
@EnableTransactionManagement
@SpringBootTest
class PassengerTesting {
	@Autowired
	PassengerDAO passengerDAOimpl;
    Passenger passenger;
	@BeforeEach
	void doInit()
	{
		passenger=new Passenger();
		passenger.setFirstName("Gayatri");
		passenger.setLastName("Pareek");
		passenger.setAge(21);
		passenger.setGender('F');
		passenger.setPassportNo("2940");
		passenger.setMealPref("Veg");
		passengerDAOimpl.savePassenger(passenger);
	}
	@Test
	void testPassengerCRUD() {
		Passenger passenger=new Passenger();
		passenger.setFirstName("Gayatri");
		passenger.setLastName("Pareek");
		passenger.setAge(21);
		passenger.setGender('F');
		passenger.setPassportNo("2940");
		passenger.setMealPref("Veg");
		
		//save
		passengerDAOimpl.savePassenger(passenger);
		Passenger passenger1=passengerDAOimpl.findPassenger(passenger.getId());
		assertThat(passenger1.getPassportNo()==(passenger.getPassportNo()));
		assertThat(passenger.getPassportNo()=="2940");
		//update 
		passenger.setPassportNo("7000");
		passengerDAOimpl.updatePassenger(passenger);
		//delete
		boolean result=passengerDAOimpl.deletePassenger(passenger1);
		assertThat(result==true);
	}



	

}
