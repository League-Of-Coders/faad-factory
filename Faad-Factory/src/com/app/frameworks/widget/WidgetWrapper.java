package com.app.frameworks.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.core.AppEngine;
import com.app.frameworks.user.UserAccountType;
@Entity
@Table(name="Widget_Yard")
public class WidgetWrapper {
	@Id 
	private String widgetId;
	private Widget sampleWidget; // saved as blob
	private String name;
	private String version;
	private String developer;
	@Lob
	private String description;
	@Enumerated(EnumType.STRING)
	private WidgetType type;
	@OneToMany(cascade=CascadeType.ALL)
	private Widget widget;

	private List<UserAccountType> associatedUserAccountTypes = new ArrayList<>();
	public WidgetWrapper createWrapper(Widget widget)
	{
		this.widget = widget; //for table
		this.sampleWidget = widget; // for assigning to user
		this.setName(widget.getText("widget.name"));
		this.setWidgetId(widget.getText("widget.id"));
		this.setDeveloper(widget.getText("widget.developer"));
		this.setVersion(widget.getText("widget.version"));
		this.setDescription(widget.getText("widget.description"));
		String widgetType = widget.getText("widget.type");
		System.out.println(widget.getText("widget.name"));	
		Integer widgetPrice = Integer.parseInt(widget.getText("widget.price"));
		this.setType(WidgetType.getTypeFromString(widgetType,widgetPrice));
		String[] assType = AppEngine.getInstance().getStringArrayFromCSVString(widget.getText("widget.associated_user_types"));
		for(String type : assType)
		{
			UserAccountType temp = UserAccountType.getUserAcountTypeFromString(type);
			this.getAssociatedUserAccountTypes().add(temp);
		}
		return this;
	}
	/*
	 * Getters Setters
	 */
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWidgetId() {
		return widgetId;
	}
	public void setWidgetId(String widgetId) {
		this.widgetId = widgetId;
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
	public WidgetType getType() {
		return type;
	}
	public void setType(WidgetType type) {
		this.type = type;
	}
	public List<UserAccountType> getAssociatedUserAccountTypes() {
		return associatedUserAccountTypes;
	}
	public void setAssociatedUserAccountTypes(
			List<UserAccountType> associatedUserAccountTypes) {
		this.associatedUserAccountTypes = associatedUserAccountTypes;
	}
	public Widget getWidget() {
		return widget;
	}
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String widgetDescription) {
		this.description = widgetDescription;
	}

	public Widget getSampleObject() {
		return sampleWidget;
	}

	public void setSampleObject(Widget sampleObject) {
		this.sampleWidget = sampleObject;
	}
}
