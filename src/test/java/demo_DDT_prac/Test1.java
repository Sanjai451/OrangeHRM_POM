package demo_DDT_prac;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Test1 {
	
	@Test
	public void login() {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login();
		
		
	}
	
}
