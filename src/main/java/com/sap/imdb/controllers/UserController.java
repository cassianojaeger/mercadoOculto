package com.sap.imdb.controllers;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sap.imdb.data.OrderData;
import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;
import com.sap.imdb.model.Order;
import com.sap.imdb.model.User;
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


	@RequestMapping(value = "/confirmPurchase/{id}", method = RequestMethod.GET)
	public String confirmPurchase(@PathVariable("id") final Integer id, final Model model, final Principal principal,
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
	public String confirmPurchase(@PathVariable("id") final Integer id, final Model model, final Principal principal,
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

	@RequestMapping(value = "/profile", method = RequestMethod.GET)
	public String showLoggedUserProfile(final Model model, final Principal principal, final RedirectAttributes redirectAttributes)
	{
		try
		{
			final User user = userService.findByUsername(principal.getName());
			model.addAttribute("products", productService.getProductListByUser(user));
			model.addAttribute("user", user);
		}
		catch (final Exception e)
		{
			return "internalViews/405";
		}


		return "userViews/userProfile";
	}

	@RequestMapping(value = "/profile/{id}", method = RequestMethod.GET)
	public String showUsersProfile(@PathVariable("id") final Integer id, final Model model, final Principal principal,
			final RedirectAttributes redirectAttributes)
	{
		final User profileUser = userService.getUser(id);

		model.addAttribute("products", productService.getProductListByUser(profileUser));
		model.addAttribute("user", profileUser);

		return "userViews/userProfile";
	}

	@RequestMapping(value = "/orderHistory", method = RequestMethod.GET)
	public String showOrderHistory(final Model model, final Principal principal, final RedirectAttributes redirectAttributes)
	{
		final User user = userService.findByUsername(principal.getName());
		final List<Order> ordersHistory = checkoutService.getOrderHistoryByUserId(user);
		final List<OrderData> orderHistoryData = new ArrayList<OrderData>();

		for (final Order order : ordersHistory)
		{
			final OrderData orderData = new OrderData();
			orderData.setProductsInOrder(productService.getProduct(order.getProduct_id()));
			orderData.setPendentAvaliation(order.getPendentAvaliation());
			orderData.setOrderModel(order);

			orderHistoryData.add(orderData);
		}

		model.addAttribute("orderList", orderHistoryData);
		return "userViews/orderHistory";
	}

	@RequestMapping(value = "/orderHistory/rate", method = RequestMethod.GET)
	public boolean rateVendor(@RequestParam("rating") final String rating, @RequestParam("orderModelId") final int orderModelId,
			final Model model, final Principal principal, final RedirectAttributes redirectAttributes, final HttpServletRequest req)
	{
		final Order order = checkoutService.getOrderById(orderModelId);
		final User vendor = userService.getUser(order.getProduct_owner_id());
		userService.calculateVendorRating(vendor, rating);
		checkoutService.updateOrder(order);
		return true;
	}

	@RequestMapping(value = "/comment/{userId}", method = RequestMethod.POST)
	public String comment(@PathVariable("userId") final Integer userId, final HttpServletRequest req, final Principal principal)
	{
		final String comment = req.getParameter("comment");
		userService.saveComment(principal, comment, userId);
		return "redirect:/user/profile/" + userId;
	}

}
