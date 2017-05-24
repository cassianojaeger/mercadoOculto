package com.sap.imdb.model;

import javax.persistence.Entity;


@Entity
public class MagicServices extends Product
{
	private float waitingTime;
	private String requirementsList;

	public float getWaitingTime()
	{
		return waitingTime;
	}

	public void setWaitingTime(final float waitingTime)
	{
		this.waitingTime = waitingTime;
	}

	public String getRequirementsList()
	{
		return requirementsList;
	}

	public void setRequirementsList(final String requirementsList)
	{
		this.requirementsList = requirementsList;
	}
}
