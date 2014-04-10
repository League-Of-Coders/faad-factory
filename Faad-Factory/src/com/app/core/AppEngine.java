package com.app.core;

import java.awt.HeadlessException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import com.opensymphony.xwork2.ActionSupport;

public class AppEngine extends ActionSupport{
	
	/**
	 * takes a Comma Separated String as input and returns individual values as String Array
	 * @param input
	 * @return
	 */
	public static String[] getStringArrayFromCSVString(String input)
	{
		String[] list = input.split(",");
		return list;
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
        		return new PasswordAuthentication("imptodefeat@gmail.com","3dsmaxmaya");
		
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
}
