package com.app.frameworks.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.AppEngine;
import com.app.frameworks.user.UserAccountType;
import com.opensymphony.xwork2.ActionSupport;
/*
 * This is a SingleTon class. use AppEngine.getWidgetManager() or AppWidgetManager.getInstance()
 */
public class AppWidgetManager extends ActionSupport{
	private static AppWidgetManager appWidgetManager=null;
	private static final long serialVersionUID = 1L;
	private List<WidgetWrapper> registeredWidgetWrappers;
	
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
	public void registerWidgetWrapper(WidgetWrapper wrapper)
	{
		if(!registeredWidgetWrappers.contains(wrapper))
			registeredWidgetWrappers.add(wrapper);
	}
		
	/**
	 * 
	 * @param id
	 * @return
	 */
	
	public WidgetWrapper getWidgetWrapperById(String id)
	{
		
	}
	/**
	 * Handles complex and simple user types both
	 * This method widget wrappers of all free widgets for the specified user types. The widget wrapper can then 
	 * be user to display info like widget name, description,reviews etc. for eg -> this info can be displayed during registration
	 * @param userType
	 * @return
	 */
	public ArrayList<WidgetWrapper> getFilteredFreeWidgets(ArrayList<UserAccountType> userTypes)
	{
		ArrayList<WidgetWrapper> filteredWidgetWrappers = new ArrayList<>();
		Widget widget;
		for(UserAccountType userType: userTypes)
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
