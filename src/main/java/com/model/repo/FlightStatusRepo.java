package com.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.FlightStatus;

@Repository
public interface FlightStatusRepo extends JpaRepository<FlightStatus, Integer>{

}
