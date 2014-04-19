package com.app.core.profiles.actions;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.app.core.models.User;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class ProfileLoader extends ActionSupport implements ApplicationAware,SessionAware,ServletRequestAware{
	private String requestedUserName;
	private User requestedUser;
	private Map<String,Object> session;
	private Map<String,Object> application;
	private HttpServletRequest request;
	
	@Override
	public String execute(){
		//TODO add hibernate later
		ArrayList<User> users = (ArrayList<User>) application.get("users");
		User currentUser = (User) session.get("user");
		if(requestedUserName.equals(currentUser.getUserName()))
		{
			session.put("requestedUser",session.get("user"));
			return "my-profile";
		}
		else
		{
		for(User user:users)
			if(user.getUserName().equals(requestedUserName))
			{
				requestedUser = user;
				session.put("requestedUser",user);
				return "other-profile";
			}
		}
			
		return ERROR;
			
		
		
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request = arg0;
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
		
	}
	public String getRequestedUserName() {
		return requestedUserName;
	}
	public void setRequestedUserName(String requestedUserName) {
		this.requestedUserName = requestedUserName;
	}
	
	

}
