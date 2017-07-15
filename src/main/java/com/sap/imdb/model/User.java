package com.sap.imdb.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;


@Entity
@Table(name = "user")
public class User
{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String email;
	@Column(name = "username")
	private String username;
	private String password;
	private float vendorGrade;
	private int numOfRatings;
	@NotNull
	private UserTypes userTypes;

	//mappedBy referencia a variavel do outro lado da relação
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "owner")
	private List<Product> productsOnwed;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "USER_ROLE")
	private List<Role> roles;

	@ElementCollection
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Comment> comments;

	private LocalDateTime lastLogin;

	public LocalDateTime getLastLogin()
	{
		return lastLogin;
	}

	public void setLastLogin(final LocalDateTime lastLogin)
	{
		this.lastLogin = lastLogin;
	}

	public int getId()
	{
		return id;
	}

	public void setId(final int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(final String name)
	{
		this.name = name;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(final String email)
	{
		this.email = email;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(final String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(final String password)
	{
		this.password = password;
	}

	public List<Role> getRoles()
	{
		return roles;
	}

	public void setRoles(final List<Role> roles)
	{
		this.roles = roles;
	}

	public UserTypes getUserTypes()
	{
		return userTypes;
	}

	public void setUserTypes(final UserTypes userTypes)
	{
		this.userTypes = userTypes;
	}

	public float getVendorGrade()
	{
		return vendorGrade;
	}

	public void setVendorGrade(final float vendorGrade)
	{
		this.vendorGrade = vendorGrade;
	}

	public List<Comment> getComments()
	{
		return comments;
	}

	public void setComments(final List<Comment> comments)
	{
		this.comments = comments;
	}

	public int getNumOfRatings()
	{
		return numOfRatings;
	}

	public void setNumOfRatings(final int numOfRatings)
	{
		this.numOfRatings = numOfRatings;
	}
}
