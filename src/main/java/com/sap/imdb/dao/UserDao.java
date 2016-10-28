package com.sap.imdb.dao;

import java.util.List;

import com.sap.imdb.model.User;

public interface UserDao {
	
	User findByUserName(String username);
	
	void save(User user);
	
	void update(User user);
	
	void remove(User user);
	
	User getUser(int id);
	
	List<User> getListUser();

	Boolean alreadyHasUsername(User user);
}

