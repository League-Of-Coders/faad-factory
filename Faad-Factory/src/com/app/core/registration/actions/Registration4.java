package com.app.core.registration.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;

import com.octo.captcha.module.servlet.image.SimpleImageCaptchaServlet;
import com.opensymphony.xwork2.ActionSupport;

public class Registration4 extends ActionSupport implements ServletRequestAware{

private static final long serialVersionUID = 1L;
private HttpServletRequest request = null ;
private boolean termsAgreed;
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
 * logic
 */
public String r4()
{
	return SUCCESS;
}

}
