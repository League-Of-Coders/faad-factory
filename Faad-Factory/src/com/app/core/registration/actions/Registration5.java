package com.app.core.registration.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;



import org.hibernate.Session;

import com.app.core.AppEngine;
import com.app.core.models.User;
import com.opensymphony.xwork2.ActionSupport;

public class Registration5 extends ActionSupport implements ApplicationAware{
	private String id;
	private Map<String,Object> application;
	private Session session;
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
		/*
		 * create a record in database, redirect to profile
		 */
		try{
			user.setActive(true);
			System.out.println(user.getFirstName() + " is now " + user.getActive() + "\nwriting to database");
			session = AppEngine.getInstance().getHibernateSession();
			session.beginTransaction();
			session.persist(user);
			session.getTransaction().commit();
			application.remove(user);
			return SUCCESS;
		}catch(Exception ex)
		{
			System.out.println("error from r5 :" + ex.getMessage());
			return "error";
		}
		finally {
			session.close();
			
		}
	}
	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
		
	}
}
