package com.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Fleet;

@Repository
public interface FleetRepo extends JpaRepository<Fleet, Integer>{
	
}
