package com.app.frameworks.widget;

import java.util.HashMap;
import java.util.Map;

import com.app.core.AppEngine;
import com.opensymphony.xwork2.ActionSupport;

public class WidgetManager extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private Map<String,Widget> registeredWidgets;
	/**
	 * Only called by AppEngine.	
	 */
	public WidgetManager()
	{
		String[] widgets = AppEngine.getStringArrayFromCSVString(getText("widgets.all"));
		for(String widgetId : widgets)
		{
			Widget widget = new Widget();
		}
		
	}
	/**
	 * 
	 * @param widgetId
	 * @param widget
	 */
	public void registerWidget(String widgetId,Widget widget)
	{
		registeredWidgets.put(widgetId, widget);
	}
	/**
	 * 
	 * @return
	 */
	
	public Map<String, Widget> getRegisteredWidgets() {
		return registeredWidgets;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	public Widget getWidgetById(String id)
	{
		if(registeredWidgets.containsKey(id))
			return registeredWidgets.get(id);
		else
			throw new WidgetNotRegisteredException(id);
	}
}
