package com.sap.imdb.service;

import java.security.Principal;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Product;
import com.sap.imdb.model.User;


@Transactional
public interface ProductService
{
	public List<Product> getProductList();

	void saveMagicItem(MagicItems magicItem, Principal principal);

	void uploadThumbnail(MultipartFile file, Product product, String webContextPath) throws Exception;

	public void saveMagicService(MagicServices magicService, Principal principal);

	void removeProduct(Product product);

	MagicItems getMagicItem(int id);

	MagicServices getMagicService(int id);

	Product getProduct(int id);

	List<Product> getProductsByName(String name);

	List<Product> getProductsByDescription(String description);

	<T extends Product> List<T> getProductsByNameOrDescription(String nameOrDescription, Class<T> class1);

	boolean isObjectNull(Object object);

	List<Product> getProductListByUser(User user);
}
