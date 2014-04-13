package com.app.core.models;

import java.util.ArrayList;






import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

import com.app.core.AppEngine;
import com.app.core.models.UserDao;





@Entity
@Table(name= "")
public class User 
{
	@Id
	
	private int id;
private String firstName,lastName,eMail,accountType,userName,password,widgetsAsString;
private boolean active;
private ArrayList<String> widgets;
public String registrationTimeStampToken;
public int getId() 
{
	return id;
}
public void setId(int id)
{
	this.id = id;
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
public void setWidgets(ArrayList<String> widgets)
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
public ArrayList<String> getWidgets()
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
public String execute(){
UserDao.saveUser(this);
	return "success";
}

}
