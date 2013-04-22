package com.easyselenium.selenium;

import java.io.File;
import java.util.Map;


import com.easyselenium.model.BPCModel;
import com.easyselenium.model.TestScript;
import com.easyselenium.model.TestSuite;
import com.easyselenium.parse.ModelParsor;

public class ConfigurationResource {

	private static TestSuite suite;
	private static Map<String, TestScript> scripts;
	private static Map<String, BPCModel> bpcs;
	
	private static String path = ".\\Template";

	private ConfigurationResource(){
	}
	
	private static ConfigurationResource instance;
	
	public static ConfigurationResource instance(){
		if(null == instance){
			instance = new ConfigurationResource();
			load();
		}
		return instance;
	}
	
	private static void load(){
		try{
			ModelParsor parsor = new ModelParsor(path);
			suite = parsor.getTestSuite();
			scripts = parsor.getTestScripts();
			bpcs = parsor.getBPCModel();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public TestSuite getSuite() {
		return suite;
	}

	public Map<String, TestScript> getScripts() {
		return scripts;
	}

	public Map<String, BPCModel> getBpcs() {
		return bpcs;
	}
	
	public static void main(String[] args){
		System.out.println(new File(".").getAbsolutePath());
	}

}
