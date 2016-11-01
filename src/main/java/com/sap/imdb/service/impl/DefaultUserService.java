package com.sap.imdb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.User;
import com.sap.imdb.service.UserService;
import com.sap.imdb.validations.ImdbValidate;

public class DefaultUserService implements UserService{

	@Resource
	private UserDao userDao;
	@Resource
	private ImdbValidate ImdbValidate;
	
	@Override
    public User findByUsername(String username) {
        return userDao.findByUserName(username);
    }
	
	@Override
	public void saveUser(User user) throws Exception {		
		ImdbValidate.validateSignUp(user);
		userDao.save(user);
	}

	@Override
	public void updateUser(User user) throws Exception {
		ImdbValidate.validateSignUp(user);
		userDao.update(user);		
	}
	
	@Override
	public void updateUserLoginDate(User user) throws Exception {
		userDao.update(user);
	}

	@Override
	public void removeUser(User user) {	
		userDao.remove(user);
	}

	@Override
	public User getUser(int id) {
		return userDao.getUser(id);
	}

	@Override
	public List<User> getListUser() {
		return userDao.getListUser();
	}
	
}
