package com.easyselenium.model;

import java.util.List;

public class TestSuite {

	private List<TestSuiteItem> items;

	public List<TestSuiteItem> getItems() {
		return items;
	}

	public void setItems(List<TestSuiteItem> items) {
		this.items = items;
	}

	public TestSuite(List<TestSuiteItem> items) {
		super();
		this.items = items;
	}
	
}
