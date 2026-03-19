package demo_DDT_prac;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Practice {

	WebDriver driver;
	String username, passsword, url;
	@Test
	public void login() {
		readProperties();
		
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		if(url.contains("orange")) {
			loginOrange(username, passsword);
			writeOrangeProperties();	
			readProperties();
			loginSwag(username, passsword);
		}else {
			loginSwag(username, passsword);
			writeSwagProperties();
			readProperties();
			loginOrange(username, passsword);
		}
		
	}

	public void loginSwag(String username, String password) {
		driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        
        try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}
	public void loginOrange(String username, String pass) {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(pass);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
		}
	}

	public void readProperties() {
		try{
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/OrangeHRMCommonData/testdata.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			passsword = properties.getProperty("password");
		}
		catch (Exception e) {
				System.out.println(e);
		}
	}
	public void writeSwagProperties() {
		try{
			FileOutputStream fos = new FileOutputStream("./src/test/resources/OrangeHRMCommonData/testdata.properties");
			Properties properties = new Properties();
			properties.setProperty("url", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			properties.setProperty("username", "Admin");
			properties.setProperty("password", "admin123");
			properties.store(fos, null);
		}
		catch (Exception e) {
				System.out.println(e);
		}
	}
	public void writeOrangeProperties() {
		try{
			FileOutputStream fos = new FileOutputStream("./src/test/resources/OrangeHRMCommonData/testdata.properties");
			Properties properties = new Properties();
			properties.setProperty("url", "https://www.saucedemo.com/");
			properties.setProperty("username", "standard_user");
			properties.setProperty("password", "secret_sauce");
			properties.store(fos, null);
		}
		catch (Exception e) {
				System.out.println(e);
		}
	}
}
