package com.model;

import org.springframework.stereotype.Component;

@Component
public interface FlightStatusDAO {
		public void saveFlightStatus(FlightStatus flightstatus);
		public boolean deleteFlightStatus(FlightStatus flightstatus);
		public boolean updateFlightStatus(FlightStatus flightstatus);
		public FlightStatus findFlightStatus(int id);
	
}