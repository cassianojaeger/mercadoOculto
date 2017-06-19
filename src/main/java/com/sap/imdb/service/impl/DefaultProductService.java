package com.sap.imdb.service.impl;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.multipart.MultipartFile;

import com.sap.imdb.config.FileSaver;
import com.sap.imdb.dao.ProductDao;
import com.sap.imdb.dao.UserDao;
import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Product;
import com.sap.imdb.service.ProductService;
import com.sap.imdb.service.UserService;


public class DefaultProductService implements ProductService
{

	@Resource
	private FileSaver fileSaver;
	@Resource
	private ProductDao productDao;
	@Resource
	private UserDao userDao;
	@Resource
	UserService userService;

	@Override
	public List<Product> getProductList()
	{
		return productDao.getProductList();
	}

	@Override
	public void uploadThumbnail(final MultipartFile file, final Product product) throws Exception
	{
		final String webPath = fileSaver.write("/resources/uploaded-thumbnails", file);
		product.setThumbnail(webPath);
	}

	@Override
	public void saveMagicService(final MagicServices magicService, final Principal principal)
	{
		magicService.setOwner(userService.findByUsername(principal.getName()));
		productDao.save(magicService, principal);
	}

	@Override
	public void saveMagicItem(final MagicItems magicItem, final Principal principal)
	{
		magicItem.setOwner(userService.findByUsername(principal.getName()));
		productDao.save(magicItem, principal);
	}

	@Override
	public void removeProduct(final Product product)
	{
		productDao.remove(product);
	}

	@Override
	public MagicItems getMagicItem(final int id)
	{
		return productDao.getMagicItem(id);
	}

	@Override
	public MagicServices getMagicService(final int id)
	{
		return productDao.getMagicService(id);
	}

	@Override
	public Product getProduct(final int id)
	{
		return productDao.getProduct(id);
	}

	@Override
	public List<Product> getProductsByName(final String name)
	{
		return productDao.getProductsByName(name);
	}

	@Override
	public List<Product> getProductsByDescription(final String description)
	{
		return productDao.getProductsByDescription(description);
	}

	@Override
	public List<Product> getProductsByNameOrDescription(final String nameOrDescription)
	{
		return productDao.getProductsByNameOrDescription(nameOrDescription);
	}

	@Override
	public boolean isObjectNull(final Object object)
	{
		if (object == null)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

}