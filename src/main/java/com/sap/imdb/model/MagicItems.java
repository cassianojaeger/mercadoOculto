package com.sap.imdb.model;

import javax.persistence.Entity;


@Entity
public class MagicItems extends Product
{
	private int stockQuantity;

	public int getStockQuantity()
	{
		return stockQuantity;
	}

	public void setStockQuantity(final int stockQuantity)
	{
		this.stockQuantity = stockQuantity;
	}
}
