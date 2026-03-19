package demo_DDT_prac;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class LoginPageUsingProperties_ObjectRepo {

	@Test
	public void login() {
		Properties properties;
		WebDriver driver;
		
		try(FileInputStream fileInputStream = new FileInputStream("./src/main/resources/objectRepository/loginPage.properties");){
			properties = new Properties();
			properties.load(fileInputStream);
			System.out.println("Properties : " + properties);
			
			driver = new EdgeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver
				.findElement(By.name(properties.getProperty("username").split(":")[1]))
				.sendKeys("Admin");
			
			driver
				.findElement(By.name(properties.getProperty("password").split(":")[1]))
				.sendKeys("admin123");
			
			driver
				.findElement(By.cssSelector(properties.getProperty("loginButton").split(":")[1]))
				.click();
		
		
			
			
		}catch (Exception e) {
			System.out.println(e);
		}
		

	}
}
