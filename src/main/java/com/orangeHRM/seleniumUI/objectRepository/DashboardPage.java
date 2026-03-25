package com.orangeHRM.seleniumUI.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	-------------------- LOCATING WEB ELEMENTS  ------------------------------

	@FindBy(xpath = "//img[@src='/web/index.php/pim/viewPhoto/empNumber/7']")
	WebElement profileIconDropDown;

	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	WebElement logoutButton;
	
	@FindBy(xpath = "//a[@href='/web/index.php/admin/viewAdminModule']")
	WebElement adminSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/pim/viewPimModule']")
	WebElement pimSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/leave/viewLeaveModule']")
	WebElement leaveSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/time/viewTimeModule']")
	WebElement timeSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/recruitment/viewRecruitmentModule']")
	WebElement recruitmentSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/pim/viewMyDetails']")
	WebElement myInfoSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/performance/viewPerformanceModule']")
	WebElement performanceSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/dashboard/index']")
	WebElement dashboardSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/directory/viewDirectory']")
	WebElement directorySideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/maintenance/viewMaintenanceModule']")
	WebElement maintenanceSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/claim/viewClaimModule']")
	WebElement claimSideBar;
	
	@FindBy(xpath = "//a[@href='/web/index.php/buzz/viewBuzz']")
	WebElement buzzSideBar;
	
//	-------------------- BUSINESS LOGIC  ------------------------------
	
	public void clickPIM() {
		pimSideBar.click();
	}
	
	public void clickRecruitment() {
		recruitmentSideBar.click();
	}
	
	public WebElement getRecruitmentElement() {
		return recruitmentSideBar;
	}

	public void performLogout() {
		profileIconDropDown.click();
		logoutButton.click();
		System.out.println("Logged Out successfully");
	}

}
