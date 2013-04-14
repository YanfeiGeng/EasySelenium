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
	
	private TestScript ts;
	
	private Map<String, String> data;
	
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
				this.ts = scripts.get(item.getTsName());
				for(TestScriptItem tsi : ts.getScripts()){
					BPCModel bpc = bpcs.get(tsi.getBPCName());
					this.data = this.ts.getData().get(tsi.getBPCName()).getKeyValue();
					System.out.println("Execute BPC modole: " + tsi.getBPCName());
					for(Step step : bpc.getSteps()){
						System.out.println("Execute step: action - " + step.getAction() + " on " + step.getFieldName());
						this.executeAction(step);
						System.out.println("Execute step finished: action - " + step.getAction() + " on " + step.getFieldName());
					}
				}
			}
			System.out.println("Suite executed successfully!");
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	
	public void getEl(Step step){
		switch(step.getIdentifyType()){
			case ById:
				this.el = this.driver.findElement(By.id(step.getIdentifyAttribute()));
				break;
			case ByXpath:
				this.el = this.driver.findElement(By.xpath(step.getIdentifyAttribute()));
				break;
			case ByName:
				this.el = this.driver.findElement(By.name(step.getIdentifyAttribute()));
				break;
			case ByTagName:
				this.el = this.driver.findElement(By.tagName(step.getIdentifyAttribute()));
				break;
			default:
				break;
		}
	}
	
	
	public boolean executeAction(Step step) throws InterruptedException{
		boolean result = false;
		ActionType type = step.getAction();
		Parameter pm = step.getFieldParameter();
		Parameter comp = step.getCompareWith();
		switch(type){
			case Click:
				this.getEl(step);
				this.el.click();
				Thread.sleep(1000);
				break;
			case SendKeys:
				this.getEl(step);
				if(pm.isComplexParam()){
					//TODO Make this complex field more accurate
					this.el.sendKeys(this.data.get(pm.getParameterNameComplex()[0]));
				} else {
					this.el.sendKeys(this.data.get(pm.getParameterName()));
				}
				result = true;
				break;
			case GetAttribute:
				break;
			case GetText:
				this.getEl(step);
				this.data.put(pm.getParameterName(), this.el.getText());
				System.out.println("Text() is: " + this.el.getText());
				break;
			case Verify:
				String aValue = this.data.get(pm.getParameterName());
				String bValue = comp.getFieldParameter();
				if(comp.isCompareParam()){
					bValue = this.data.get(comp.getParameterName());
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
