package orangeHRM_POM_Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	WebDriver driver;
	
	public LogoutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@src='/web/index.php/pim/viewPhoto/empNumber/7']")
	WebElement profileIcon;
	
	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	WebElement logoutButton;

	public void performLogout() {
		profileIcon.click();
		logoutButton.click();
		System.out.println("Logout successfully");
	}
	
}
