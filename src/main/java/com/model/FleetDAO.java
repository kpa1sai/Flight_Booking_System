package com.model;

import java.util.List;

import org.springframework.stereotype.Component;



@Component
public interface FleetDAO {
public void saveFleet(Fleet fleet);

public Fleet findFleet(int id);
public boolean updateFleet(Fleet fleet);
public boolean deleteFleet(Fleet fleet);
}