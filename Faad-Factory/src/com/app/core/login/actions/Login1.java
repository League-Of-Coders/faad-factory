package com.app.core.login.actions;


import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.SessionAware;

import com.app.core.models.User;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;




public class Login1 extends ActionSupport implements SessionAware,ApplicationAware{
	/*
	 * Variable Declarations
	 */
	private static final long serialVersionUID = 1L;
	private String userName,password;
	
	private Map<String,Object> session = null;
	private Map<String,Object> application = null;
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
		//TODO add hibernate code
		ArrayList<User> users = (ArrayList<User>)application.get("users");
		for(User user:users)
			if(user.getUserName().equals(userName))
			{
				session.put("user", user);
				return SUCCESS;
			}
		return ERROR;
}
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}

	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
		
	}
	
}



