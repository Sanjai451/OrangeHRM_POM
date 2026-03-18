package com.orangeHRM.seleniumUI.objectRepository;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PIM_Module_AddEmp_Page {
	WebDriver driver;

	public PIM_Module_AddEmp_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	-------------------- LOCATING WEB ELEMENTS ------------------------------

	@FindBy(name = "firstName")
	WebElement firstNameInput;
	
	@FindBy(name = "middleName")
	WebElement middleNameInput;
	
	@FindBy(name = "lastName")
	WebElement lastNameInput;
	
	@FindBy(xpath = "//label[.='Employee Id']/../..//input")
	WebElement employeeIdInput;
	
	@FindBy(xpath = "//button[contains(., 'Save')]")
	WebElement saveButton;

	@FindBy(xpath = "//a[@href='/web/index.php/auth/logout']")
	WebElement logoutButton;
	
	@FindBy(xpath = "//label[.='Username']/../..//input")
	WebElement userNameInput;
	
	@FindBy(xpath = "//label[.='Password']/../..//input")
	WebElement passwordInput;
	
	@FindBy(xpath = "//label[.='Confirm Password']/../..//input")
	WebElement confirmPasswordInput;
	
	@FindBy(css = "[class='oxd-switch-input oxd-switch-input--active --label-right']")
	WebElement addLoginToggle;

//	-------------------- GETTERS & SETTERS ------------------------------
	
	public void setFirstName(String firstname) {
		firstNameInput.sendKeys(firstname);
	}
	public void setLastName(String lastname) {
		lastNameInput.sendKeys(lastname);
	}
	public void setMiddleName(String middlename) {
		middleNameInput.sendKeys(middlename);
	}
	
	public void setUsername(String username) {
		userNameInput.sendKeys(username);
	}
	public void setPassword(String password) {
		passwordInput.sendKeys(password);
	}
	public void setConfirmPassword(String password) {
		confirmPasswordInput.sendKeys(password);
	}
	public void setEmployeeId(String empId) {
		employeeIdInput.sendKeys(empId);
	}
	public void clickSaveButton() {
		saveButton.click();
	}
	public void clickAddEmployeeToggle() {
		addLoginToggle.click();
	}
	
	
//	-------------------- BUSSINESS LOGIC ------------------------------
	
	public void addEmployee(String firstName, 
							String middleName, 
							String lastName, 
							String employeeId, 
							String username,
							String password
							) {
		// wait until element is visible
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(firstNameInput));
		
		setFirstName(firstName);
		setLastName(lastName);
		setMiddleName(middleName);
		setEmployeeId(employeeId);
		
		// click toggle button
		wait.until(ExpectedConditions.visibilityOf(addLoginToggle));
		
		try {Thread.sleep(3000);} catch (Exception e) {}
		
		clickAddEmployeeToggle();
		
		createCredentials(username, password);
		
		clickSaveButton();
	}
	public void createCredentials(String username,
							String password) {
		setUsername(username);
		setPassword(password);
		setConfirmPassword(password);
	}

}
