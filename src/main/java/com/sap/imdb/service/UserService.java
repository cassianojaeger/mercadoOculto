package com.sap.imdb.service;

import java.util.List;

import com.sap.imdb.model.User;

public interface UserService {
	
	User findByUsername(String username);
	
	void saveUser(User user) throws Exception;
	
	void updateUser(User user) throws Exception;
	
	void removeUser(User user);
	
	User getUser(int id);
	
	List<User> getListUser();

	



	
}
