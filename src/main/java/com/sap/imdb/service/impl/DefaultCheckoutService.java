package com.sap.imdb.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sap.imdb.dao.CheckoutDao;
import com.sap.imdb.dao.ProductDao;
import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Order;
import com.sap.imdb.model.User;
import com.sap.imdb.service.CheckoutService;


public class DefaultCheckoutService implements CheckoutService
{

	@Resource
	private CheckoutDao checkoutDao;
	@Resource
	private UserDao userDao;
	@Resource
	private ProductDao productDao;

	@Override
	public void saveOrder(final MagicItems magicItem, final String creditCardNumber, final String creditSecurity,
			final String buyerUsername, final String quantityBought) throws Exception
	{
		final Order order = new Order();
		order.setProduct_buyer_id(userDao.findByUserName(buyerUsername).getId());
		order.setProduct_id(magicItem.getId());
		order.setProduct_owner_id(magicItem.getOwner().getId());
		order.setQuantity(Integer.parseUnsignedInt(quantityBought));

		if (order.getQuantity() > magicItem.getStockQuantity())
		{
			throw new Exception("Não há quantidade suficiente de itens. Quantidade disponível é: " + magicItem.getStockQuantity());
		}

		order.setPendentAvaliation("yes");
		magicItem.setStockQuantity(magicItem.getStockQuantity() - order.getQuantity());
		productDao.update(magicItem);
		checkoutDao.saveOrder(order);
	}


	@Override
	public void saveOrder(final MagicServices magicServices, final String creditCardNumber, final String creditSecurity,
			final String buyerUsername, final String requirementList)
	{
		final Order order = new Order();
		order.setProduct_buyer_id(userDao.findByUserName(buyerUsername).getId());
		order.setProduct_id(magicServices.getId());
		order.setProduct_owner_id(magicServices.getOwner().getId());
		order.setRequirementList(requirementList);

		order.setPendentAvaliation("yes");
		productDao.update(magicServices);
		checkoutDao.saveOrder(order);
	}


	@Override
	public List<Order> getOrderHistoryByUserId(final User user, final String buyer_seller)
	{
		return checkoutDao.getOrderHistoryByUserId(user.getId(), buyer_seller);
	}

	@Override
	public Order getOrderById(final int id)
	{
		return checkoutDao.getOrderById(id);
	}


	@Override
	public void updateOrder(final Order order)
	{
		order.setPendentAvaliation("no");
		checkoutDao.updateOrder(order);
	}

}
