package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component

public interface PaymentDAO {
	public void savePayment(Payment payment);
	public Payment findPayment(int id);
	
	public boolean update(Payment payment);
	public boolean delete(Payment payment);
}
