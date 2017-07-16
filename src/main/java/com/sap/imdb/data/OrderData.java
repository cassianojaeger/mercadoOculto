package com.sap.imdb.data;

import com.sap.imdb.model.Order;
import com.sap.imdb.model.Product;


public class OrderData
{
	private Order orderModel;
	private Product productsInOrder;
	private String pendentAvaliation;
	private String productBuyerName;

	public Product getProductsInOrder()
	{
		return productsInOrder;
	}

	public void setProductsInOrder(final Product productsInOrder)
	{
		this.productsInOrder = productsInOrder;
	}

	public String getPendentAvaliation()
	{
		return pendentAvaliation;
	}

	public void setPendentAvaliation(final String pendentAvaliation)
	{
		this.pendentAvaliation = pendentAvaliation;
	}

	public Order getOrderModel()
	{
		return orderModel;
	}

	public void setOrderModel(final Order orderModel)
	{
		this.orderModel = orderModel;
	}

	public String getProductBuyerName()
	{
		return productBuyerName;
	}

	public void setProductBuyerName(String productBuyerName)
	{
		this.productBuyerName = productBuyerName;
	}


}
