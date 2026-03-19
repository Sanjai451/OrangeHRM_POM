package com.orangeHRM.seleniumUI.genericUtility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	Workbook workbook = null;
	Sheet sheet = null;

	public ExcelUtility(String path, String sheetName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(path);

			workbook = WorkbookFactory.create(fileInputStream);

			sheet = workbook.getSheet(sheetName);
			
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

}
