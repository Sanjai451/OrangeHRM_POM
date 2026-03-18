package com.orangeHRM.seleniumUI.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIM_Module_Home_Page {
	
	WebDriver driver;

	public PIM_Module_Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	-------------------- LOCATING WEB ELEMENTS ------------------------------

	
	@FindBy(xpath = "//img[@src='/web/index.php/pim/viewPhoto/empNumber/7']")
	WebElement profileIconDropDown;

	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	WebElement logoutButton;
	
	@FindBy(css = "[class='oxd-button oxd-button--medium oxd-button--secondary']")
	WebElement addButton;

//	-------------------- GETTERS & SETTERS ------------------------------
	
	public void clickAddButton() {
		addButton.click();
	}
	
//	-------------------- BUSSINESS LOGIC ------------------------------
	

	public void performLogout() {
		profileIconDropDown.click();
		logoutButton.click();
		System.out.println("Logged Out successfully");
	}
}
