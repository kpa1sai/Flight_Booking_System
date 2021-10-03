package com.model.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer>{

}
