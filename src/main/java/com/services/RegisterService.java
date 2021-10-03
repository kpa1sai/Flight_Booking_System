package com.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Users;
import com.model.repo.UserRepo;



   @Component
   public class RegisterService {
	
		/*
		 * @Autowired UserDAO userDAOImpl;
		 * 
		 * @Autowired SessionFactory sessionFactory;
		 */
  @Autowired
  UserRepo userRepo;

   public void saveRegisterUser(Users users) {
	 // userDAOImpl.saveUser(users);
	   Optional<Users> userByEmail = userRepo.findUsersByemail(users.getEmail());
	   if(userByEmail.isPresent()) {
		   System.out.println("User already exists");
	   }else {
	   userRepo.save(users);
	   //userDAOImpl.saveUsers(users);
	   System.out.println("The User added");
	   }
   
      
  }
   public List<Users> findRegisterUser(Users users) {
	  return  userRepo.findAll();
	//return userDAOImpl.findAll();
	   
	   
   }
   public boolean isRegistered(String email) {
	   Optional<Users> userByEmail = userRepo.findUsersByemail(email);
	   if(userByEmail.isPresent()) {
		   return true;
	   }
	   return false;
   }
  //we check if the user is already registered..if not we add the details to database..in above method

   }