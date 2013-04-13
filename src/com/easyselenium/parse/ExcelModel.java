package com.easyselenium.parse;

import java.util.List;

public class ExcelModel {

	private List<SheetModel> sheets = null;
	
	public ExcelModel(List<SheetModel> sheets) {
		super();
		this.sheets = sheets;
	}

	public List<SheetModel> getSheets() {
		return sheets;
	}

	public void setSheets(List<SheetModel> sheets) {
		this.sheets = sheets;
	}
	
}
