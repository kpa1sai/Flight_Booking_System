package com.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface ContactDAO {

	public void saveContact(Contact contact);
	public boolean deleteContact(Contact contact);
	public boolean updateContact(Contact contact);
	public Contact findContact(int id);
	
}