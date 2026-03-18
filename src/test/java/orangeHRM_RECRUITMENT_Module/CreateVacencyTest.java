package orangeHRM_RECRUITMENT_Module;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.orangeHRM.seleniumUI.genericUtility.ActionUtility;
import com.orangeHRM.seleniumUI.genericUtility.BaseClass;
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
		
		ActionUtility au = new ActionUtility(actions);
		
		au.manageClickAndWait(addVacancy_Page.getJobTitleInput(), 3);
		au.performKeyDown(3);
		au.performEnter().perform();
		
		
		au.manageSearchAndWait(addVacancy_Page.getHiringManagerInput(), "a", 5);
		au.performKeyDown(1);
		au.performEnter().perform();
			
		
		// Save button
		addVacancy_Page.clickSaveButton();
		
		try {Thread.sleep(5000);} catch (Exception e) {}
	}
}
