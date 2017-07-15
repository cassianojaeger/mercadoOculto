package com.sap.imdb.dao;

import org.springframework.transaction.annotation.Transactional;

import com.sap.imdb.model.Order;


@Transactional
public interface CheckoutDao
{
	public void saveOrder(Order order);
}
