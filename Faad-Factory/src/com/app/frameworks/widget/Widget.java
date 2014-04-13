package com.app.frameworks.widget;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.app.core.models.User;
@Entity
public class Widget {
	@Id
	private String id;
	private String name;
	private String version;
	private String developer;
	@Enumerated(EnumType.STRING)
	private WidgetType type;
	@ManyToMany(mappedBy="widgets")
	private ArrayList<User> users = new ArrayList<>();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public WidgetType getType() {
		return type;
	}
	public void setType(WidgetType type) {
		this.type = type;
	}
}
