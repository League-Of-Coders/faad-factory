package com.app.core.models;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.app.core.AppEngine;
import com.app.frameworks.widget.Widget;


@Entity
public class User {
private String firstName;
private String lastName;
private String eMail;
private String accountType;
private String userName;
private String password;
private String widgetsAsString;
private boolean active;
@ManyToMany
private ArrayList<Widget> widgets = new ArrayList<>();
@Temporal(TemporalType.DATE)
private java.util.Date joinDate;
public java.util.Date getJoinDate() {
	return joinDate;
}

public void setJoinDate(java.util.Date joinDate) {
	this.joinDate = joinDate;
}

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
public void setWidgets(ArrayList<Widget> widgets)
{
	this.widgets=widgets;
}
public void setWidgetsAsString(String widgetsAsString)
{
	this.widgetsAsString = widgetsAsString;
}
public void setActive(boolean active)
{
	this.active= active;
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
public ArrayList<Widget> getWidgets()
{
	return widgets;
}
public String getWidgetsAsString()
{
	String widgetsAsString;
	if(this.widgetsAsString==null)
	{
		widgetsAsString = AppEngine.getCSVStringFromArrayList(widgets);
		return widgetsAsString;
	}
	else
	{
		return this.widgetsAsString;
	}
}
public boolean getActive()
{
	return active;
}


}
