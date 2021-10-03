package com.model.repo;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer>{
	@Query("SELECT u from Users u WHERE u.email = ?1")
	Optional<Users> findUsersByemail(String email);
	@Query("SELECT u FROM Users u WHERE u.email =?1 and u.password = ?2")
	Optional<Users> findUsersByemailAndPassword(String email,String password);
	
}
