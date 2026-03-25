package demo_DDT_prac;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.orangeHRM.seleniumUI.genericUtility.ExcelUtility;

public class Test1 {
	
	@Test
	public void login() {
		ExcelUtility excelUtility = new ExcelUtility("./src/test/resources/orange_hrm_recruitment_vacancy_testdata/vacancy.xlsx",
				"CandidatesData");
	
		String string = excelUtility.getData(1, 6);
		String[] splittedStrings = string.split("/");
		
		System.out.println(Arrays.toString(splittedStrings));
		
		String formattedString = "20" + splittedStrings[2] + "-" + splittedStrings[0] + "-" + splittedStrings[1];
		
		System.out.println(string);
		System.out.println(formattedString);
		
//		return formattedString;
		
		
	}
	
}
