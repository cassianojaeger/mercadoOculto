package com.sap.imdb.controllers;

import java.security.Principal;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.service.CheckoutService;
import com.sap.imdb.service.ProductService;
import com.sap.imdb.service.UserService;
import com.sap.imdb.validations.ImdbValidate;


@Controller
@RequestMapping("/user")
public class UserController
{

	@Resource
	UserService userService;
	@Resource
	ProductService productService;
	@Resource
	CheckoutService checkoutService;
	@Resource
	ImdbValidate imdbValidate;

	//TODO ARRUMAR TUDO ISSO
	@RequestMapping(value = "/confirmPurchase/{id}", method = RequestMethod.GET)
	public String wishlist(@PathVariable("id") final Integer id, final Model model, final Principal principal,
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

			model.addAttribute("cart", magicService);
			return "userViews/confirmPurchaseMagicService";
		}

		model.addAttribute("cart", magicItem);
		return "userViews/confirmPurchaseMagicItem";
	}

	@RequestMapping(value = "/confirmPurchase/{id}", method = RequestMethod.POST)
	public String wishlist(@PathVariable("id") final Integer id, final Model model, final Principal principal,
			final RedirectAttributes redirectAttributes, final HttpServletRequest req)
	{
		final String creditCardNumber = req.getParameter("creditNumber");
		final String creditCardSecurity = req.getParameter("creditSecurity");

		final MagicItems magicItem = productService.getMagicItem(id);
		if (productService.isObjectNull(magicItem))
		{
			final MagicServices magicService = productService.getMagicService(id);
			if (productService.isObjectNull(magicService))
			{
				return "internalViews/404";
			}

			try
			{
				final String requirementList = req.getParameter("requirementList");
				imdbValidate.validadeCreditCard(creditCardNumber, creditCardSecurity);
				checkoutService.saveOrder(magicService, creditCardNumber, creditCardSecurity, principal.getName(), requirementList);
				model.addAttribute("success", "O feitiço " + magicService.getName() + " foi comprado com sucesso!");
				return "/internalViews/success";
			}
			catch (final Exception e)
			{
				model.addAttribute("success", e.getMessage());
				return "internalViews/success";
			}

		}

		try
		{
			final String itemQuantity = req.getParameter("itemQuantity");
			imdbValidate.validadeCreditCard(creditCardNumber, creditCardSecurity);
			checkoutService.saveOrder(magicItem, creditCardNumber, creditCardSecurity, principal.getName(), itemQuantity);
			model.addAttribute("success",
					"Foram compradas " + itemQuantity + " unidades do item " + magicItem.getName() + " com sucesso!");
			return "/internalViews/success";
		}
		catch (final Exception e)
		{
			model.addAttribute("success", e.getMessage());
			return "internalViews/success";
		}
	}

	/*
	 * @RequestMapping(value = "/comment/{movieId}", method = RequestMethod.POST) public String
	 * comment(@PathVariable("movieId") final Integer movieId, final HttpServletRequest req, final Principal principal) {
	 * final String comment = req.getParameter("comment"); movieService.saveComment(principal, comment, movieId); return
	 * "redirect:/home/info/" + movieId; }
	 */
}
