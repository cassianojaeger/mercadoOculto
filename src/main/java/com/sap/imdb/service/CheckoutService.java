package com.sap.imdb.service;

import com.sap.imdb.model.MagicItems;
import com.sap.imdb.model.MagicServices;


public interface CheckoutService
{
	public void saveOrder(MagicServices magicServices, String creditCardNumber, String creditSecurity, String buyerUsername,
			String requirementList);

	void saveOrder(MagicItems magicItem, String creditCardNumber, String creditSecurity, String buyerUsername,
			String quantityBought) throws Exception;
}
