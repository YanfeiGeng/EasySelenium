package com.easyselenium.model;

public class TestSuite {

	private boolean needOrNot = false;
	
	private String module;
	
	private String tsName;
	
	private String comments;
	
	private String explorerType;
	
	private String applicationURL;

	public TestSuite(boolean needOrNot, String module, String tsName,
			String comments, String explorerType, String applicationURL) {
		super();
		this.needOrNot = needOrNot;
		this.module = module;
		this.tsName = tsName;
		this.comments = comments;
		this.explorerType = explorerType;
		this.applicationURL = applicationURL;
	}

	public TestSuite() {
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

	public String getExplorerType() {
		return explorerType;
	}

	public void setExplorerType(String explorerType) {
		this.explorerType = explorerType;
	}

	public String getApplicationURL() {
		return applicationURL;
	}

	public void setApplicationURL(String applicationURL) {
		this.applicationURL = applicationURL;
	}
	
}
