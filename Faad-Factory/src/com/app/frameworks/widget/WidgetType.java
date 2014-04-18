package com.app.frameworks.widget;

public enum WidgetType {
	FREE,PRICED,OTHERS;
	
	private String actualWidgetType; // maintains exact name if the type is others
	private Integer price =0;
	private WidgetType(){
		
			this.actualWidgetType = this.name().toLowerCase();
	}
	/*
	 * when using widgetType OTHERS , use this method to change type
	 */
	public void specifyWidgetType(String widgetType) {
		this.actualWidgetType = widgetType;
	}
	@Override
	public String toString() {
		return actualWidgetType;
	}
	/*
	 * use to 
	 */
	public static WidgetType getTypeFromString(String type,Integer price)
	{
		WidgetType widgetType = WidgetType.FREE;
		widgetType.setPrice(0);
		switch(type)
		{
		case "FREE": widgetType = WidgetType.FREE; break;
		case "PAID": widgetType = WidgetType.PRICED; widgetType.setPrice(price); break;
		case "OTHERS": widgetType = WidgetType.OTHERS; break;
		}
		return widgetType;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer cost) {
		this.price = cost;
	}
}
