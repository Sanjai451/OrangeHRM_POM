package demo_DDT_prac;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.orangeHRM.seleniumUI.genericUtility.FileExtension;
import com.orangeHRM.seleniumUI.genericUtility.ScreenShotUtility;
import com.orangeHRM.seleniumUI.genericUtility.WebDriverUtility;

public class CaptureScreenShots {

	@Test
	public void screenShot() {
		WebDriver driver = new EdgeDriver();
		WebDriverUtility webDriverUtility = new WebDriverUtility(driver);

		webDriverUtility.implicitlyWait(12);

//		webDriverUtility.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//
//		LoginPage loginPage = new LoginPage(driver);
//		DashboardPage dashboardPage = new DashboardPage(driver);
//
//		loginPage.performLogin("Admin", "admin123");
		
		webDriverUtility.navigateTo("https://www.google.com");
		

		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		ScreenShotUtility screenShotUtility = new ScreenShotUtility(driver);
		
//		screenShotUtility.takeScreenShot("./reports", "fullscreen", FileExtension.PNG);
		
		WebElement testElem = driver.findElement(By.cssSelector("[class='RNNXgb']"));
		
		screenShotUtility.takeScreenShot(testElem, "./reports", "searchbar", FileExtension.GIF);
		
		
		/*

		// Capture screenshot of home page
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;

		// This will store screenShot in a temporary location
		File temp = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File perm = new File("./reports/dashboard.png");

		// to store screen shot
		try {
			FileHandler.copy(temp, perm);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement recruitmentLinkElement = dashboardPage.getRecruitmentElement();

		File tempElement = recruitmentLinkElement.getScreenshotAs(OutputType.FILE);
		File permnanetElement = new File("./reports/recruitment_slidebar.png");

		// to store screen shot
		try {
			FileHandler.copy(tempElement, permnanetElement);
		} catch (Exception e) {
			e.printStackTrace();
		}

		*/
		driver.quit();
	}
}
