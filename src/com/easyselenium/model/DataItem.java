package com.easyselenium.model;

import java.util.Map;

public class DataItem{
	
	private Map<String, String> keyValue;

	public Map<String, String> getKeyValue() {
		return keyValue;
	}

	public void setKeyValue(Map<String, String> keyValue) {
		this.keyValue = keyValue;
	}

	public DataItem(Map<String, String> keyValue) {
		super();
		this.keyValue = keyValue;
	}
	
}
