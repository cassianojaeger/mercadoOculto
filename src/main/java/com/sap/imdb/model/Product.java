package com.sap.imdb.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 *
 */
@Entity
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "USER_ID", nullable = false)
	private User owner;
	@NotBlank
	private String name;
	private float price;
	@NotBlank
	@Length(min = 0, max = 512)
	@Column(length = 2048)
	private String description;
	@Column(length = 1024)
	private String thumbnail;

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(final String description)
	{
		this.description = description;
	}

	public String getThumbnail()
	{
		return thumbnail;
	}

	public void setThumbnail(final String thumbnail)
	{
		this.thumbnail = thumbnail;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(final float price)
	{
		this.price = price;
	}

	public int getId()
	{
		return id;
	}

	public void setId(final int id)
	{
		this.id = id;
	}

	public User getOwner()
	{
		return owner;
	}

	public void setOwner(final User owner)
	{
		this.owner = owner;
	}




}
