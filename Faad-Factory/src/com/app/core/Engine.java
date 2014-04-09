package com.app.core;

import java.util.ArrayList;

public class Engine {
	
	/**
	 * takes a Comma Separated String as input and returns individual values as String Array
	 * @param input
	 * @return
	 */
	public static String[] getStringArrayFromCSVString(String input)
	{
		String[] list = input.split(",");
		return list;
	}
}
