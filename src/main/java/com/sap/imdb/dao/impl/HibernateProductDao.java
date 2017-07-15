package com.sap.imdb.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import com.sap.imdb.dao.ProductDao;
import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Product;
import com.sap.imdb.model.User;


public class HibernateProductDao extends HibernateDaoSupport implements ProductDao
{

	@Override
	public List<Product> getProductList()
	{
		return (List<Product>) getHibernateTemplate().find("from com.sap.imdb.model.Product");
	}

	@Override
	public <T extends Product> void save(final T obj)
	{
		getHibernateTemplate().save(obj);
	}

	@Override
	public <T extends Product> void update(final T obj)
	{
		getHibernateTemplate().update(obj);
	}

	@Override
	public MagicItems getMagicItem(final int id)
	{
		return getHibernateTemplate().get(MagicItems.class, id);
	}

	@Override
	public MagicServices getMagicService(final int id)
	{
		return getHibernateTemplate().get(MagicServices.class, id);
	}

	@Override
	public Product getProduct(final int id)
	{
		return getHibernateTemplate().get(Product.class, id);
	}

	@Override
	public void remove(final Product product)
	{
		getHibernateTemplate().delete(product);
	}

	@Override
	public List<Product> getProductsByName(final String name)
	{
		final String query = "from com.sap.imdb.model.Product where name like :name";
		return (List<Product>) getHibernateTemplate().findByNamedParam(query, "name", '%' + name + '%');
	}

	@Override
	public List<Product> getProductsByNameOrDescription(final String nameOrDescription)
	{
		final String query = "from com.sap.imdb.model.Product where name like :nameOrDescription or description like :nameOrDescription";
		return (List<Product>) getHibernateTemplate().findByNamedParam(query, "nameOrDescription", '%' + nameOrDescription + '%');
	}

	@Override
	public List<Product> getProductsByDescription(final String description)
	{
		final String query = "from com.sap.imdb.model.Product where description like :description";
		return (List<Product>) getHibernateTemplate().findByNamedParam(query, "description", '%' + description + '%');
	}

	@Override
	public List<Product> getProductsByUser(final User user)
	{
		final String query = "select productsOnwed from com.sap.imdb.model.User where username like :username";
		return (List<Product>) getHibernateTemplate().findByNamedParam(query, "username", user.getUsername());
	}
}
