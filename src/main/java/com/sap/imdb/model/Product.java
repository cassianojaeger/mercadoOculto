package com.sap.imdb.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;


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


	@ManyToMany(mappedBy = "cartList")
	@JsonIgnore
	private List<User> users;


	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Comment> comments;


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

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(final List<Comment> comments)
	{
		this.comments = comments;
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
