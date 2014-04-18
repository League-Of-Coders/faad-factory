package com.app.frameworks.widget;

@SuppressWarnings("serial")
public class WidgetNotRegisteredException extends RuntimeException {

	public WidgetNotRegisteredException(String id)
		{
			super("No registered widget found with id : " + id);
		}
	
}
