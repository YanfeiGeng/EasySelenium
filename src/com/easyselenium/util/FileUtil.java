package com.easyselenium.util;

import java.io.File;

public class FileUtil {

	private String ROOT_PATH;
	
	private String SUITE = "TestSuite";
	
	private String SCRIPT = "TestScript";
	
	private String BPC = "BPC";
	
	public FileUtil(String rootPath){
		this.ROOT_PATH = rootPath;
	}
	
	public String getTestSuitePath(){
		return this.ROOT_PATH + File.separator + this.SUITE;
	}
	
	public String getTestScriptPath(){
		return this.ROOT_PATH + File.separator + this.SCRIPT;
	}
	
	public String getBPCPath(){
		return this.ROOT_PATH + File.separator + this.BPC;
	}
	
}
