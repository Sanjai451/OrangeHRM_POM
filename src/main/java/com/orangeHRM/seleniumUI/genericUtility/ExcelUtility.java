package com.orangeHRM.seleniumUI.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


public class ExcelUtility {

	Workbook workbook = null;
	Sheet sheet = null;
	String path = null;
	
	/*
	 * This Constructor is required for using excelUtilityProvider
	 */
	public ExcelUtility() {
	    this.path = "./src/test/resources/orange_hrm_recruitment_vacancy_testdata/vacancy.xlsx";   // give your file path
	    String sheetName = "HiringManager";   // give your sheet name

	    try {
	        FileInputStream fileInputStream = new FileInputStream(path);
	        workbook = WorkbookFactory.create(fileInputStream);
	        sheet = workbook.getSheet(sheetName);
	        fileInputStream.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	}

	public ExcelUtility(String path, String sheetName) {
		this.path = path;
		
		try {
			FileInputStream fileInputStream = new FileInputStream(path);

			workbook = WorkbookFactory.create(fileInputStream);

			sheet = workbook.getSheet(sheetName);
			
			fileInputStream.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Row getRow(int n) {
		return sheet.getRow(n);
	}
	
	public int getNumberOfRows() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public int getNumberOfCols() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	public String getData(int row, int col) {
		CellType type = sheet.getRow(row).getCell(col).getCellType();
		
		if(type == CellType.NUMERIC) {
			String value = sheet.getRow(row).getCell(col).toString();
			return value.split("\\.")[0];
		}
		return sheet.getRow(row).getCell(col).toString();
	}
	
	public void setData(int row, int col, String data) {
		try {
			if(sheet.getRow(row) == null) {
				sheet.createRow(row);
			}
			if(sheet.getRow(row).getCell(col) != null) {
				sheet.getRow(row).createCell(col);
			}
			
			sheet.getRow(row).getCell(col).setCellValue(data);
			
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			
			workbook.write(fileOutputStream);
			
			fileOutputStream.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
	
	@DataProvider(name = "excelUtilityProvider")
	public Object[][] getAsDataProvider(){
		int r = getNumberOfRows();
		int c = getNumberOfCols();
		Object[][] res = new Object[r - 1][c]; // avoiding heading
		
		for(int i=1; i<r; i++) {
			for(int j=0; j<c; j++) {
				res[i - 1][j] = getData(i, j);
			}
		}
		return res;
	}

}
