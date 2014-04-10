package com.app.core.registration.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;


import com.app.core.models.User;
import com.opensymphony.xwork2.ActionSupport;

public class Registration5 extends ActionSupport implements ApplicationAware{
	private String id;
	private Map<String,Object> application;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id=id;
	}
	/*
	 * Get user from application scope based on id and set it active
	 */
	public String r5()
	{
		
		System.out.println("Retrieveing user from application scope with id : " + id);
		
		System.out.println("Retrieveing user from application scope with id : " + id);
		User user = (User)application.get(id);
		try{
		user.setActive(true);
		System.out.println(user.getFirstName() + " is now " + user.getActive());
		return SUCCESS;
		}catch(Exception ex)
		{
			System.out.println("error from r5 :" + ex.getMessage());
			return "error";
		}
	}
	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
		
	}
}
