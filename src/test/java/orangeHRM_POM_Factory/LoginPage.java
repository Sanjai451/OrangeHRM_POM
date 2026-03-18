package orangeHRM_POM_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{
	
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "username")
	WebElement usernameInput;
	
	@FindBy(name = "password")
	WebElement passwordInput;
	
	@FindBy(css = "[type='submit']")
	WebElement loginButton;
	
	public void enterURL(String url) {
		driver.get(url);
	}

	
	public void performLogin(String username, String password) {
		usernameInput.sendKeys(username);
		passwordInput.sendKeys(password);
		loginButton.click();
	}
}
