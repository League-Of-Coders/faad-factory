package com.app.frameworks.widget;

import com.app.core.AppEngine;
import com.app.core.widgets.Gallery;
import com.app.core.widgets.Portfolio;
/**
 * WidgetFactory is SingleTon. It is instantiated when the AppWidgetManager is instantiated. see its constructor
 * @author MAYANK
 *
 */
public class AppWidgetFactory {
	private static AppWidgetFactory appWidgetFactory = null;
	/*
	 * manufacture all widget classes here to register them with appWidgetManager
	 */
	
	private AppWidgetFactory()
	{
		manufactureWidget(new Portfolio());
		manufactureWidget(new Gallery());
	}
	/*
	 * This method extracts info from the widget's properties file, creates a wrapper and then sends it to AppWidgetManager for registration
	 * 
	 */
	private void manufactureWidget(Widget widget) {
	WidgetWrapper  widgetWrapper = new WidgetWrapper().createWrapper(widget);
	AppEngine.getInstance().getAppWidgetManager().registerWidgetWrapper(widgetWrapper);
	System.out.println("Widget Factory : widget manufactured : " + widget.getText("widget.name"));
	
}
	/**
	 * Returns the singleTon instance of AppWidgetFactory
	 */
	public static AppWidgetFactory getInstance()
	{
		if(appWidgetFactory==null)
			appWidgetFactory = new AppWidgetFactory();
		return appWidgetFactory;
	}
}
