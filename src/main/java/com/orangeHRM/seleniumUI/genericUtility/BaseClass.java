package com.orangeHRM.seleniumUI.genericUtility;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.orangeHRM.seleniumUI.objectRepository.DashboardPage;
import com.orangeHRM.seleniumUI.objectRepository.LoginPage;

public class BaseClass {
    public WebDriver driver = null;
    public LoginPage loginPage = null;
    public DashboardPage dashboardPage = null;
    public Actions actions = null;
    public PropertiesUtility propertiesUtility = null;
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("--- Executing Suite ---", true);
	}
	@BeforeTest
	public void beforeTest() {
		Reporter.log("--- Executing Test ---", true);
		propertiesUtility = new PropertiesUtility();
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("--- Executing Class ---", true);
		
		this.driver = GetBrowser.getBrowser(PropertiesUtility.readData("browser"));
		
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));	
		this.actions = new Actions(driver);
		this.loginPage = new LoginPage(driver);
		this.dashboardPage = new DashboardPage(driver);
		
		driver.get(PropertiesUtility.readData("url"));
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("--- Executing Method ---", true);
		
		loginPage.performLogin(PropertiesUtility.readData("username"), PropertiesUtility.readData("password"));
		
		Reporter.log("--- Logged in Successfully ---", true);
	}
	@AfterMethod
	public void afterMethod() {
		Reporter.log("--- Executing after method ---", true);
		dashboardPage.performLogout();
		Reporter.log("--- Logged Out Successfully  ---", true);
	}
	@AfterClass
	public void afterClass() {
		Reporter.log("--- Executing after Class ---", true);
		driver.quit();
	}
	@AfterTest
	public void afterTest() {
		Reporter.log("--- Executing after test ---", true);
	}
	@AfterSuite
	public void afterSuite() {
		Reporter.log("--- Executing after suite ---", true);
	}
}
