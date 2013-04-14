package com.easyselenium.model;

public class Step {

	private String step;

	private String action;

	private String fieldName;

	private Parameter fieldParameter;

	private String identifyType;

	private String compareWith;
	
	private String IdentifyAttribute;
		

	public String getIdentifyAttribute() {
		return IdentifyAttribute;
	}

	public void setIdentifyAttribute(String identifyAttribute) {
		IdentifyAttribute = identifyAttribute;
	}

	public String getStep() {
		return step;
	}

	public Step() {
		super();
	}

	

	public Step(String steps, String action, String fieldName,
			Parameter fieldParameter, String identifyType, String compareWith,
			String identifyAttribute) {
		super();
		this.step = steps;
		this.action = action;
		this.fieldName = fieldName;
		this.fieldParameter = fieldParameter;
		this.identifyType = identifyType;
		this.compareWith = compareWith;
		IdentifyAttribute = identifyAttribute;
	}

	public void setStep(String steps) {
		this.step = steps;
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

	public Parameter getFieldParameter() {
		return fieldParameter;
	}

	public void setFieldParameter(Parameter fieldParameter) {
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
