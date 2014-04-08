package com.app.core.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;


@Validation()
public class Registration extends ActionSupport{
	/*
	 * Variable Declarations
	 */
	private static final long serialVersionUID = 1L;
	private String firstName,lastName,eMail,userName,password,accountType;
	/*
	 * Getter Declataions
	 */
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
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	public String getAccountType()
	{
		return accountType;
	}
	/*
	 * Seter Declarations
	 */
	
	@RequiredStringValidator(message = "Fist Name is required")
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}
	
	
	@RequiredStringValidator(message = "Last Name is required")	
	public void setLastName(String lastName)
	{
		this.lastName=lastName;
	}
	
	@RequiredStringValidator(message = "Email is required")
	@EmailValidator(message="Please enter a Valid Email-id", shortCircuit=true)
	public void setEMail(String eMail)
	{
		this.eMail=eMail;
	}
	//@RequiredStringValidator(message = "UserName is required")
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	/*
	 * Methods for each step i.e r1 for step 1 and so on
	 */
	public String r1()
	{
		System.out.println("r1 running");
		//run validations
		return SUCCESS;
	}
	
}
