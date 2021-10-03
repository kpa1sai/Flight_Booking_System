package com.services;

import org.springframework.stereotype.Component;

@Component
public class LoginService {
	/*
	@Autowired
	  UserDAO UserDAOImpl;
	
	public String login(Users users) {
		if(UserDAOImpl.findUserName().contains(users.getUserName()) && UserDAOImpl.findPassword().contains(users.getPassword())) {
			return "Users";
		}
		if(users.getUserName()=="admin" && users.getPassword()=="admin123") {
			return "Admin";
		}
		
		if(users.getUserName().isEmpty() && users.getPassword().isEmpty()) {
			return "Required fields Empty";
		}
		
		if(!UserDAOImpl.findUserName().contains(users.getUserName()) && !UserDAOImpl.findPassword().contains(users.getPassword())) {
			return "Invalid Credentials";
		}
		else {
			return null;
		}
		
	}
	//check if email id ,username and password is matching ....
	//forgot password
*/
}
