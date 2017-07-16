package com.sap.imdb.service;

import java.util.List;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Order;
import com.sap.imdb.model.User;


public interface CheckoutService
{
	public void saveOrder(MagicServices magicServices, String creditCardNumber, String creditSecurity, String buyerUsername,
			String requirementList);

	void saveOrder(MagicItems magicItem, String creditCardNumber, String creditSecurity, String buyerUsername,
			String quantityBought) throws Exception;

	List<Order> getOrderHistoryByUserId(User user, String buyer_seller);

	Order getOrderById(int id);

	public void updateOrder(Order order);
}
