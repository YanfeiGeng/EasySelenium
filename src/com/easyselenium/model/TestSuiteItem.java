package com.easyselenium.model;

import com.easyselenium.selenium.BrowserType;

public class TestSuiteItem {

private boolean needOrNot = false;
	
	private String module;
	
	private String tsName;
	
	private String comments;
	
	private BrowserType explorerType;
	
	private String applicationURL;

	public TestSuiteItem(boolean needOrNot, String module, String tsName,
			String comments, BrowserType explorerType, String applicationURL) {
		super();
		this.needOrNot = needOrNot;
		this.module = module;
		this.tsName = tsName;
		this.comments = comments;
		this.explorerType = explorerType;
		this.applicationURL = applicationURL;
	}

	public TestSuiteItem() {
		super();
	}

	public boolean isNeedOrNot() {
		return needOrNot;
	}

	public void setNeedOrNot(boolean needOrNot) {
		this.needOrNot = needOrNot;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getTsName() {
		return tsName;
	}

	public void setTsName(String tsName) {
		this.tsName = tsName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}


	public String getApplicationURL() {
		return applicationURL;
	}

	public void setApplicationURL(String applicationURL) {
		this.applicationURL = applicationURL;
	}

	public BrowserType getExplorerType() {
		return explorerType;
	}

	public void setExplorerType(BrowserType explorerType) {
		this.explorerType = explorerType;
	}
	
}
