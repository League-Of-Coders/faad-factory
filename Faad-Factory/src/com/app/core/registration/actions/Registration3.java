package com.app.core.registration.actions;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

import com.app.core.models.User;
import com.app.frameworks.widget.Widget;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("unused")
public class Registration3 extends ActionSupport implements ServletRequestAware{

private static final long serialVersionUID = 1L;
private int count = 0;

private ArrayList<String> widgets = new ArrayList<String>();
private HttpServletRequest request;
private HttpSession session;
@Override
public void setServletRequest(HttpServletRequest arg0) {
	request = arg0;
}
public void initVariables()
{
	session = request.getSession();
	count = Integer.parseInt(request.getParameter("count"));
	/*
	Map<String, String[]> parameters = request.getParameterMap();
	System.out.println("KEYS :" + parameters.keySet());
	
	for(String parameter : parameters.keySet()) {
	    System.out.println(parameter + " : " + parameters.get(parameter));
	} 
	*/
	for(int i=0;i<count;i++)
	{
		String widgetKey = "widget" + i;
		System.out.println(widgetKey);
		String value = request.getParameter(widgetKey);
		System.out.println("value : "+ value);
		widgets.add(widgetKey);
		System.out.println("Recieved from registration3.jsp : " + widgets.get(i));
	}
	User user = (User)session.getAttribute("user");
	user.setWidgets(widgets);
}
public String r3()
{
	initVariables();
	return SUCCESS;
}

}
