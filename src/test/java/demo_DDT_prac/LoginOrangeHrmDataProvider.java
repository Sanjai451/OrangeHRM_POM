package demo_DDT_prac;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginOrangeHrmDataProvider {
	
	@DataProvider(name = "KeyValueData")
	public Object[][] getDataMixVariousTypes(){
		System.out.println("Data providers called ");
		return new Object[][] {
			{"Admin", "admin123"},
			{"Admins", "admin123"},
		};
	}
	
	@Test(dataProvider = "KeyValueData")
	public void login(String key, String value) {
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		LoginPage loginPage = new LoginPage(driver);
		
		loginPage.login(key, value);
		
	}
}
