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
import com.sap.imdb.model.Order;
import com.sap.imdb.model.Product;
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
		final List<Order> ordersHistoryBuyer = checkoutService.getOrderHistoryByUserId(user, "buyer");
		final List<Order> ordersHistorySeller = checkoutService.getOrderHistoryByUserId(user, "seller");
		final List<OrderData> orderHistoryBuyerData = new ArrayList<OrderData>();
		final List<OrderData> orderHistorySellerData = new ArrayList<OrderData>();

		for (final Order order : ordersHistoryBuyer)
		{
			final OrderData orderData = new OrderData();
			orderData.setProductsInOrder(productService.getProduct(order.getProduct_id()));
			orderData.setPendentAvaliation(order.getPendentAvaliation());
			orderData.setOrderModel(order);

			orderHistoryBuyerData.add(orderData);
		}

		for (final Order order : ordersHistorySeller)
		{
			final OrderData orderData = new OrderData();
			orderData.setProductsInOrder(productService.getProduct(order.getProduct_id()));
			orderData.setPendentAvaliation(order.getPendentAvaliation());
			orderData.setOrderModel(order);
			orderData.setProductBuyerName(userService.getUser(order.getProduct_buyer_id()).getName());

			orderHistorySellerData.add(orderData);
		}


		model.addAttribute("orderList", orderHistoryBuyerData);
		model.addAttribute("orderListSeller", orderHistorySellerData);
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


	@RequestMapping(value = "/orderHistory/{id}", method = RequestMethod.GET)
	public String showOneOrderHistory(@PathVariable("id") final Integer orderId, final Model model, final Principal principal,
			final RedirectAttributes redirectAttributes)
	{
		final Order order = checkoutService.getOrderById(orderId);
		final Product orderProduct = productService.getProduct(order.getProduct_id());
		final User productBuyer = userService.getUser(order.getProduct_buyer_id());
		final OrderData orderData = new OrderData();

		orderData.setOrderModel(order);
		orderData.setPendentAvaliation(order.getPendentAvaliation());
		orderData.setProductsInOrder(orderProduct);
		orderData.setProductBuyerName(productBuyer.getName());

		model.addAttribute("orderData", orderData);

		if (orderProduct instanceof MagicItems)
		{
			return "userViews/orderMagicItemHistory";
		}
		else
		{
			return "userViews/orderMagicServiceHistory";
		}
	}
}
