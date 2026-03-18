package com.orangeHRM.seleniumUI.objectRepository;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recruitment_Module_AddVacancy_Page {

	WebDriver driver = null;
	Actions  actions = null;

	public Recruitment_Module_AddVacancy_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
	}

	@FindBy(css = "[class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	private WebElement saveButton;

	@FindBy(css = "[class='oxd-button oxd-button--medium oxd-button--ghost']")
	private WebElement cancelButton;

	@FindBy(xpath = "//label[text()='Vacancy Name']/../..//input")
	private WebElement vacancyNameInput;

	@FindBy(xpath = "//label[text()='Job Title']/../../div[2]/div/div/div")
	private WebElement jobTitleInput;

	@FindBy(tagName = "textarea")
	private WebElement descriptionInput;

	@FindBy(xpath = "//label[text()='Hiring Manager']/../..//input")
	private WebElement hiringManagerInput;

	@FindBy(xpath = "//label[text()='Number of Positions']/../..//input")
	private WebElement numberOfPositionInput;

//	@FindBy()
//	private WebElement activeToggle;
//
//	@FindBy()
//	private WebElement publishFeedToggle;

//	==================================================================================

	public void enterJobTitle() {
		actions
			.click(jobTitleInput)
			.pause(Duration.ofSeconds(3))
			.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER)
			.perform();
	}

	public void enterHiringManager() {
		actions
			.sendKeys(hiringManagerInput, "a")
			.pause(Duration.ofSeconds(5))
			.sendKeys(Keys.ARROW_DOWN, Keys.ENTER)
			.perform();
	}
	
	public void clickSaveButton() {
		saveButton.click();
	}
	
	public void sendVacancyName(String value) {
		vacancyNameInput.sendKeys(value);
	}
	
	public void sendDescription(String value) {
		descriptionInput.sendKeys(value);
	}
	
	public void sendNumberOfPositions(String value) {
		numberOfPositionInput.sendKeys(value);
	}
	
	public WebElement getJobTitleInput() {
		return jobTitleInput;
	}

	public WebElement getHiringManagerInput() {
		return hiringManagerInput;
	}

	public void fillCredentials(
			String vacancy,
			String description,
			String numberOfPosition
			) {
		sendVacancyName(vacancy);
		sendDescription(description);
		sendNumberOfPositions(numberOfPosition);
//		enterHiringManager();
//		enterJobTitle();
	}

}
