package com.app.frameworks.widget;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.core.models.User;
import com.app.frameworks.user.UserAccountType;
import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")
@Entity
@Table(name="Widget")
@Inheritance(strategy=InheritanceType.JOINED)
public class Widget extends ActionSupport{
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="userId")
	private User user;
	@ManyToOne
	@JoinColumn(name="wrapperId")
	private WidgetWrapper wrapper;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public WidgetWrapper getWrapper() {
		return wrapper;
	}
	public void setWrapper(WidgetWrapper wrapper) {
		this.wrapper = wrapper;
	}

}
