package Demo;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindAll({@FindBy(id = "user-name"), @FindBy(name = "username")})
	WebElement usernameInput;
	
	@FindAll({@FindBy(id = "password"), @FindBy(name = "password")})
	WebElement passwordInput;
	
	@FindAll({@FindBy(id = "login-button"), @FindBy(xpath = "//button[@type='submit']")})
	WebElement loginButton;
	
	public void login() {
		String username, passsword, url;
		try{
			FileInputStream fileInputStream = new FileInputStream("./src/test/resources/OrangeHRMCommonData/testdata.properties");
			Properties properties = new Properties();
			properties.load(fileInputStream);
			
			url = properties.getProperty("url");
			username = properties.getProperty("username");
			passsword = properties.getProperty("password");
			
			System.out.println(properties);
			
			driver.get(url);
			
			usernameInput.sendKeys(username);
			
			passwordInput.sendKeys(passsword);
			
			loginButton.click();
			
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		catch (Exception e) {
				System.out.println(e);
		}
		
	}
}
