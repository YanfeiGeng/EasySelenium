package com.easyselenium.model;

import com.easyselenium.selenium.ActionType;
import com.easyselenium.selenium.IdentifyType;

public class Step {

	private boolean needOrNot;
	
	private String step;

	private ActionType action;

	private String fieldName;

	private Parameter fieldParameter;

	private IdentifyType identifyType;

	private Parameter compareWith;
	
	private String IdentifyAttribute;
	
	/**
	 * Below fields used for report.
	 */
	private boolean status;
	
	private String reason;

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

	public Step(boolean needOrNot, String steps, ActionType action, String fieldName,
			Parameter fieldParameter, IdentifyType identifyType, Parameter compareWith,
			String identifyAttribute) {
		super();
		this.needOrNot = needOrNot;
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


	public Parameter getCompareWith() {
		return compareWith;
	}

	public void setCompareWith(Parameter compareWith) {
		this.compareWith = compareWith;
	}

	public boolean isNeedOrNot() {
		return needOrNot;
	}

	public void setNeedOrNot(boolean needOrNot) {
		this.needOrNot = needOrNot;
	}

	public ActionType getAction() {
		return action;
	}

	public void setAction(ActionType action) {
		this.action = action;
	}

	public IdentifyType getIdentifyType() {
		return identifyType;
	}

	public void setIdentifyType(IdentifyType identifyType) {
		this.identifyType = identifyType;
	}

	public boolean status() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
}
