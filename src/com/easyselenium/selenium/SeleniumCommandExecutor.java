package com.easyselenium.selenium;

import java.util.Map;

import com.easyselenium.model.BPCModel;
import com.easyselenium.model.Step;
import com.easyselenium.model.TestScript;
import com.easyselenium.model.TestScriptItem;
import com.easyselenium.model.TestSuite;
import com.easyselenium.model.TestSuiteItem;
import com.easyselenium.parse.ModelParsor;

public class SeleniumCommandExecutor {
	
	private BPCModel bpc;

	public SeleniumCommandExecutor() {
		super();
	}

	public BPCModel getBpc() {
		return bpc;
	}

	public void setBpc(BPCModel bpc) {
		this.bpc = bpc;
	}
	
	public void executeCommand(){
		try {
			String path = "C:\\ws\\selenium\\EasySelenium\\Template";
			ModelParsor parsor = new ModelParsor(path);
			TestSuite suite = parsor.getTestSuite();
			Map<String, TestScript> scripts = parsor.getTestScripts();
			Map<String, BPCModel> bpcs = parsor.getBPCModel();
			for(TestSuiteItem item : suite.getItems()){
				System.out.println("Execute suite module: " + item.getModule());
				TestScript script = scripts.get(item.getTsName());
				for(TestScriptItem tsi : script.getScripts()){
					BPCModel bpc = bpcs.get(tsi.getBPCName());
					System.out.println("Execute BPC modole: " + tsi.getBPCName());
					for(Step step : bpc.getSteps()){
						System.out.println("Execute step: action - " + step.getAction() + " on " + step.getFieldName());
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args){
		new SeleniumCommandExecutor().executeCommand();
	}

}
