package com.app.core.registration.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;



import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.app.core.AppEngine;
import com.app.core.models.User;
import com.opensymphony.xwork2.ActionSupport;

public class Registration5 extends ActionSupport implements ApplicationAware,SessionAware{
	private String id;
	private Map<String,Object> application;
	private Map<String,Object> faadSession;
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
	 * Get user from application scope based on id and set it active, make database record and set session, redirect to profile
	 */
	/**
	 * @return
	 */
	public String r5()
	{
		
		System.out.println("Retrieveing user from application scope with id : " + id);
		
		System.out.println("Retrieveing user from application scope with id : " + id);
		User user = (User)application.get(id);
		/*
		 * create a record in database, redirect to profile
		 */
		Transaction tx = null ;
			user.setActive(true);
			System.out.println(user.getFirstName() + " is now " + user.getActive() + "\nwriting to database");
			session = AppEngine.getInstance().getHibernateSession();
			System.out.println(user.getUserName() + " has widgets " + user.getWidgets());
			
			try {
				tx = session.beginTransaction();
				// TODO not working 
				session.persist(user);
				//session.flush();
				System.out.println("User persisting complete");
				tx.commit();
			
			}catch(Exception ex)
			{
				tx.rollback();
				throw ex;
			}finally {
				session.close();
				faadSession.put("user",user);
				application.remove(user);
						
			}
			return SUCCESS;
			/*user=null;
			session = AppEngine.getInstance().getHibernateSession();
			session.beginTransaction();
			System.out.println("getting user from database");
			user=(User)session.get(User.class, 1);
			System.out.println(user.getFirstName());
			session.getTransaction().commit();
			session.close();*/
			
			/*System.out.println("Hibernate Session closed");
			//application.remove(user);
			//System.out.println("User removed from Application Scope");
			return SUCCESS; */
			
		
	}
	@Override
	public void setApplication(Map<String, Object> arg0) {
		application = arg0;
		
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		this.faadSession = arg0;
		
	}
}
