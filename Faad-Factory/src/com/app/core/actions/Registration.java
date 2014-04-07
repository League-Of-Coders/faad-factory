package com.app.core.actions;

import com.opensymphony.xwork2.ActionSupport;

public class Registration extends ActionSupport{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String firstName,lastName,eMail;
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	public String getEMail()
	{
		return eMail;
	}
	
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	public void setEMail(String eMail)
	{
		this.eMail=eMail;
	}
	public String r1()
	{
		
		System.out.print(firstName);//run validations
		return SUCCESS;
	}
}
