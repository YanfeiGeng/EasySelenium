package com.easyselenium.parse;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	private XSSFWorkbook excel = null;
	
	private List<XSSFSheet> sheets = null;
	
	private ExcelModel excelModel = null;
	
	private File file = null;
	
	public ExcelReader(File file){
		this.file = file;
	}
	
	/**
	 * Return the java represented Excel object
	 */
	public ExcelModel loadExcel(){
		try {
			OPCPackage pkg = OPCPackage.open(file);
			this.excel = new XSSFWorkbook(pkg);
			this.initSheets(); 
			this.initExcelModel();
		} catch (Exception e) {
			System.err.println("Failed to load the Excel file with path:" + file);
			e.printStackTrace();
		}
		return excelModel;
	}
	
	private void initSheets(){
		this.sheets = new ArrayList<XSSFSheet>();
		for(int i = 0; i < this.excel.getNumberOfSheets(); i++){
			this.sheets.add(this.excel.getSheetAt(i));
		}
	}
	
	private void initExcelModel(){
		System.out.println("Start to Load..");
		List<SheetModel> sheetModels = new ArrayList<SheetModel>();
		// Init each excel
		for(XSSFSheet sheet : this.sheets){
			List<String> header = new ArrayList<String>();
			List<RowModel> body = new ArrayList<RowModel>();
			//Create a new SheetModel
			for(int row = 0; row <= sheet.getLastRowNum(); row++){
				XSSFRow xRow = sheet.getRow(row);
				List<String> cells = new ArrayList<String>();
				if(null != xRow){
					for(int cell = 0; cell < xRow.getLastCellNum(); cell++){
						xRow.getCell(cell).setCellType(Cell.CELL_TYPE_STRING);
						cells.add(xRow.getCell(cell).getStringCellValue());
					}
					if(row == 0){
						header = cells;
					} else {
						body.add(new RowModel(cells));
					}
				}
			}
			sheetModels.add(new SheetModel(sheet.getSheetName(), header, body));
		}
		this.excelModel = new ExcelModel(sheetModels);
		System.out.println("Finshed to Load..");
	}
		
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ExcelReader(new File("C:\\ws\\selenium\\EasySelenium\\Template\\TestSuite\\TestSuite.xlsx"));
		
	}

	public ExcelModel getExcelModel() {
		return excelModel;
	}

	public void setExcelModel(ExcelModel excelModel) {
		this.excelModel = excelModel;
	}

}
