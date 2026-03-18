package orangeHRM_POM_Factory;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseClassOrangeHRM {
    WebDriver driver = null;
	
	public WebDriver getInstance() {
		System.out.println("retuning : " + driver);
		return this.driver;
	}
	
	@BeforeSuite
	public void beforeSuite() {
		Reporter.log("--- Executing Suite ---", true);
	}
	@BeforeTest
	public void beforeTest() {
		Reporter.log("--- Executing Test ---", true);
	}
	
	@BeforeClass
	public void beforeClass() {
		Reporter.log("--- Executing Class ---", true);
		this.driver = new EdgeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		Reporter.log("--- Executing Method ---", true);
	}
	@AfterMethod
	public void afterMethod() {
		Reporter.log("--- Executing after method ---", true);
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
