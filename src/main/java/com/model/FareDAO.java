package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface FareDAO {
	public void saveFare(Fare fare);
	public Fare findFare(int id);

	public boolean updateFare(Fare fare);
	public boolean deleteFare(Fare fare);


}