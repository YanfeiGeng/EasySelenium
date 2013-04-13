package com.easyselenium.model;

public class TestScript {

	private String steps;
	
	private String action;
	
	private String fieldName;
	
	private String fieldParameter;
	
	private String identifyType;
	
	private String compareWith;

	public String getSteps() {
		return steps;
	}

	public TestScript() {
		super();
	}

	public TestScript(String steps, String action, String fieldName,
			String fieldParameter, String identifyType, String compareWith) {
		super();
		this.steps = steps;
		this.action = action;
		this.fieldName = fieldName;
		this.fieldParameter = fieldParameter;
		this.identifyType = identifyType;
		this.compareWith = compareWith;
	}

	public void setSteps(String steps) {
		this.steps = steps;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldParameter() {
		return fieldParameter;
	}

	public void setFieldParameter(String fieldParameter) {
		this.fieldParameter = fieldParameter;
	}

	public String getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(String identifyType) {
		this.identifyType = identifyType;
	}

	public String getCompareWith() {
		return compareWith;
	}

	public void setCompareWith(String compareWith) {
		this.compareWith = compareWith;
	}
	
}
