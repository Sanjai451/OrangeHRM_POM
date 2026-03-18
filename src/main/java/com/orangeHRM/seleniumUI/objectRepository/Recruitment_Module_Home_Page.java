package com.orangeHRM.seleniumUI.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recruitment_Module_Home_Page {
	
	WebDriver driver = null;
	public Recruitment_Module_Home_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Vacancies']")
	private WebElement vacancyPageButton;
	
	@FindBy(css = "[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	private WebElement addCandidatesButton;
	
	public void clickVacancyButton() {
		vacancyPageButton.click();
	}
	
	public void clickAddCandidateButton() {
		addCandidatesButton.click();
	}

}
