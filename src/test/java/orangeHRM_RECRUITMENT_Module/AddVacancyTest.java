package orangeHRM_RECRUITMENT_Module;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.orangeHRM.seleniumUI.genericUtility.ActionUtility;
import com.orangeHRM.seleniumUI.genericUtility.BaseClass;
import com.orangeHRM.seleniumUI.genericUtility.ExcelUtility;
import com.orangeHRM.seleniumUI.objectRepository.Recruitment_Module_AddVacancy_Page;
import com.orangeHRM.seleniumUI.objectRepository.Recruitment_Module_Home_Page;
import com.orangeHRM.seleniumUI.objectRepository.Recruitment_Module_Vacancy_Page;

public class AddVacancyTest extends BaseClass{
	@Test
	public void addVacancy() {
		Recruitment_Module_AddVacancy_Page addVacancy_Page = new Recruitment_Module_AddVacancy_Page(driver);
		Recruitment_Module_Home_Page r_home_Page = new Recruitment_Module_Home_Page(driver);
		Recruitment_Module_Vacancy_Page r_vacancy_Page = new Recruitment_Module_Vacancy_Page(driver);
		ActionUtility actionUtility = new ActionUtility(driver);
		
		dashboardPage.clickRecruitment();
		
		r_home_Page.clickVacancyButton();
		
		r_vacancy_Page.clickAddVacancyButton();

		WebElement jobTitleInput = addVacancy_Page.getJobTitleInput();
		
		WebElement hiringManagerInput = addVacancy_Page.getHiringManagerInput();
		
		ExcelUtility excelUtility = new ExcelUtility("./src/test/resources/orange_hrm_recruitment_vacancy_testdata/vacancy.xlsx",
					"AddVacancy");
		
		addVacancy_Page.fillCredentials(
				excelUtility.getData(1, 0),
				excelUtility.getData(1, 1),
				excelUtility.getData(1, 2));
		
//		addVacancy_Page.fillCredentials("vacancy", "desc", "10");
		
		actionUtility.navigateSelectAutoSuggestionDropDown(jobTitleInput, 2);

		actionUtility.navigateTypeAutoSuggestionDropDown(hiringManagerInput, "m", 1, 5);
		
		
		addVacancy_Page.clickSaveButton();
		
		try {
			Thread.sleep(4000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		r_home_Page.clickVacancyButton();
		
		List<WebElement> elementsInVacancy = driver.findElements(By.cssSelector("div.oxd-table-card>div:nth-child(1)>div:nth-child(2)>div:nth-child(1)"));
		
//		System.out.println("arr : " + elementsInVacancy);
		
		boolean isFound = false;
		
		System.out.println("Checking : " + excelUtility.getData(1, 0));
		
		for(WebElement element : elementsInVacancy) {
			System.out.println(element.getTagName() + " " + element.getText());
			
			if(element.getText().trim().equals(excelUtility.getData(1, 0).trim())) {
				isFound = true;
				break;
			}
		}
		
		assertEquals(isFound, true);
		
	}
}
