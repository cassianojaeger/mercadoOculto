package com.sap.imdb.dao.impl;

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

}
