package com.app.frameworks.widget;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.app.core.AppEngine;
import com.app.core.models.User;
import com.app.core.widgets.Portfolio;
import com.app.frameworks.user.UserAccountType;
import com.opensymphony.xwork2.ActionSupport;
/*
 * This is a SingleTon class. use AppEngine.getWidgetManager() or AppWidgetManager.getInstance()
 */
public class AppWidgetManager extends ActionSupport{
	private static AppWidgetManager appWidgetManager=null;
	private static final long serialVersionUID = 1L;
	private List<WidgetWrapper> registeredWidgetWrappers = new ArrayList<>();
	
	
	private AppWidgetManager()
	{
		/// avoids instantiation from outside
	}
	public static AppWidgetManager getInstance()
	{
		if(appWidgetManager==null)
		{
			appWidgetManager = new AppWidgetManager();
			// load widgets from widget factory
			AppWidgetFactory.getInstance();
			
		}
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
	 * Handles complex and simple user types both
	 * This method gets widget wrappers of all free widgets for the specified user types. The widget wrapper can then 
	 * be user to display info like widget name, description,reviews etc. for eg -> this info can be displayed during registration
	 * @param userType
	 * @return
	 */
	public ArrayList<WidgetWrapper> getFilteredFreeWidgets(ArrayList<UserAccountType> userTypes)
	{
		ArrayList<WidgetWrapper> filteredWidgetWrappers = new ArrayList<>();
		for(UserAccountType userType: userTypes)
		{
		for(WidgetWrapper registeredWidgetWrapper: registeredWidgetWrappers)
		{
			
			if(registeredWidgetWrapper.getType()== WidgetType.FREE)
			{
				for(UserAccountType widgetUserType :registeredWidgetWrapper.getAssociatedUserAccountTypes())
					if(widgetUserType==userType)
						if(!filteredWidgetWrappers.contains(registeredWidgetWrapper))
							filteredWidgetWrappers.add(registeredWidgetWrapper);
			}
		}
		}
		return filteredWidgetWrappers;
	}
	/**
	 * This method adds given list of widgets to the users account
	 * @param user
	 * @param chosenWidgetWrappers
	 */
	public void addWidgetsToUser(User user,ArrayList<String> chosenWidgetWrappers)
	{
		System.out.println("Output From :  AppWidgetManager");
		for(String chosenWidgetWrapper: chosenWidgetWrappers)
		{
			System.out.println("chosenWidgetWrapper : " + chosenWidgetWrapper);
			for(WidgetWrapper registeredWidgetWrapper: AppWidgetManager.getInstance().getRegisteredWidgetWrappers())
			{
				System.out.println("registeredWidgetWrapper : " + registeredWidgetWrapper.getName());
				if(chosenWidgetWrapper.trim().equals(registeredWidgetWrapper.getWidgetId()))
				{
					try {
						user.getWidgets().add((Widget) registeredWidgetWrapper.getSampleObject().clone());
					} catch (CloneNotSupportedException e) {
						System.out.println("Failed to clone widget for user");
						e.printStackTrace();
					}
					//registeredWidgetWrapper.getWidgets().add(user.getWidgets().get(user.getWidgets().size()-1));
					System.out.println("Found widget to be added: " + chosenWidgetWrapper);
				}
				else
				{
					System.out.println(chosenWidgetWrapper + ": not equal :" + registeredWidgetWrapper.getWidgetId());
					System.out.println( Arrays.toString( chosenWidgetWrapper.toCharArray()) + ":not equal:" + Arrays.toString(registeredWidgetWrapper.getWidgetId().toCharArray()));
				}
			}
		}
		for(Widget widget: user.getWidgets())
			System.out.println("widgets added : " + widget.getText("widget.name"));
		
	}
	public AppWidgetFactory getAppWidgetFactory() {
		return AppWidgetFactory.getInstance();
	}
	public List<WidgetWrapper> getRegisteredWidgetWrappers() {
		return registeredWidgetWrappers;
	}
	public void setRegisteredWidgetWrappers(
			List<WidgetWrapper> registeredWidgetWrappers) {
		this.registeredWidgetWrappers = registeredWidgetWrappers;
	}
	
}
