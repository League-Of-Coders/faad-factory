package com.app.core.widgets;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import java.util.Map;
import java.util.HashMap;

import com.app.core.models.User;
import com.app.frameworks.widget.Widget;
import com.app.frameworks.widget.WidgetWrapper;
import com.opensymphony.xwork2.Action;

@SuppressWarnings("serial")
@Entity
@Table(name="Portfolio")
public class Portfolio extends Widget implements ServletRequestAware,SessionAware,Action{
	/*
	 * create a widget packet and register the packet with the app widget manager
	 */
	static{
		//new WidgetWrapper().createPacket(new Portfolio());
		//WidgetWrapper wrapper = new WidgetWrapper();
		
	}
	private String aboutMe = "No info specified" ;
	@Transient
	HttpServletRequest request;
	@Transient
	Map<String,Object> session = new HashMap<>();
	@Transient
	Portfolio userPortfolio;
	public Portfolio()
	{
		/*
		 * Think if code should be added to check/register it to appWidgetManager every time an instance is created. Or use a static block Or leave the task of registration to AppWidgetFactory
		 */
	}
	/**
	 * This method will get the portfolio widget of the requested user.
	 * @param requestedUser
	 * @return
	 */
	public static Portfolio getUserPortfolio(User requestedUser)
	{
		Portfolio portfolio = null;
		for(Widget widget:requestedUser.getWidgets())
		{
			System.out.println("Widget Name : " + widget.getWrapper().getName());
			if(widget instanceof Portfolio)
			{
				portfolio= (Portfolio)widget;
			System.out.println("Portfolio Found");
			}
			
		}
		return portfolio;
	}
	
	@Override
	public String execute() {
		
		String updateValue;
		userPortfolio = getUserPortfolio((User)session.get("requestedUser"));
		String elementId = null;
		elementId = request.getParameter("element_id");
		System.out.println("FROM PORTFOLIO.java : \nElement id : " + elementId );
		if(elementId!=null)
		{
			updateValue=request.getParameter("update_value");
			System.out.println("update value : " +updateValue);
			switch(elementId.trim())
			{
			case "aboutMe": userPortfolio.setAboutMe(updateValue); break;
				
				
			}
			// required to reload the in-place editing
			request.setAttribute("refresh", "true");
			return "update";
			
		}else {
			request.setAttribute("refresh", "false");
			return "no-update";
		}
		
	}
	
	public String getAboutMe() {
		return aboutMe;
	}

	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		request= arg0;
		
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		session = arg0;
	}
	
}
