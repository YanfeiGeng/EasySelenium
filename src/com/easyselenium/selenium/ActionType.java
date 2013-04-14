package com.easyselenium.selenium;

/**
 * Define the action types
 * @author yageng
 *
 */

public enum ActionType {
	SendKeys("SendKeys"),
	Click("Click"),
	GetValue("GetValue"),
	Verify("Verify");
	
	private String name;
	
	ActionType(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
}
