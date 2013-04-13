package com.easyselenium.model;

import java.util.HashMap;
import java.util.Map;

/**
 * Prepare for the data for all the BPC
 * @author yageng
 *
 */

public class DataCenter {
	
	private Map<String, String> data;
	
	public static DataCenter instance = null;
	
	private DataCenter(){
		this.init();
	}
	
	public static DataCenter operator(){
		if(null == instance){
			instance = new DataCenter();
		}
		return instance;
	}
	
	private void init(){
		this.data = new HashMap<String, String>();
	}
	
	/**
	 * Get the field value by field name
	 * @param field
	 * @return
	 */
	public String getValueByField(String field){
		return this.data.get(field);
	}
	
	public boolean putData(String field, String value){
		this.data.put(field, value);
		return true;
	}

}
