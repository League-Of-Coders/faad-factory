package com.app.frameworks.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.AppEngine;
import com.app.frameworks.user.UserAccountType;
import com.opensymphony.xwork2.ActionSupport;
/*
 * This is a SingleTon class. use AppEngine.getWidgetManager()
 */
public class AppWidgetManager extends ActionSupport{
	private static AppWidgetManager appWidgetManager=null;
	private static final long serialVersionUID = 1L;
	private List<WidgetWrapper> registeredWidgets;
	/**
	 * Only called by AppEngine.	
	 */
	private AppWidgetManager()
	{
		/// avoids intantiation from outside
	}
	public static AppWidgetManager getInstance()
	{
		if(appWidgetManager==null)
			appWidgetManager = new AppWidgetManager();
		return appWidgetManager;
			
	}
	/**
	 * 
	 * @param widgetId
	 * @param widget
	 */
	public void registerWidget(WidgetWrapper wrapper)
	{
		if(!registeredWidgets.contains(wrapper))
			registeredWidgets.add(wrapper);
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
	
	public WidgetWrapper getWidgetById(String id)
	{
		for()
	}
	/**
	 * Handles complex and simple user types both
	 * @param userType
	 * @return
	 */
	public ArrayList<Widget> getFilteredFreeWidgets(ArrayList<UserAccountType> complexUserType)
	{
		ArrayList<Widget> filteredWidgets = new ArrayList<>();
		Widget widget;
		for(UserAccountType userType: complexUserType)
		{
		for(Map.Entry<String,Widget> registeredWidget: registeredWidgets.entrySet())
		{
			widget = registeredWidget.getValue();
			if(widget.getType()== WidgetType.FREE)
			{
				for(UserAccountType widgetUserType :widget.getAssociatedUserAccountTypes())
					if(widgetUserType==userType)
						if(!filteredWidgets.contains(widget))
							filteredWidgets.add(widget);
			}
		}
		}
		return filteredWidgets;
	}
	
}
