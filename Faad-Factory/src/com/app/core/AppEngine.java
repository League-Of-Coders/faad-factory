package com.app.core;


import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.*;

import com.app.frameworks.user.UserAccountType;
import com.app.frameworks.widget.AppWidgetManager;
import com.opensymphony.xwork2.ActionSupport;
/**
 * App Engine is SingleTon
 * @author 
 *
 */
public class AppEngine extends ActionSupport{
	
	private static AppEngine appEngine= null;
	private static final long serialVersionUID = 1L;
	
	private org.hibernate.Session hibernateSession;
	private org.hibernate.SessionFactory sessionFactory= new org.hibernate.cfg.Configuration().configure().buildSessionFactory();
	private AppWidgetManager appWidgetManager;// = AppWidgetManager.getInstance();
	
	private AppEngine(){
		// avoids instantiation
		appWidgetManager = AppWidgetManager.getInstance();
	}
	/**
	 * return the singleton instance of AppEngine
	 * @return
	 */
	public static AppEngine getInstance()
	{
		if(appEngine==null)
			appEngine = new AppEngine();
		return appEngine;
	}
	/**
	 * return the singleton instance of WidgetManager
	 * @return
	 */
	public AppWidgetManager getAppWidgetManager()
	{
		return appWidgetManager;
	}
	/**
	 * Create a new hibernate session. 
	 * @return
	 */
	public org.hibernate.Session getHibernateSession()
	{
		hibernateSession = sessionFactory.openSession();
		return hibernateSession;
	}
	
	/**
	 * takes a Comma Separated String as input and returns individual values as String Array
	 * @param input
	 * @return
	 */
	public String[] getStringArrayFromCSVString(String input)
	{
		String[] list = input.split(",");
		return list;
	}
	/**
	 * convert widget list to Comma Separated Value String.  
	 */
	public String getCSVStringFromArrayList(ArrayList<String> widgets)
	{
		String widgetsAsString = new String();
		for(String widget:widgets)
		{
			widgetsAsString+=widget+",";
		}
		/*
		 * remove last ,
		 */
		if (widgetsAsString.length() > 0 && widgetsAsString.charAt(widgetsAsString.length()-1)==',') {
			widgetsAsString = widgetsAsString.substring(0, widgetsAsString.length()-1);
		 }
		return widgetsAsString;
	}
	public ArrayList<String> getArrayListFromStringArray(String[] stringArray )
	{
		ArrayList<String> arrayList = new ArrayList<>();
		for(String string : stringArray)
			arrayList.add(string);
		return arrayList;
	}
	
	/**
	 * Email main method
	 */
	public boolean sendMail(String from,String to,String subject,String messageAttribute)
    {

        String host = "localhost";
        /*
        Properties props = new Properties();
        props.put("mail.smtp.host", getText("mail.smtp.host"));
        props.put("mail.smtp.socketFactory.port",getText("mail.smtp.socketFactory.port"));
        props.put("mail.smtp.socketFactory.class",getText("mail.smtp.socketFactory.class"));
        props.put("mail.smtp.auth", getText("mail.smtp.auth"));
        props.put("mail.smtp.port", getText("mail.smtp.port")); 
        */
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        
        
        Session mySession = Session.getInstance(props, new Authenticator(){
	
        	protected PasswordAuthentication getPasswordAuthentication()
        	{
        		return new PasswordAuthentication("faadfactory@gmail.com","amazingspiderman");
		
        	}
        });

        try
        {
        	MimeMessage message = new MimeMessage(mySession);
        	message.setFrom(new InternetAddress(from));
        	message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
        	message.setSubject(subject);
	
        	message.setText(messageAttribute);
        	System.out.println("App Engine: Sending Mail to " + to);
        	Transport.send(message);
        	System.out.println("AppEngine: Message Sent");
        	return true;
	
        }catch( HeadlessException | MessagingException e)
        {
        	e.printStackTrace();
        	return false;
        }
    }
	/**
	 * Convert String to ProperCase
	 */
	public String changeToPoperCase(String s)
	{
		return s.substring(0, 1).toUpperCase() + s.substring(1).toLowerCase();
	}
	/**
	 * returns an array list containing all UserAccountTypes as string and in proper case. Used in registration form
	 */
	public ArrayList<String> getUserAccountTypesAsStringArrayList()
	{
		ArrayList<String>accountTypes = new ArrayList<String>();
		for(UserAccountType type : UserAccountType.values())
			accountTypes.add(changeToPoperCase(type.toString()));
		return accountTypes;
	}
}
