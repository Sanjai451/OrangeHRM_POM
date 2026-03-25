package com.orangeHRM.seleniumUI.objectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recruitment_Module_AddCandidate_Page {
	
	WebDriver driver = null;
	public Recruitment_Module_AddCandidate_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "firstName")
	private WebElement firstNameInput;
	
	@FindBy(name = "middleName")
	private WebElement middleNameInput;
	
	@FindBy(name = "lastName")
	private WebElement lastNameInput;
	
	@FindBy(xpath = "//label[text()='Vacancy']/../../div[2]/div/div/div")
    private WebElement vacancyDropdown;

    @FindBy(xpath = "//label[.='Email']/../..//input")
    private WebElement emailInput;

    @FindBy(xpath = "//label[.='Contact Number']/../..//input")
    private WebElement contactInput;

    @FindBy(xpath = "//input[@type='file']")
    private WebElement uploadResume;

    @FindBy(xpath = "//input[@placeholder='yyyy-dd-mm']")
    private WebElement dateInput;

    @FindBy(xpath = "//button[contains(., 'Save')]")
    private WebElement saveBtn;
    
 // ================= ACTION METHODS =================

    public void enterFirstName(String firstName) {
        firstNameInput.sendKeys(firstName);
    }

    public void enterMiddleName(String middleName) {
        middleNameInput.sendKeys(middleName);
    }

    public void enterLastName(String lastName) {
        lastNameInput.sendKeys(lastName);
    }

    public void selectVacancy() {
        vacancyDropdown.click();
        vacancyDropdown.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
    }

    public void enterEmail(String email) {
        emailInput.sendKeys(email);
    }

    public void enterContact(String contact) {
        contactInput.sendKeys(contact);
    }

    public void uploadResume(String filePath) {
        uploadResume.sendKeys(filePath);
    }

    public void enterDate(String date) {
        dateInput.sendKeys(Keys.CONTROL + "a");
        dateInput.sendKeys(Keys.BACK_SPACE);
        dateInput.sendKeys(date);
    }

    public void clickSave() {
        saveBtn.click();
    }

    // ================= BUSINESS METHOD =================
    public void addCandidate(String fName, String mName, String lName,
                             String email, String contact,
                             String filePath, String date) {

        enterFirstName(fName);
        enterMiddleName(mName);
        enterLastName(lName);
        selectVacancy();
        enterEmail(email);
        enterContact(contact);
        uploadResume(filePath);
        enterDate(date);
        clickSave();
    }
}
	

