package com.sap.imdb.service;

import java.util.List;

import com.sap.imdb.model.User;

public interface UserService {
	void saveUser(User user);
	
	void updateUser(User user);
	
	void removeUser(User user);
	
	User getUser(int id);
	
	List<User> getListUser();
}
