package demo_DDT_prac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangeHRM.seleniumUI.genericUtility.FileUtility;
import com.orangeHRM.seleniumUI.genericUtility.WebDriverUtility;
import com.orangeHRM.seleniumUI.objectRepository.LoginPage;

public class LoginTestReportGen  {

	@Test
	public void login() {
		ExtentReports extentReports = new ExtentReports();
		// Create Reporter 
		String filePath = "./reports/login_extent_report.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
		
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentTest logs = extentReports.createTest("LoginTest");

		WebDriver driver = new EdgeDriver();
		WebDriverUtility driverUtility = new WebDriverUtility(driver);
		FileUtility fileUtility = new FileUtility("./src/test/resources/OrangeHRMCommonData/common_data.properties");
		LoginPage loginPage = new LoginPage(driver);
		
		driverUtility.setMaximizeBrowser();
		driverUtility.implicitlyWait(10);
		
		String url = fileUtility.getPropertyValue("url");
		
		logs.log(Status.INFO, "Started Logging In Orange HRM");

		driverUtility.navigateTo(url);
		
		logs.log(Status.PASS, "Successfully logged in");
		
		loginPage.performLogin("Admin", "admin123");
		
		extentReports.flush();
	}
}
