package com.app.core.registration.actions;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.app.core.models.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;
import com.app.core.models.User;


@Validation()
public class Registration1 extends ActionSupport implements SessionAware{
	/*
	 * Variable Declarations
	 */
	private static final long serialVersionUID = 1L;
	private String firstName,lastName,eMail;
	private ArrayList<String> accountTypes =  null;
	private Map<String,Object> session = null;
	/**
	 * 
	 * @return
	 */
	public Registration1()
	{
		accountTypes = new ArrayList<String>();
		accountTypes.add("Actor");
		accountTypes.add("Director");
		accountTypes.add("Producer");
		accountTypes.add("Others");
	}
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
	public ArrayList<String> getAccountTypes()
	{
		return accountTypes;
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
	public void setAccountTypes(ArrayList<String> accountTypes)
	{
		this.accountTypes = accountTypes;
	}
	/*
	 * Methods for each step i.e r1 for step 1 
	 */
	public String r1()
	{
		System.out.println("r1 running");
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEMail(eMail);
		session.put("user",user);
		//run validations
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
	
}
