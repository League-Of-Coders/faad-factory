package com.app.core.models;

import java.util.ArrayList;



public class User {
private String firstName,lastName,eMail,accountType,userName,password;
private ArrayList<String> widgets;

public void setFirstName(String firstName)
{
	this.firstName = firstName;
}
	
public void setLastName(String lastName)
{
	this.lastName=lastName;
}

public void setEMail(String eMail)
{
	this.eMail=eMail;
}
public void setUserName(String userName)
{
	this.userName=userName;
}

public void setPassword(String password)
{
	this.password = password;
}

public void setAccountType(String accountType)
{
	this.accountType = accountType;
}
public void setWidgets(ArrayList<String> widgets)
{
	this.widgets=widgets;
}
/*
 * Getters
 */
public String getFirstName()
{
	return firstName;
}

public String getLastName()
{
	return lastName;
}
public String getEMail()
{
	return eMail;
}
public String getUserName()
{
	return userName;
}
public String getPassword()
{
	return password;
}
public String getAccountType()
{
	return accountType;
}
public ArrayList<String> getWidgets()
{
	return widgets;
}
}
