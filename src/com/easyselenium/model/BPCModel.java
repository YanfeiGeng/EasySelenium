package com.easyselenium.model;

import java.util.List;

public class BPCModel {

	private List<Step> steps = null;

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	public BPCModel(List<Step> steps) {
		super();
		this.steps = steps;
	}

}
