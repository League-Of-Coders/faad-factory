package com.app.core.login.actions;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.app.core.models.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;




public class Login1 extends ActionSupport implements SessionAware{
	/*
	 * Variable Declarations
	 */
	private static final long serialVersionUID = 1L;
	private String userName,password;
	
	private Map<String,Object> session = null;
	/**
	 * 
	 * @return
	 */
	
	/*
	 * Getter Declataions
	 */
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	
	/*
	 * Seter Declarations
	 */
	
	@RequiredStringValidator(message = "UserName is required")
	public void setUserName(String userName)
	{
		this.userName = userName;
	}
	
	
	@RequiredStringValidator(message = "Password is required")	
	public void setPassword(String password)
	{
		this.password=password;
	}
	
	
	public String l1()
	{
		System.out.println("l1 running");
		User user = new User();
		user.setUserName(userName);
		user.setPassword(password);
		
		session.put("user",user);
		//run validations
		return SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
	
}



