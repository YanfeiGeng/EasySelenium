package com.easyselenium.selenium;

public enum IdentifyType {

	ById("ById"),
	ByXpath("ByXpath"),
	ByName("ByName"),
	ByText("ByText");
	
	private String name;
	
	IdentifyType(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
}
