package orangeHRM_PIM_Module;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.orangeHRM.seleniumUI.genericUtility.BaseClass;
import com.orangeHRM.seleniumUI.objectRepository.PIM_Module_AddEmp_Page;
import com.orangeHRM.seleniumUI.objectRepository.PIM_Module_Home_Page;

public class AddEmployeeTest extends BaseClass{

	@Test
	public void test() {
		dashboardPage.clickPIM();
		PIM_Module_Home_Page pim_Module_Home_Page = new PIM_Module_Home_Page(driver);
		PIM_Module_AddEmp_Page pim_Module_AddEmp_Page = new PIM_Module_AddEmp_Page(driver);
		SoftAssert softAssert = new SoftAssert();
		
		pim_Module_Home_Page.clickAddButton();
		
//		String firstName = "first_name";
//		
//		pim_Module_AddEmp_Page.addEmployee(
//				firstName, 
//				"mname", 
//				"lastname", 
//				"e90", 
//				"usersfade44", 
//				"password1234"
//			);
//		
//		try {Thread.sleep(5000);} catch (Exception e) {}
//		
//		if(driver.findElement(By.xpath("//h6[contains(.,'" + firstName + "')]")).isDisplayed()) {
//			System.out.println("Saved successfully");
//		}else {
//			System.out.println("Failed while saving data");
//		}
//		
		assertTrue(false);
	}
	
//	
//	@Test(priority = 3)
//	public void verifyAddedData() {
//		driver.findElement(By.xpath("//a[@href=\"/web/index.php/admin/viewAdminModule\"]")).click();
//		driver.findElement(By.xpath("//label[text()=\"Username\"]/../..//input")).sendKeys(userName);
//		
//		//selecting ESS Role
////		WebElement role = driver.findElement(By.xpath("//label[text()=\"User Role\"]/../..//i"));
//		WebElement role = driver.findElement(By.xpath("//label[text()=\"User Role\"]/../../div[2]/div/div/div"));
//		
//		role.click();
//		role.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
//		
//		driver.findElement(By.xpath("//button[contains(., 'Search')]")).click();
//		
//		// verify user
////		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class=\"oxd-table-card\"]"));
//		
//		List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class=\"oxd-table-cell oxd-padding-cell\"]//div[.='" + userName + "']"));
//
//		try {
//			Thread.sleep(4000);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//
//		System.out.println(searchResults);
//		if(searchResults.size() >= 1) {
//			System.out.println("Data Added and verified successfully");
//		}else {
//			System.out.println("Failed verificaiton");
//		}
//		
//	}

}
