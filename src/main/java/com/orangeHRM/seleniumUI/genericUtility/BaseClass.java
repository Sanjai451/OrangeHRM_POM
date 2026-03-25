package com.orangeHRM.seleniumUI.genericUtility;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.orangeHRM.seleniumUI.objectRepository.DashboardPage;
import com.orangeHRM.seleniumUI.objectRepository.LoginPage;

@Listeners(com.orangeHRM.seleniumUI.genericUtility.ListenerImplementation.class)
public class BaseClass {
	String PATH = "./src/test/resources/OrangeHRMCommonData/common_data.properties";	
    public WebDriver driver = null;
    public WebDriverUtility webDriverUtility = null;
    public LoginPage loginPage = null;
    public DashboardPage dashboardPage = null;
    public PropertiesUtility propertiesUtility = null;
    public FileUtility fileUtility = new FileUtility(PATH);
	
	@BeforeSuite
	public void configBeforeSuite() {
		Reporter.log("--- Executing Suite ---", true);
	}
	@BeforeTest
	public void configBeforeTest() {
		Reporter.log("--- Executing Test ---", true);
//		propertiesUtility = new PropertiesUtility();
	}
	
	@BeforeClass
	public void configBeforeClass() {
		Reporter.log("--- Executing Class ---", true);
				
//		this.driver = GetBrowser.getBrowser(PropertiesUtility.readData("browser"));
		this.driver = GetBrowser.getBrowser(fileUtility.getPropertyValue("browser"));
		
		this.webDriverUtility = new WebDriverUtility(driver);
		webDriverUtility.setMaximizeBrowser();
		webDriverUtility.implicitlyWait(15);
		
		this.loginPage = new LoginPage(driver);
		this.dashboardPage = new DashboardPage(driver);
		
//		driver.get(PropertiesUtility.readData("url"));
		driver.get(fileUtility.getPropertyValue("url"));
		
	}
	
	@BeforeMethod
	public void configBeforeMethod() {
		Reporter.log("--- Executing Method ---", true);
		
//		loginPage.performLogin(PropertiesUtility.readData("username"), PropertiesUtility.readData("password"));
		loginPage.performLogin(fileUtility.getPropertyValue("username"), 
				fileUtility.getPropertyValue("password"));
		
		Reporter.log("[INFO]    Logged in Successfully", true);
	}
	@AfterMethod
	public void configAfterMethod() {
		Reporter.log("--- Executing after method ---", true);
		dashboardPage.performLogout();
		Reporter.log("[INFO]    Logged Out Successfully", true);
	}
	@AfterClass
	public void configAfterClass() {
		Reporter.log("--- Executing after Class ---", true);
		this.webDriverUtility.quitBrowser();
		Reporter.log("[INFO]    QUITTED BROWSER");
	}
	@AfterTest
	public void configAfterTest() {
		Reporter.log("--- Executing after test ---", true);
	}
	@AfterSuite
	public void configAfterSuite() {
		Reporter.log("--- Executing after suite ---", true);
	}
}
