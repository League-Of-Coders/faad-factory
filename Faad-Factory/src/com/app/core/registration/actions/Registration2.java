package com.app.core.registration.actions;

import java.util.ArrayList;
import java.util.Map;

import com.app.core.AppEngine;
import com.app.core.models.User;
import com.app.frameworks.user.UserAccountType;
import com.app.frameworks.widget.AppWidgetManager;
import com.app.frameworks.widget.Widget;

import org.apache.struts2.interceptor.SessionAware;






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
	/**
	 * Recreating the array list of widgets, so that Registration3.java can use as a new request is sent
	 */
	public Registration2()
	{
		accountTypes = AppEngine.getInstance().getUserAccountTypesAsStringArrayList();
	}
	/*
	 * Getter Declataions
	 */	
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
	@RequiredStringValidator(message = "Please select a preset account or select 'Others' to customize ")
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
		/*
		 * if other account type is not specified
		 */
		if(accountType.equals(AppEngine.getInstance().changeToPoperCase(UserAccountType.OTHERS.toString())) && otherAccountType.isEmpty())
		{
			addFieldError("accountType","Please specify an Account Type");
		}
		/*
		 * if no option is selected
		 */
		if(accountType.equals("-1") )
		{
			addFieldError("accountType","Please select an Account Type from the list");
		}
		
		
	}
	/**
	 * This method gets user instance from session, puts username,password and accountType info into it
	 * Prepares a list of free widget wrappers based on users choice of account type
	 * 
	 */
	/*
	 * TODO Modify for including multiple user account types as input 
	 */
	public String r2()
	{
		System.out.println("r2 running");
		User user = (User)session.get("user");
		for(UserAccountType type:UserAccountType.values())
			if(accountType.equals(AppEngine.getInstance().changeToPoperCase(type.toString())))
			{
				if(accountType.equals("Other"))
					type.specifyUserAccountType(otherAccountType);
				user.getAccountTypes().add(type);
			}
		user.setUserName(userName);
		user.setPassword(password);
		session.put("widgetWrappers",AppWidgetManager.getInstance().getFilteredFreeWidgets(user.getAccountTypes()));
		
		return SUCCESS;
	}
/**
 * This method gets the appropriate widgets for the selected Account Type/Types(for complex user)
 * @return
 */
	/*private ArrayList<Widget> getWidgets(User user) {
		ArrayList<Widget> availableWidgets = AppEngine.getInstance().getAppWidgetManager().getFilteredFreeWidgets(user.getAccountTypes());
		System.out.println("Widgets : " + availableWidgets);
		return availableWidgets;
		
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
		widgetList = AppEngine.getInstance().getStringArrayFromCSVString(widgets);	
		return widgetList;
	}
*/
	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
		
	}
	
}
