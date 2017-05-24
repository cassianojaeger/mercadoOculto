package com.sap.imdb.dao;

import java.security.Principal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Product;
import com.sap.imdb.model.User;


@Transactional
public interface ProductDao
{
	List<Product> getProductList();

	<T extends Product> void save(T obj, Principal principal);

	MagicItems getMagicItem(int id);

	MagicServices getMagicService(int id);

	void remove(Product product);

	Product getProduct(int id);

	List<Product> getProductsByName(String name);

	List<Product> getProductsByDescription(String description);

	List<Product> getProductsByNameOrDescription(String nameOrDescription);

	List<Product> getProductsByUser(User user);
}
