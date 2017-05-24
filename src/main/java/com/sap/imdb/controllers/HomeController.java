package com.sap.imdb.controllers;



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
import com.sap.imdb.service.ProductService;


@RequestMapping(value = "/home")
@Controller
public class HomeController
{

	@Resource
	private ProductService productService;

	@RequestMapping
	public String showProductList(final Model model)
	{
		final List<Product> products = productService.getProductList();
		model.addAttribute("products", products);
		return "/homeViews/homepage";
	}

	@RequestMapping(value = "/filterByName", method = RequestMethod.GET)
	public String filterByName(@RequestParam("filter") final String filter, final Model model)
	{
		final List<Product> products = productService.getProductsByNameOrDescription(filter);

		model.addAttribute("products", products);
		return "/homeViews/products-grid";
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
