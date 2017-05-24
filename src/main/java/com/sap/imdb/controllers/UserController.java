package com.sap.imdb.controllers;

import java.security.Principal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Product;
import com.sap.imdb.service.ProductService;
import com.sap.imdb.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController
{

	@Resource
	UserService userService;
	@Resource
	ProductService productService;

	//TODO ARRUMAR TUDO ISSO
	@RequestMapping(value = "/addToCart/{id}", method = RequestMethod.POST)
	public String wishlist(@PathVariable("id") final Integer id, final Principal principal,
			final RedirectAttributes redirectAttributes)
	{
		final MagicItems magicItem = productService.getMagicItem(id);
		if (productService.isObjectNull(magicItem))
		{
			final MagicServices magicService = productService.getMagicService(id);
			if (productService.isObjectNull(magicService))
			{
				return "internalViews/404";
			}
			final String message = userService.saveCart(magicService, principal);
			redirectAttributes.addFlashAttribute("message", message);

			return "redirect:/home/info/" + id;
		}

		final String message = userService.saveCart(magicItem, principal);
		redirectAttributes.addFlashAttribute("message", message);

		return "redirect:/home/info/" + id;
	}


	@RequestMapping("/cartPage")
	public String showCartPage(final Principal principal, final Model model)
	{
		final List<Product> product = userService.showCart(principal);
		model.addAttribute("cart", product);
		return "/userViews/cartPage";
	}


	/*
	 * @RequestMapping(value = "/comment/{movieId}", method = RequestMethod.POST) public String
	 * comment(@PathVariable("movieId") final Integer movieId, final HttpServletRequest req, final Principal principal) {
	 * final String comment = req.getParameter("comment"); movieService.saveComment(principal, comment, movieId); return
	 * "redirect:/home/info/" + movieId; }
	 */
}
