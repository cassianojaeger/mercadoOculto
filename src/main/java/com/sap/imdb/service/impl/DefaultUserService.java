package com.sap.imdb.service.impl;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import com.sap.imdb.dao.ProductDao;
import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.Product;
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
	public String saveCart(final Product product, final Principal principal)
	{
		final String username = principal.getName();
		final User user = userDao.findByUserName(username);
		for (final Product userProducts : user.getCartList())
		{
			if (userProducts.getId() == product.getId())
			{
				user.getCartList().remove(userProducts);
				userDao.update(user);
				return "Item removido do carrinho";
			}
		}
		user.getCartList().add(product);
		userDao.update(user);
		return "Item adicionado no carrinho";
	}

	@Override
	public List<Product> showCart(final Principal principal)
	{
		final User user = userDao.findByUserName(principal.getName());
		return user.getCartList();
	}
}
