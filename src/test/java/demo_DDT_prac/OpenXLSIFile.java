package demo_DDT_prac;

import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.orangeHRM.seleniumUI.genericUtility.ExcelUtility;

public class OpenXLSIFile {
	@Test
	public void test() {
//		try {
//			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/orange_hrm_recruitment_vacancy_testdata/vacancy.xlsx");
//			
//			Workbook workbook = WorkbookFactory.create(fileInputStream);
//			
//			System.out.println("Name of Sheet (0) : " + workbook.getSheetName(0));
//			
//			Sheet vacancySheet = workbook.getSheet("VacancyData");
//
//
//			int numberOfRow = vacancySheet.getPhysicalNumberOfRows();
//			
//			for(int i=1; i<numberOfRow; i++) {
//				Row row = vacancySheet.getRow(i);
//				
//				int numberOfCell = row.getPhysicalNumberOfCells();
//				
//				System.out.println("--------------------------------------------------------");
//				
//				for(int j=0; j<numberOfCell; j++) {
//					System.out.print(formatString(row.getCell(j)) + " | ");
//				}
//				System.out.println();
//				
//			}
//			
//
//		} catch (Exception e) {
//			System.out.println(e);
//		}
		
		ExcelUtility excelUtility = new ExcelUtility("./src/test/resources/orange_hrm_recruitment_vacancy_testdata/vacancy.xlsx", "VacancyData");
		
		for(int i=1; i<excelUtility.getNumberOfRows(); i++) {
			Row row = excelUtility.getRow(i);
			for(int j=0; j< row.getPhysicalNumberOfCells(); j++) {
				System.out.println(row.getCell(j));
			}
		}
		
		System.out.println("Integer " + Double.parseDouble(excelUtility.getRow(1).getCell(3).toString()));
		
	}
//	public String formatString(Object object) {
//		String string = object.toString();
//		int n = 15;
//		int i = string.length();
//		while(i < n) {
//			string = string + " ";
//			i++;
//		}
//		if(string.length() > n) return string.substring(0, n - 2) + "..";
//		return string;
//		
//	}
}
