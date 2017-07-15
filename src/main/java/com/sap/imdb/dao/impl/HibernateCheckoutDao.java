package com.sap.imdb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sap.imdb.dao.CheckoutDao;
import com.sap.imdb.model.Order;


public class HibernateCheckoutDao extends HibernateDaoSupport implements CheckoutDao
{

	@Override
	public void saveOrder(final Order order)
	{
		getHibernateTemplate().save(order);

	}

	@Override
	public List<Order> getOrderHistoryByUserId(final int user_id)
	{
		final String query = "from com.sap.imdb.model.Order where product_buyer_id like :user_id";
		return (List<Order>) getHibernateTemplate().findByNamedParam(query, "user_id", user_id);
	}

	@Override
	public Order getOrderById(final int id)
	{
		final String query = "from com.sap.imdb.model.Order where id like :id";
		return (Order) getHibernateTemplate().findByNamedParam(query, "id", id).get(0);
	}

	@Override
	public void updateOrder(final Order order)
	{
		getHibernateTemplate().update(order);
	}

}
