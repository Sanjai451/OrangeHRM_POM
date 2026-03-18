package com.orangeHRM.seleniumUI.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Recruitment_Module_Vacancy_Page {
	
	WebDriver driver = null;
	public Recruitment_Module_Vacancy_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[class=\"oxd-button oxd-button--medium oxd-button--secondary\"]")
	private WebElement addVacancyButton;
	
	public void clickAddVacancyButton() {
		addVacancyButton.click();
	}
}
