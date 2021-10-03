package com.example.OnlineFlight_Booking;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.model.Payment;
import com.model.PaymentDAO;

@EnableTransactionManagement
@SpringBootTest
class PaymentTesting {
	@Autowired
	PaymentDAO paymentDAOImpl;
    Payment payment;
	@BeforeEach
	void doInit()
	{
		payment=new Payment(200);
		paymentDAOImpl.savePayment(payment);
	}
	@Test
	void testPaymentSave() {
		payment=new Payment(200);
		paymentDAOImpl.savePayment(payment);
		Payment payment1=paymentDAOImpl.findPayment(payment.getId());
		assertThat(payment1.getAmount()==payment.getAmount());
		//update and check
		paymentDAOImpl.update(payment);
		assertThat(payment1.getAmount()==payment.getAmount());
		assertThat(payment.getAmount()==200);
		Payment payment2=new Payment(); 
		payment2.setAmount(500);
		//deleting and checking
		boolean result=paymentDAOImpl.delete(payment2);
		assertThat(result==true);//Cannot invoke locations as
	}
	
	
	


	

}