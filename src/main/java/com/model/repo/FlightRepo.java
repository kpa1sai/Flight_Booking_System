package com.model.repo;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.model.Flight;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer>{
	@Query("SELECT f FROM Flight f where f.arrivalLocation = ?1 and f.departureLocation = ?2 and f.arrivalTime > ?3")
	Optional<Flight> findByArrivalLocationAndDepartureLocationAndArrivalTime(String arrivalLocation,String departureLocation,Date arrivalTime);
}
