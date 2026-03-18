package orangeHRM_POM_Factory;

import org.testng.annotations.Test;

public class LoginLogoutPageTest extends BaseClassOrangeHRM {

	@Test
	public void login() {
		LoginPage loginPage = new LoginPage(driver);
		LogoutPage logoutPage = new LogoutPage(driver);
		
		loginPage.enterURL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		loginPage.performLogin("Admin", "admin123");
		
		logoutPage.performLogout();	
				
	}
}
