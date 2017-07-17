package com.sap.imdb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "user_order")
public class Order
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int product_id;
	private int product_owner_id;
	private int product_buyer_id;
	private int quantity;
	private String requirementList;
	private String pendentAvaliation;
	private int totalValue;

	/**
	 * @return the product_id
	 */
	public int getProduct_id()
	{
		return product_id;
	}

	/**
	 * @param product_id
	 *           the product_id to set
	 */
	public void setProduct_id(final int product_id)
	{
		this.product_id = product_id;
	}

	/**
	 * @return the product_owner_id
	 */
	public int getProduct_owner_id()
	{
		return product_owner_id;
	}

	/**
	 * @param product_owner_id
	 *           the product_owner_id to set
	 */
	public void setProduct_owner_id(final int product_owner_id)
	{
		this.product_owner_id = product_owner_id;
	}

	/**
	 * @return the product_buyer_id
	 */
	public int getProduct_buyer_id()
	{
		return product_buyer_id;
	}

	/**
	 * @param product_buyer_id
	 *           the product_buyer_id to set
	 */
	public void setProduct_buyer_id(final int product_buyer_id)
	{
		this.product_buyer_id = product_buyer_id;
	}

	/**
	 * @return the quantity
	 */
	public int getQuantity()
	{
		return quantity;
	}

	/**
	 * @param quantity
	 *           the quantity to set
	 */
	public void setQuantity(final int quantity)
	{
		this.quantity = quantity;
	}

	/**
	 * @return the requirementList
	 */
	public String getRequirementList()
	{
		return requirementList;
	}

	/**
	 * @param requirementList
	 *           the requirementList to set
	 */
	public void setRequirementList(final String requirementList)
	{
		this.requirementList = requirementList;
	}

	/**
	 * @return the pendentAvaliation
	 */
	public String getPendentAvaliation()
	{
		return pendentAvaliation;
	}

	/**
	 * @param pendentAvaliation
	 *           the pendentAvaliation to set
	 */
	public void setPendentAvaliation(final String pendentAvaliation)
	{
		this.pendentAvaliation = pendentAvaliation;
	}

	public int getId()
	{
		return id;
	}

	public void setId(final int id)
	{
		this.id = id;
	}

	public int getTotalValue()
	{
		return totalValue;
	}

	public void setTotalValue(final int totalValue)
	{
		this.totalValue = totalValue;
	}
}
