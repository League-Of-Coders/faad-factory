package com.app.core.widgets;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.frameworks.widget.Widget;
import com.app.frameworks.widget.WidgetWrapper;

@SuppressWarnings("serial")
@Entity
@Table(name="Portfolio")
public class Portfolio extends Widget{
	/*
	 * create a widget packet and register the packet with the app widget manager
	 */
	static{
		//new WidgetWrapper().createPacket(new Portfolio());
		//WidgetWrapper wrapper = new WidgetWrapper();
		
	}
	private String aboutMe ;
	
	public Portfolio()
	{
		/*
		 * Think if code should be added to check/register it to appWidgetManager every time an instance is created. Or use a static block Or leave the task of registration to AppWidgetFactory
		 */
	}
	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	
}
