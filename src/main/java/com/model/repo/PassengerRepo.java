package com.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Passenger;

@Repository
public interface PassengerRepo extends JpaRepository<Passenger, Integer>{

}
