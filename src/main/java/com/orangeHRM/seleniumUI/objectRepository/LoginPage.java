package com.orangeHRM.seleniumUI.objectRepository;

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
	
//	-------------------- LOCATING WEB ELEMENTS ------------------------------
	
	@FindBy(name = "username")
 	private WebElement usernameInput;
	
	@FindBy(name = "password")
	private WebElement passwordInput;
	
	@FindBy(css = "[type='submit']")
	private WebElement loginButton;
	
	@FindBy(xpath = "//p[text()='Forgot your password? ']")
	private WebElement forgotPassword;
	
	@FindBy(xpath = "//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']")
	private WebElement linkedInButton;
	
	@FindBy(xpath = "//a[@href='https://www.facebook.com/OrangeHRM/']")
	private WebElement facebookButton;

	@FindBy(xpath = "//a[@href='https://twitter.com/orangehrm?lang=en']")
	private WebElement twitterButton;

	@FindBy(xpath = "https://www.youtube.com/c/OrangeHRMInc")
	private WebElement youtubeButton;
	
//	-------------------- GETTERS & SETTERS ------------------------------
	
	public WebElement getUsernameInput() {
		return usernameInput;
	}

	public void setUsernameInput(String username) {
		usernameInput.sendKeys(username);
	}

	public WebElement getPasswordInput() {
		return passwordInput;
	}

	public void setPasswordInput(String password) {
		passwordInput.sendKeys(password);
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void clickForgotPassword() {
		forgotPassword.click();
	}
	
	public void clickFacebook() {
		facebookButton.click();
	}
	
	public void clickyoutube() {
		youtubeButton.click();
	}
	
	public void clickTwitter() {
		twitterButton.click();
	}
	
	public void clickLinkedIn() {
		linkedInButton.click();
	}


//	-------------------- BUSINESS LOGICS ------------------------------
	
	public void enterURL(String url) {
		driver.get(url);
	}

	public void performLogin(String username, String password) {
		setUsernameInput(username);
		setPasswordInput(password);
		clickLoginButton();
	}
}
