package com.sap.imdb.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sap.imdb.model.User;

@Transactional
public interface UserService {
	
	User findByUsername(String username);
	
	void saveUser(User user) throws Exception;
	
	void updateUser(User user) throws Exception;
	
	void removeUser(User user);
	
	User getUser(int id);
	
	List<User> getListUser();

	void updateUserLoginDate(User user) throws Exception;
	
}
