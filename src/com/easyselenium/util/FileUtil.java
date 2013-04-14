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
	
	public File getTestSuite() throws Exception{
		File folder = new File(this.ROOT_PATH + File.separator + this.SUITE);
		if(folder.exists()){
			File[] files = folder.listFiles();
			return files.length > 0 ? files[0]: null;
		} else {
			throw new Exception("Fail to find the Test Suite file.");
		}
	}
	
	public File[] getTestScripts() throws Exception{
		return this.getFiles(1, "Fail to get Script configuration files.");
	}
	
	public File[] getBPC() throws Exception{
		return this.getFiles(2, "Fail to get BPC configuration files.");
	}
	
	private File[] getFiles(int type, String msg) throws Exception{
		String path = "";
		switch(type){
			case 1: //Test Script type
				path = this.ROOT_PATH + File.separator + this.SCRIPT;
				break;
			case 2: //BPC Type
				path = this.ROOT_PATH + File.separator + this.BPC;
				break;
			default:
				break;
		}
		File folder = new File(path);
		if(folder.exists()){
			File[] files = folder.listFiles();
			return files;
		} else {
			throw new Exception(msg);
		}
	}
	
}
