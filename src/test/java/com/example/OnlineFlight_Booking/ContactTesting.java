package com.example.OnlineFlight_Booking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Contact;
import com.model.ContactDAO;

@SpringBootTest
@EnableTransactionManagement
class ContactTesting {

	
	@Autowired
	ContactDAO contactDAOImpl;
	Contact contact;
	
	@BeforeEach
	void doInit()
	{
		contact=new Contact();
		contact.setAddressLine("12.mg road");
		contact.setCity("hubli");
		contact.setState("KA");
		contact.setZipCode(509097);
		contact.setCountry("India");
		contact.setType("Mobile");
		contact.setMobileNo(990088990);
        contactDAOImpl.saveContact(contact);
}
	
	
	@Test
	void ContactCRUD() {
		contact=new Contact();
		contact.setAddressLine("12.mg road");
		contact.setCity("hubli");
		contact.setState("KA");
		contact.setZipCode(509097);
		contact.setCountry("India");
		contact.setType("Mobile");
		contact.setMobileNo(990088990);
		//saving
        contactDAOImpl.saveContact(contact);
        //find
        Contact contactobj=contactDAOImpl.findContact(contact.getId());
        assertThat("KA").isEqualTo(contact.getState());
        assertThat(contactobj.getCity()==contact.getCity());
        //update
        Contact contactobj2=new Contact();
        contactobj2.setAddressLine("15'11 colony");
        contactobj2.setCity("kamareddy");
        contactobj2.setState("TS");
        contactobj2.setZipCode(504003);
        contactobj2.setCountry("India");
        contactobj2.setType("Mobile");
        contactobj2.setMobileNo(65889090);
        contactDAOImpl.saveContact(contactobj2);
        contactobj2.setCity("Adilabad");
       
        contactDAOImpl.updateContact(contactobj2);
        assertThat("Adilabad").isEqualTo(contactobj2.getCity());
        assertThat(contactobj2.getCity()!=contact.getCity());
        
        
        
        
}
	}

