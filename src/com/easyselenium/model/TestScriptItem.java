package com.easyselenium.model;

public class TestScriptItem {
	
private boolean needOrNot;
	
	private String BPCName;
	
	private String comments;

	public boolean isNeedOrNot() {
		return needOrNot;
	}

	public void setNeedOrNot(boolean needOrNot) {
		this.needOrNot = needOrNot;
	}

	public String getBPCName() {
		return BPCName;
	}

	public void setBPCName(String bPCName) {
		BPCName = bPCName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public TestScriptItem(boolean needOrNot, String bPCName, String comments) {
		super();
		this.needOrNot = needOrNot;
		BPCName = bPCName;
		this.comments = comments;
	}

	public TestScriptItem() {
		super();
	}

}
