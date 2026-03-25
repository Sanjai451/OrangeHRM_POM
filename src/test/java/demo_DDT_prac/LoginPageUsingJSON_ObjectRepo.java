package demo_DDT_prac;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class LoginPageUsingJSON_ObjectRepo {

	@Test
	public void login() {
		try {
			String data = new String(Files.readAllBytes(
					Paths.get("./src/main/resources/objectRepository/LoginPage.json")
					));
			
//			JSONObject jsonObject = new JSONObject(data);
			JSONObject jsonObject = new JSONObject(data); 
			System.out.println(jsonObject.getJSONObject("login"));
			JSONObject login = jsonObject.getJSONObject("login");
			
//			System.out.println(login.getString("username"));
			
//			System.out.println(login.getString("password"));
			
			String usernameLocator = login.getString("username").split(":")[1];
			String passwordLocator = login.getString("password").split(":")[1];
			String loginButtonLocator = login.getString("loginButton").split(":")[1];
			
//			System.out.println(loginButtonLocator);
//			System.out.println(loginLocator + passwordLocator);
			
			
			WebDriver driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver
				.findElement(By.name(usernameLocator))
				.sendKeys("Admin");
			
			driver
				.findElement(By.name(passwordLocator))
				.sendKeys("admin123");
			
			driver
				.findElement(By.cssSelector(loginButtonLocator))
				.click();
		
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
