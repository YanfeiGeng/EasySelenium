package com.easyselenium.selenium;

import java.util.HashMap;
import java.util.Map;

/**
 * Define the action types
 * @author yageng
 *
 */

public enum ActionType {
	SendKeys("SendKeys"),
	Click("Click"),
	GetAttribute("GetAttribute"),
	GetText("GetText"),
	Verify("Verify");
	
	private String name;
	
	private static Map<String, ActionType> types = new HashMap<String, ActionType>();
	
	static {
		types.put("SendKeys", SendKeys);
		types.put("Click", Click);
		types.put("GetAttribute", GetAttribute);
		types.put("GetText", GetText);
		types.put("Verify", Verify);
	}
	
	ActionType(String name){
		this.name = name;
	}
	
	public static ActionType getType(String name){
		return types.get(name);
	}
	
	public String getName(){
		return this.name;
	}
}
