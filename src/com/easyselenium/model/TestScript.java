package com.easyselenium.model;

import java.util.List;
import java.util.Map;

public class TestScript {
	
	public TestScript(List<TestScriptItem> scripts, Map<String, DataItem> data) {
		super();
		this.scripts = scripts;
		this.data = data;
	}

	private List<TestScriptItem> scripts;
	
	private Map<String, DataItem> data;
	
	public List<TestScriptItem> getScripts() {
		return scripts;
	}

	public void setScripts(List<TestScriptItem> scripts) {
		this.scripts = scripts;
	}

	public Map<String, DataItem> getData() {
		return data;
	}

	public void setData(Map<String, DataItem> data) {
		this.data = data;
	}
}
