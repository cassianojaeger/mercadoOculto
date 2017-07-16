package com.sap.imdb.controllers;



import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Product;
import com.sap.imdb.model.User;
import com.sap.imdb.model.UserTypes;
import com.sap.imdb.service.ProductService;
import com.sap.imdb.service.UserService;


@RequestMapping(value = "/home")
@Controller
public class HomeController
{

	@Resource
	private ProductService productService;
	@Resource
	private UserService userService;

	@RequestMapping
	public String showProductList(final Model model)
	{
		final List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "/homeViews/homepage";
	}

	@RequestMapping(value = "/products/filterByName", method = RequestMethod.GET)
	public String filterByName(@RequestParam("filter") final String filter, final Model model)
	{
		final List<Product> products = productService.getProductsByNameOrDescription(filter);

		model.addAttribute("products", products);
		return "/homeViews/products-grid";
	}

	@RequestMapping("/view-all-vendors")
	public String showVendorsList(final Model model)
	{
		final List<User> users = userService.getListUser();
		final List<User> magicians = new ArrayList<>();
		for (final User user : users)
		{
			if (user.getUserTypes() == UserTypes.BRUXO)
			{
				magicians.add(user);
			}
		}

		model.addAttribute("users", magicians);
		return "/homeViews/vendorsListPage";
	}

	@RequestMapping(value = "/view-all-vendors/filterByName", method = RequestMethod.GET)
	public String showVendorsList(@RequestParam("filter") final String filter, final Model model)
	{
		final List<User> users = userService.getUsersByNameOrEmail(filter);
		final List<User> magicians = new ArrayList<>();
		for (final User user : users)
		{
			if (user.getUserTypes() == UserTypes.BRUXO)
			{
				magicians.add(user);
			}
		}

		model.addAttribute("users", magicians);
		return "/homeViews/vendors-grid";
	}

	@RequestMapping("/info/{id}")
	public String getProductsInfo(@PathVariable("id") final Integer id, final Model model)
	{
		final MagicItems magicItem = productService.getMagicItem(id);
		if (productService.isObjectNull(magicItem))
		{
			final MagicServices magicService = productService.getMagicService(id);
			if (productService.isObjectNull(magicService))
			{
				return "internalViews/404";
			}
			model.addAttribute("magicService", magicService);
			return "/homeViews/magicServiceInfo";
		}

		model.addAttribute("magicItem", magicItem);
		return "/homeViews/magicItemInfo";
	}
}
