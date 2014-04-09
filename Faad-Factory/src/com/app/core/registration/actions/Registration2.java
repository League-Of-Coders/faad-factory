package com.app.core.registration.actions;

import java.util.ArrayList;
import java.util.Map;

import com.app.core.Engine;
import com.app.core.models.User;

import org.apache.struts2.interceptor.SessionAware;

import com.app.core.actions.Registration;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.validator.annotations.*;


@Validation()
public class Registration2 extends ActionSupport implements SessionAware{
	/*
	 * Variable Declarations
	 */
	private static final long serialVersionUID = 1L;
	private String userName,accountType,password,cPassword,otherAccountType;
	private ArrayList<String> accountTypes =  null;
	private Map<String,Object> session = null;
	/*
	 * Getter Declataions
	 */
	public Registration2()
	{
		accountTypes = new ArrayList<String>();
		accountTypes.add("Actor");
		accountTypes.add("Director");
		accountTypes.add("Producer");
		accountTypes.add("Others");
	}
	
	public String getUserName()
	{
		return userName;
	}
	public String getPassword()
	{
		return password;
	}
	public String getCPassword()
	{
		return cPassword;
	}
	public String getAccountType()
	{
		return accountType;
	}
	public String getOtherAccountType()
	{
		return otherAccountType;
	}
	public ArrayList<String> getAccountTypes()
	{
		return accountTypes;
	}
	/*
	 * Seter Declarations
	 */
	
	@RequiredStringValidator(message = "UserName is required")
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	@RequiredStringValidator(message = "Password is required")
	public void setPassword(String password)
	{
		this.password = password;
	}
	@RequiredStringValidator(message = "This field cannot be empty")
	public void setCPassword(String cPassword)
	{
		this.cPassword = cPassword;
	}
	@RequiredStringValidator(message = "Please select a Preset Account or select 'Others' to customize ")
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}
	public void setOtherAccountType(String otherAccountType)
	{
		this.otherAccountType = otherAccountType;
	}
	public void setAccountTypes(ArrayList<String> accountTypes)
	{
		this.accountTypes = accountTypes;
	}
	/**
	 * check for password mismatch
	 * finalize the account type
	 */
	@Override
	public void validate()
	{
		if(!password.equals(cPassword))
		{
			System.out.println("passwor :" + password + "\n" + "other pword : " + cPassword);
			addFieldError("password",getText("registration.error.passwordmismatch"));
		}
		if(accountType.trim().equals("Other"))
		{
			setAccountType(getOtherAccountType());
		}
		
	}
	/*
	 * Methods for each step i.e r2 for step 2 
	 */
	public String r2()
	{
		System.out.println("r2 running");
		User user = (User)session.get("user");
		user.setAccountType(accountType);
		user.setUserName(userName);
		user.setPassword(password);
		session.put("widgets",getWidgets());
		
		return SUCCESS;
	}
/**
 * This method gets the appropriate widgets for the selected Account Type
 * @return
 */
	private String[] getWidgets() {
		String widgets = null;
		String[] widgetList=null;
		if(accountType.equals("Actor"))
			widgets = getText("registration.widgets.actor");
		else if(accountType.equals("Director"))
			widgets = getText("registration.widgets.director");
		else if(accountType.equals("Producer"))
			widgets = getText("registration.widgets.producer");
		else 
			widgets = getText("registration.widgets.other");
		widgetList = Engine.getStringArrayFromCSVString(widgets);	
		return widgetList;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
	
}
