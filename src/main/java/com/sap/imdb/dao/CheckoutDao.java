package com.sap.imdb.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sap.imdb.model.Order;


@Transactional
public interface CheckoutDao
{
	public void saveOrder(Order order);

	List<Order> getOrderHistoryByUserId(int user_id);

	Order getOrderById(int id);

	public void updateOrder(Order order);
}
