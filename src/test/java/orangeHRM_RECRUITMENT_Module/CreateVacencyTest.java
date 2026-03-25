package orangeHRM_RECRUITMENT_Module;


import java.util.Iterator;

import org.testng.annotations.Test;

import com.orangeHRM.seleniumUI.genericUtility.ActionUtility;
import com.orangeHRM.seleniumUI.genericUtility.BaseClass;
import com.orangeHRM.seleniumUI.genericUtility.ExcelUtility;
import com.orangeHRM.seleniumUI.objectRepository.Recruitment_Module_AddVacancy_Page;
import com.orangeHRM.seleniumUI.objectRepository.Recruitment_Module_Home_Page;
import com.orangeHRM.seleniumUI.objectRepository.Recruitment_Module_Vacancy_Page;

public class CreateVacencyTest extends BaseClass{
	@Test
	public void createVacancy() {
		Recruitment_Module_Home_Page home_Page = new Recruitment_Module_Home_Page(driver);
		Recruitment_Module_AddVacancy_Page addVacancy_Page = new Recruitment_Module_AddVacancy_Page(driver);
		Recruitment_Module_Vacancy_Page vacancy_Page = new Recruitment_Module_Vacancy_Page(driver);
		
		dashboardPage.clickRecruitment();
		
		home_Page.clickVacancyButton();
		
		vacancy_Page.clickAddVacancyButton();
		
		addVacancy_Page.fillCredentials("SDE3", "Freshers Leave", "1");
		
//		actions
//			.click(addVacancy_Page.getJobTitleInput())
//			.pause(Duration.ofSeconds(3))
//			.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)
//			.perform();
			
//		actions
//			.sendKeys(addVacancy_Page.getHiringManagerInput(), "a")
//			.pause(Duration.ofSeconds(5))
//			.sendKeys(Keys.ARROW_DOWN, Keys.ENTER)
//			.perform();
		
		ActionUtility au = new ActionUtility(driver);
		
//		au.manageClickAndWait(addVacancy_Page.getJobTitleInput(), 3);
//		au.performKeyDown(3);
//		au.performEnter().perform();
		
		au.navigateSelectAutoSuggestionDropDown(addVacancy_Page.getJobTitleInput(), 3);
		
		
//		au.manageSearchAndWait(addVacancy_Page.getHiringManagerInput(), "a", 5);
//		au.performKeyDown(1);
//		au.performEnter().perform();
		
		
//		au.navigateTypeAutoSuggestionDropDown(
//				addVacancy_Page.getHiringManagerInput(), "a", 1, 5);
			
		ExcelUtility excelUtility = new ExcelUtility("./src/test/resources/orange_hrm_recruitment_vacancy_testdata/vacancy.xlsx",
				"HiringManager");
		
		int numberOfManagerTestData = excelUtility.getNumberOfRows();
		
		for(int i=1; i<2; i++) {
			String searchText = excelUtility.getData(i, 1);
			System.out.println("Search Text : " + searchText);
			
			au.navigateTypeAutoSuggestionDropDown(
					addVacancy_Page.getHiringManagerInput(), searchText, 1, 5);
		}
		
		// Save button
		addVacancy_Page.clickSaveButton();
		
		try {Thread.sleep(5000);} catch (Exception e) {}
	}
	
}
