package com.sap.imdb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "role")
public class Role
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String role;
	@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
	private List<User> users;

	public String getRole()
	{
		return role;
	}

	public void setRole(final String role)
	{
		this.role = role;
	}

	public Long getId()
	{
		return id;
	}

	public void setId(final Long id)
	{
		this.id = id;
	}

	@JsonIgnore
	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(final List<User> users)
	{
		this.users = users;
	}
}
