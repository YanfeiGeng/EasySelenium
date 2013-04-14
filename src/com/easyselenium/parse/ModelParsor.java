package com.easyselenium.parse;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.easyselenium.model.BPCModel;
import com.easyselenium.model.DataItem;
import com.easyselenium.model.Parameter;
import com.easyselenium.model.Step;
import com.easyselenium.model.TestScript;
import com.easyselenium.model.TestScriptItem;
import com.easyselenium.model.TestSuite;
import com.easyselenium.model.TestSuiteItem;
import com.easyselenium.selenium.ActionType;
import com.easyselenium.selenium.BrowserType;
import com.easyselenium.selenium.IdentifyType;
import com.easyselenium.util.FileUtil;

public class ModelParsor {
	
	private FileUtil file;
	
	public ModelParsor(String path){
//		this.file = file;
		this.init(path);
	}
	
	private void init(String path){
		this.file = new FileUtil(path);
	}
	
	/**
	 * Get TestSuite by parse the Excel
	 * @return
	 */
	public TestSuite getTestSuite(){
		try {
			File suiteFile = this.file.getTestSuite();
			ExcelReader reader = new ExcelReader(suiteFile);
			ExcelModel excel = reader.loadExcel();

			//TODO Should verify the header for the configuration sequence is same as we defined
			if(excel.getSheets().size() > 0){
				List<TestSuiteItem> items = new ArrayList<TestSuiteItem>();
				for(RowModel row : excel.getSheets().get(0).getBody()){
					List<String> v = row.getCells();
					if(this.isEmpty(this.getValue(v, 2))){
						//If TS_Name, then do not create a new test suite item, as this
						//name is required
						continue;
					}
					TestSuiteItem item = new TestSuiteItem();
					item.setNeedOrNot(toBoolean(getValue(v, 0)));
					item.setModule(getValue(v, 1));
					item.setTsName(getValue(v, 2));
					item.setComments(getValue(v, 3));
					item.setExplorerType(BrowserType.getType(getValue(v, 4)));
					item.setApplicationURL(getValue(v, 5));
					items.add(item);
				}
				return new TestSuite(items);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Get all test scripts by parsing the Excel
	 * @return
	 * @throws Exception 
	 */
	public Map<String, TestScript> getTestScripts() throws Exception{
		File[] scriptFiles = this.file.getTestScripts();
		Map<String, TestScript> allScripts = new HashMap<String, TestScript>();
		for(File script : scriptFiles){
			ExcelReader reader = new ExcelReader(script);
			ExcelModel excel = reader.loadExcel();
			List<TestScriptItem> items = new ArrayList<TestScriptItem>();
			Map<String, DataItem> sheetData = new HashMap<String, DataItem>();
			//TODO Validate header
			for(int i = 0; i < excel.getSheets().size(); i++){
				if(i == 0){
					for(RowModel row : excel.getSheets().get(i).getBody()){
						List<String> v = row.getCells();
						if(this.isEmpty(this.getValue(v, 1))){
							//BPC Name is required, or else no new item create
							continue;
						}
						TestScriptItem singleScript = new TestScriptItem();
						singleScript.setNeedOrNot(this.toBoolean(getValue(v, 0)));
						singleScript.setBPCName(getValue(v, 1));
						singleScript.setComments(getValue(v, 2));
						items.add(singleScript);
					}
				} else {
					Map<String, String> keyV = new HashMap<String, String>();
					SheetModel st = excel.getSheets().get(i);
					if(!st.getHeader().isEmpty() && !st.getBody().isEmpty()){
						List<String> keys = excel.getSheets().get(i).getHeader();
						List<String> vals = excel.getSheets().get(i).getBody().get(0).getCells(); //By default, it at least have 2nd row.
						for(int k = 0; k < keys.size(); k++){
							keyV.put(getValue(keys,k), getValue(vals,k));
						}
						sheetData.put(excel.getSheets().get(i).getName(), new DataItem(keyV));
					}
				}
			}
			allScripts.put(this.getName(script.getName()), new TestScript(items, sheetData));
		}
		return allScripts;
	}
	
	/**
	 * Get all BPC Models that defined in the Excel
	 * @return
	 * @throws Exception 
	 */
	public Map<String, BPCModel> getBPCModel() throws Exception{
		File[] scriptFiles = this.file.getBPC();
		Map<String, BPCModel> bpcs = new HashMap<String, BPCModel>();
		for(File bpcFile : scriptFiles){
			ExcelReader reader = new ExcelReader(bpcFile);
			ExcelModel excel = reader.loadExcel();
			List<Step> steps = new ArrayList<Step>();
			//By default, load the fist sheet
			for(RowModel rows : excel.getSheets().get(0).getBody()){
				if(this.isEmpty(this.getValue(rows.getCells(), 2))){
					//If field name is empty, no step created.
					continue;
				}
				Step step = new Step();
				step.setNeedOrNot(this.toBoolean(getValue(rows.getCells(), 0)));
				step.setStep(getValue(rows.getCells(), 1));
				step.setAction(ActionType.getType(getValue(rows.getCells(), 2)));
				step.setFieldName(getValue(rows.getCells(), 3));
				step.setFieldParameter(new Parameter(getValue(rows.getCells(), 4)));
				step.setIdentifyType(IdentifyType.getType(getValue(rows.getCells(), 5)));
				step.setIdentifyAttribute(getValue(rows.getCells(), 6));
				step.setCompareWith(new Parameter(getValue(rows.getCells(), 7)));
				steps.add(step);
			}
			bpcs.put(this.getName(bpcFile.getName()), new BPCModel(steps));
		}
		return bpcs;
	}
	
	private String getValue(List<String> source, int pos){
		if(pos < source.size()){
			return source.get(pos);
		} else {
			return null;
		}
	}
	
	private boolean toBoolean(String v){
		if(this.isEmpty(v)){
			return false;
		} else {
			return "yes".equalsIgnoreCase(v)?true:false;
		}
	}
	
	private String getName(String n){
		if(this.isEmpty(n)){
			return "";
		} else {
			return n.substring(0, n.indexOf("."));
		}
	}
	
	private boolean isEmpty(String v){
		return v == null || "".equals(v);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

}
