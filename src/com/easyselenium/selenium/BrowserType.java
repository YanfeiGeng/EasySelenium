package com.easyselenium.selenium;

import java.util.HashMap;
import java.util.Map;

/**
 * Define the action types
 * @author yageng
 *
 */

public enum BrowserType {
	IE("IE"),
	Firefox("Firefox"),
	Chrome("Chrome"),
	Safari("Safari"),
	Opera("Opera");
	
	private String name;
	
	private static Map<String, BrowserType> types = new HashMap<String, BrowserType>();
	
	static {
		types.put("IE", IE);
		types.put("Firefox", Firefox);
		types.put("Chrome", Chrome);
		types.put("Safari", Safari);
		types.put("Opera", Opera);
	}
	
	BrowserType(String name){
		this.name = name;
	}
	
	public static BrowserType getType(String name){
		return types.get(name);
	}
	
	public String getName(){
		return this.name;
	}
}
