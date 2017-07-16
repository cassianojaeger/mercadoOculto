package com.sap.imdb.service.impl;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import com.sap.imdb.dao.ProductDao;
import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.Comment;
import com.sap.imdb.model.User;
import com.sap.imdb.service.UserService;
import com.sap.imdb.validations.ImdbValidate;


public class DefaultUserService implements UserService
{

	@Resource
	private UserDao userDao;
	@Resource
	private ImdbValidate ImdbValidate;
	@Resource
	private ProductDao productDao;


	@Override
	public User findByUsername(final String username)
	{
		return userDao.findByUserName(username);
	}

	@Override
	public void saveUser(final User user) throws Exception
	{
		ImdbValidate.validateSignUp(user);
		userDao.save(user);
	}

	@Override
	public void updateUser(final User user) throws Exception
	{
		ImdbValidate.validateSignUp(user);
		userDao.update(user);
	}

	@Override
	public void updateUserLoginDate(final User user) throws Exception
	{
		userDao.update(user);
	}

	@Override
	public void removeUser(final User user, final Principal principal) throws Exception
	{
		final User loggedUser = userDao.findByUserName(principal.getName());
		if (user.getId() == loggedUser.getId())
		{
			throw new Exception("Não é possível deletar o usuário em que se está logado no momento");
		}
		else
		{
			userDao.remove(user);
		}
	}

	@Override
	public User getUser(final int id)
	{
		return userDao.getUser(id);
	}

	@Override
	public List<User> getListUser()
	{
		return userDao.getListUser();
	}

	@Override
	public void saveComment(final Principal principal, final String comment, final Integer userId)
	{
		final Comment newComment = new Comment();
		newComment.setComment(comment);
		newComment.setUser(principal.getName());
		final User user = userDao.getUser(userId);
		user.getComments().add(newComment);
		userDao.update(user);
	}

	@Override
	public void calculateVendorRating(final User vendor, final String rating)
	{
		final int newRating = vendor.getNumOfRatings() + 1;
		vendor.setNumOfRatings(newRating);
		vendor.setVendorGrade((vendor.getVendorGrade() + Integer.parseUnsignedInt(rating)) / newRating);
		userDao.update(vendor);
	}

	@Override
	public List<User> getUsersByNameOrEmail(final String filter, final String orderDisplay)
	{
		return userDao.getUsersByNameOrEmail(filter, orderDisplay);
	}
}
