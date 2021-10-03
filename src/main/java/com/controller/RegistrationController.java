package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Users;
import com.services.RegisterService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
@RequestMapping("register")
@Api(value = "RegistrationController", description = "Description for Registration Controller")
public class RegistrationController {
@Autowired
RegisterService registerservice;

@GetMapping("/registered")
@ApiOperation(value = "Check if registered", httpMethod = "GET")

public ResponseEntity<?> checkIfRegistered(String email)
{
	boolean flag = registerservice.isRegistered(email);
	if(flag) {
		String message = "User already exists! Please Login";
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}else {
	String message = "user doesnot exist!Continue as Guest";
	return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	
}

@PostMapping("/save")
 @ApiOperation(value = "Save details", httpMethod = "POST")
public ResponseEntity<?> saveUsers(String email,String Password,String Username) 
{	
	Users user = new Users(Username, Password, email);
	registerservice.saveRegisterUser(user);
   return ResponseEntity.ok(user+" saved");
	

}
	
}



