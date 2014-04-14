package com.app.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.app.core.AppEngine;
import com.app.frameworks.user.UserAccountType;
import com.app.frameworks.widget.Widget;


@Entity
@Table(name="Users")
public class User {
	@Id @GeneratedValue
	private int id;
	private String firstName;
	private String lastName;
	private String eMail;
	private ArrayList<UserAccountType> accountTypes;
	private String userName;
	private String password;
	private boolean active;
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.EAGER,mappedBy="user")
	private List<Widget> widgets = new ArrayList<>();
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


public void setWidgets(List<Widget> widgets)
{
	this.widgets=widgets;
}
public void setActive(boolean active)
{
	this.active= active;
}


public void setAccountTypes(ArrayList<UserAccountType> accountTypes) {
	this.accountTypes = accountTypes;
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

public List<Widget> getWidgets()
{
	return widgets;
}
public boolean getActive()
{
	return active;
}
public ArrayList<UserAccountType> getAccountTypes() {
	return accountTypes;
}




}
