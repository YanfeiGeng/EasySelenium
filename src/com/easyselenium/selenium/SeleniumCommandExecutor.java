package com.easyselenium.selenium;

import org.openqa.selenium.WebDriver;

import com.easyselenium.model.BPCModel;

public class SeleniumCommandExecutor {
	
	private BPCModel bpc;
	
	private WebDriver driver;
	
	

	public SeleniumCommandExecutor(BPCModel bpc, WebDriver driver) {
		super();
		this.bpc = bpc;
		this.driver = driver;
	}

	
	
	public WebDriver getDriver() {
		return driver;
	}



	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}



	public BPCModel getBpc() {
		return bpc;
	}

	public void setBpc(BPCModel bpc) {
		this.bpc = bpc;
	}
	
	public boolean executeCommand(){
		
//		String action = this.bpc.getAction();
//		String identifyType = this.bpc.getIdentifyType();
//		String identifyAttribute = this.bpc.getIdentifyAttribute();
		
		
		return false;
	}

}
