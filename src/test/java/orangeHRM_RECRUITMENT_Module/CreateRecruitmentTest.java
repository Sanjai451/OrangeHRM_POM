package orangeHRM_RECRUITMENT_Module;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.orangeHRM.seleniumUI.genericUtility.BaseClass;
import com.orangeHRM.seleniumUI.genericUtility.ExcelUtility;
import com.orangeHRM.seleniumUI.objectRepository.Recruitment_Module_AddCandidate_Page;
import com.orangeHRM.seleniumUI.objectRepository.Recruitment_Module_Home_Page;

public class CreateRecruitmentTest extends BaseClass {
	@Test
	public void test() {
		Recruitment_Module_Home_Page r_homePage = new Recruitment_Module_Home_Page(driver);
		Recruitment_Module_AddCandidate_Page r_addCandidatePage = new Recruitment_Module_AddCandidate_Page(driver);
		
		dashboardPage.clickRecruitment();
		
		r_homePage.clickAddCandidateButton();
		
		ExcelUtility excelUtility = new ExcelUtility("./src/test/resources/orange_hrm_recruitment_vacancy_testdata/vacancy.xlsx",
					"CandidatesData");
		
		String firstName = excelUtility.getData(1, 0);
		String lastName = excelUtility.getData(1, 2);
		
		r_addCandidatePage.addCandidate(
				firstName, 
				excelUtility.getData(1, 1),
				lastName, 
				excelUtility.getData(1, 3),
				excelUtility.getData(1, 4),
				excelUtility.getData(1, 5),
				formatDate(excelUtility.getData(1, 6))
				);
		
		r_homePage.clickCandidateButton();
		
		List<WebElement> addedData = driver.findElements(By.cssSelector("div.oxd-table-card>div:nth-child(1)>div:nth-child(3)>div:nth-child(1)"));
		
		boolean isFound = false;
		
		for(WebElement element : addedData) {
			System.out.println(element.getText());
			if(element.getText().contains(firstName)) {
				isFound = true;
				break;
			}
		}
		
		assertEquals(isFound, true);
		
	}
	
	public static String formatDate(String string) {
		System.out.println("Date From Excel : " + string);
		
		String[] splittedStrings = string.split("/");
		
		System.out.println(Arrays.toString(splittedStrings));
		
		String formattedString = "20" + splittedStrings[2] + "-" + splittedStrings[0] + "-" + splittedStrings[1];
		
		System.out.println("Formated Date : " + formattedString);
		
		return formattedString;
	}
	
}
