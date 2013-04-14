package com.easyselenium.selenium;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.easyselenium.model.BPCModel;
import com.easyselenium.model.DataCenter;
import com.easyselenium.model.Parameter;
import com.easyselenium.model.Step;
import com.easyselenium.model.TestScript;
import com.easyselenium.model.TestScriptItem;
import com.easyselenium.model.TestSuite;
import com.easyselenium.model.TestSuiteItem;
import com.easyselenium.parse.ModelParsor;

public class SeleniumCommandExecutor {
	
	private BPCModel bpc;

	private WebDriver driver;
	
	private WebElement el;
	
	public SeleniumCommandExecutor() {
		super();
	}

	public BPCModel getBpc() {
		return bpc;
	}

	public void setBpc(BPCModel bpc) {
		this.bpc = bpc;
	}
	
	private void initDriver(TestSuiteItem suite){
		switch(suite.getExplorerType()){
			case IE:
				this.driver = new InternetExplorerDriver();
				break;
			case Firefox:
				this.driver = new FirefoxDriver();
				break;
			case Chrome:
				//TODO Set chrome system properties
				break;
			case Safari:
				break;
			case Opera:
				break;
			default:
				break;
		}
		driver.get(suite.getApplicationURL());
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
				this.initDriver(item);
				TestScript script = scripts.get(item.getTsName());
				for(TestScriptItem tsi : script.getScripts()){
					BPCModel bpc = bpcs.get(tsi.getBPCName());
					System.out.println("Execute BPC modole: " + tsi.getBPCName());
					for(Step step : bpc.getSteps()){
						System.out.println("Execute step: action - " + step.getAction() + " on " + step.getFieldName());
						this.executeAction(step);
					}
				}
			}
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	
	public void getEl(Step step){
		switch(step.getIdentifyType()){
			case ById:
				this.el = this.driver.findElement(By.id(step.getIdentifyAttribute()));
			case ByXpath:
				this.el = this.driver.findElement(By.xpath(step.getIdentifyAttribute()));
			case ByName:
				this.el = this.driver.findElement(By.name(step.getIdentifyAttribute()));
			case ByTagName:
				this.el = this.driver.findElement(By.tagName(step.getIdentifyAttribute()));
			default:
				break;
		}
	}
	
	
	public boolean executeAction(Step step){
		boolean result = false;
		this.getEl(step);
		ActionType type = step.getAction();
		Parameter pm = step.getFieldParameter();
		Parameter comp = step.getCompareWith();
		switch(type){
			case Click:
				this.el.click();
				break;
			case SendKeys:
				
				if(pm.isComplexParam()){
					//TODO Make this complex field more accurate
					this.el.sendKeys(DataCenter.operator().getValueByField(pm.getParameterNameComplex()[0]));
				} else {
					this.el.sendKeys(DataCenter.operator().getValueByField(pm.getParameterName()));
				}
				result = true;
				break;
			case GetAttribute:
				String value = this.el.getAttribute(step.getFieldName());
				DataCenter.operator().putData(step.getFieldName(), value);
				result = true;
				break;
			case Verify:
				String aValue = DataCenter.operator().getValueByField(pm.getParameterName());
				String bValue = comp.getFieldParameter();
				if(comp.isCompareParam()){
					bValue = DataCenter.operator().getValueByField(comp.getParameterName());
				}
				result = aValue.equalsIgnoreCase(bValue);
				break;
			default:
				break;
		}
		return result;
	}
	
	public static void main(String[] args){
		new SeleniumCommandExecutor().executeCommand();
	}

}
