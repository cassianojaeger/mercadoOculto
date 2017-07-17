package com.sap.imdb.model;

import javax.persistence.Embeddable;

import org.hibernate.validator.constraints.Length;


@Embeddable
public class Comment
{

	private String user;
	@Length(min = 1, max = 512)
	private String comment;
	private int userId;

	public String getUser()
	{
		return user;
	}

	public void setUser(final String user)
	{
		this.user = user;
	}

	public String getComment()
	{
		return comment;
	}

	public void setComment(final String comment)
	{
		this.comment = comment;
	}

	public int getUserId()
	{
		return userId;
	}

	public void setUserId(final int userId)
	{
		this.userId = userId;
	}

}
