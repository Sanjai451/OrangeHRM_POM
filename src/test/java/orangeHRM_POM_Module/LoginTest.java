package orangeHRM_POM_Module;

import org.testng.annotations.Test;

import com.orangeHRM.seleniumUI.genericUtility.BaseClass;
import com.orangeHRM.seleniumUI.objectRepository.DashboardPage;
import com.orangeHRM.seleniumUI.objectRepository.PIM_Module_AddEmp_Page;
import com.orangeHRM.seleniumUI.objectRepository.PIM_Module_Home_Page;

import orangeHRM_POM_Factory.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void addNewEmployee() {
		
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//		DashboardPage dashboardPage = new DashboardPage(driver);
//		LoginPage loginPage = new LoginPage(driver);
		PIM_Module_Home_Page pim_Module_Home_Page = new PIM_Module_Home_Page(driver);
		PIM_Module_AddEmp_Page pim_Module_AddEmp_Page = new PIM_Module_AddEmp_Page(driver);
		
		
//		loginPage.performLogin("Admin", "admin123");
		
//		try {Thread.sleep(4000);} catch (Exception e) {}
		
		dashboardPage.clickPIM();
		
//		try {Thread.sleep(4000);} catch (Exception e) {}
		
		pim_Module_Home_Page.clickAddButton();
		
		String uniqueUsername = "spiderman123" +  (((int) Math.random()) * 100);
				
		pim_Module_AddEmp_Page.addEmployee("Sanjai", "Kumar", "R", "12321", uniqueUsername, "Spider@12345");
		
		try {Thread.sleep(4000);} catch (Exception e) {}
		
//		dashboardPage.performLogout();
		
//		try {Thread.sleep(4000);} catch (Exception e) {}
		
	}
}
