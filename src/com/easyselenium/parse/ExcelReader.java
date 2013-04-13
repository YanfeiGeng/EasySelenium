package com.easyselenium.parse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private XSSFWorkbook excel = null;
	
	private List<XSSFSheet> sheets = null;
	
	private SheetModel excelModel = null;
	
	
	/**
	 * Return the java represented Excel object
	 */
	public SheetModel loadExcel(String file){
		try {
//			this.excel = WorkbookFactory.create(new FileInputStream(file));
			OPCPackage pkg = OPCPackage.open(new File("file.xlsx"));
			this.excel = new XSSFWorkbook(pkg);
			this.initSheets(); 
			this.initExcelModel();
		} catch (Exception e) {
			System.err.println("Failed to load the Excel file with path:" + file);
		}
		return null;
	}
	
	private void initSheets(){
		this.sheets = new ArrayList<XSSFSheet>();
		for(int i = 0; i < this.excel.getNumberOfSheets(); i++){
			this.sheets.add(this.excel.getSheetAt(i));
		}
	}
	
	private void initExcelModel(){
		// Init each excel
		for(XSSFSheet sheet : this.sheets){
			//Create a new SheetModel
			for(int row = 1; row <= sheet.getLastRowNum(); ){
				
			}
		}
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	}

	public SheetModel getExcelModel() {
		return excelModel;
	}

	public void setExcelModel(SheetModel excelModel) {
		this.excelModel = excelModel;
	}

}
