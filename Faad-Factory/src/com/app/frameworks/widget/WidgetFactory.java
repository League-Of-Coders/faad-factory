package com.app.frameworks.widget;

import com.app.core.AppEngine;
import com.app.core.widgets.Portfolio;

public class WidgetFactory {
/*
 * instantiate all widget classes here to call their static blocks and register them to the app. instantiate in constructor of appWidgetManager
 */

	public WidgetFactory()
	{
		manufacturePortfolio();
	}
	/*
	 * Portfolio
	 */
private void manufacturePortfolio() {
	Widget portfolio = new Portfolio();
	WidgetWrapper  portfolioWrapper = new WidgetWrapper().createWrapper(portfolio);
	AppEngine.getInstance().getAppWidgetManager().registerWrapper(portfolioWrapper);
	
}
}
