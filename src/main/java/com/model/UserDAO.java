package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface UserDAO {

	public Users findUser(int id);

	public List<Users> findAll();
	public boolean updateUser(Users users);
	public boolean deleteUser(Users users);

	public void saveUsers(Users users);
	
	
	
}