package com.app.core.registration.actions;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.joda.time.DateTime;

import com.app.core.AppEngine;
import com.app.core.models.User;
import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import com.opensymphony.xwork2.ActionSupport;

public class Registration4 extends ActionSupport implements ServletRequestAware,SessionAware,ApplicationAware{

private static final long serialVersionUID = 1L;
private HttpServletRequest request = null ;
private Map<String,Object> session = null;
private Map<String,Object> application = null;
private boolean termsAgreed;
private String id; // token/confirmation link id
private User user;
/*
 * getters
 */
public boolean getTermsAgreed()
{
	return termsAgreed;
}
/*
 * setters
 */

public void setTermsAgreed(boolean termsAgreed)
{
	this.termsAgreed= termsAgreed;
}
@Override
public void setServletRequest(HttpServletRequest arg0) {
	this.request= arg0;
}
@Override
public void setApplication(Map<String, Object> arg0) {
	application = arg0;
}

@Override
public void setSession(Map<String, Object> arg0) {
	session = arg0;
}
/*
 * validators for captcha
 */
@Override
public void validate()
{
	String userCaptchaResponse = request.getParameter("jcaptcha");
	boolean captchaPassed = SimpleImageCaptchaServlet.validateResponse(request, userCaptchaResponse);
	if(captchaPassed){
	System.out.println("passed");
	}else{
	addFieldError("jcaptcha",getText("registration.error.captcha"));
	}
	if(!termsAgreed)
	{
		addFieldError("termsAgreed",getText("registration.error.TnC"));
	}
}
/*
 * logic to send email,assign token and put user object into application scope
 */
public String r4()
{
	user = (User)session.get("user");
	user.setActive(false);
	DateTime token = new DateTime();
	putUserInApplicationScope(token);
	if(sendMailConfirmationLink(token))
		return SUCCESS;
	else
		return "error";
}
private void putUserInApplicationScope(DateTime dt) {
	/*
	 * The + sign from timezone is to be removed and replaced with a space. Because confirmation link will not include + in its parameter
	 */
	id = dt.toString().replace('+', '-');
	application.put(id,user);
	System.out.println("User is now in application scope : " + id);
	
}
private boolean sendMailConfirmationLink(DateTime dt) {
	String from = getText("registration.mail.from");
	String to = user.getEMail();
	String subject = getText("registration.mail.subject");
	String confirmationLink = getText("app.contextRoot") + "/core/registration/register_5?id="+ id;
	String message = "Hi " + user.getFirstName() +
					"\nTo activate your Film And Animation Developer Factory account now" +
					"\nclick here: " + confirmationLink;
	System.out.println("Registration4.java : Sending Mail Request");
	boolean mailSent = new AppEngine().sendMail(from,to,subject,message);
	if(mailSent)
		return true;
	else
		return false;
}



}
