package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.model.Users;
import com.services.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("dashboard")
@Api(value = "UserController", description = "Description for User controller")
public class UserController {
	@Autowired
	UserService userservice;
	@GetMapping("/login")
	@ResponseBody
	 @ApiOperation(value = "Login", httpMethod = "GET")
	public ResponseEntity<?> loginUser(String email,String password) {
		boolean flag = userservice.validateLogin(email,password);
		if(flag) {
			Users user = userservice.getUserByEmail(email);
		return new ResponseEntity<Users>(user,HttpStatus.OK);
		}else {
			String message = "Login failed!!";
			return new ResponseEntity<String>(message, HttpStatus.OK);
		}
	}
	
	@PostMapping("/updateExisting")
	 @ApiOperation(value = "Update details", httpMethod = "POST")
	public ResponseEntity<?> save(@RequestBody Users user) {
		userservice.updateUser(user);
	
		return new ResponseEntity<Users>(user,HttpStatus.OK);
		
	}
}
