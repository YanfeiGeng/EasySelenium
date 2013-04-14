package com.easyselenium.selenium;

import java.util.HashMap;
import java.util.Map;

public enum IdentifyType {

	ById("ById"),
	ByXpath("ByXpath"),
	ByName("ByName"),
	ByTagName("ByTagName");
	
	private String name;
	
	private static Map<String, IdentifyType> types = new HashMap<String, IdentifyType>();
	
	static{
		types.put("ById", ById);
		types.put("ByXpath", ByXpath);
		types.put("ByName", ByName);
		types.put("ByTagName", ByTagName);
	}
	
	IdentifyType(String name){
		this.name = name;
	}
	
	public static IdentifyType getType(String name){
		return types.get(name);
	}
	
	public String getName(){
		return this.name;
	}
	
}
