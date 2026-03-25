package com.orangeHRM.seleniumUI.genericUtility;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {
	Actions actions;
	WebDriver driver;
	
	@Deprecated
	public ActionUtility(Actions actions) {
		this.actions = actions;
	}
	
	public ActionUtility(WebDriver driver) {
		this.driver = driver;
		actions = new Actions(driver);
	}
	
	public void clickOnElements(WebElement element) {
		actions.moveToElement(element).click().perform();
	}
	
	public void sendKeysToElement(WebElement element, String text) {
		actions.moveToElement(element).click().sendKeys(text).perform();
	}
	
	public Actions performSearchAndWait(WebElement element, String value, int seconds) {
		return actions
			.click()
			.sendKeys(element, value)
			.pause(Duration.ofSeconds(seconds));
	}
	
	public Actions performClickAndWait(WebElement element, int seconds) {
		return actions
			.click(element)
			.pause(Duration.ofSeconds(seconds));
	}
	
	public Actions performKeyDown(int times) {
		for(int i=0; i<times; i++) {
			actions.keyDown(Keys.ARROW_DOWN);
		}
		return actions;
	}
	
	public Actions performEnter() {
		return actions.sendKeys(Keys.ENTER);
	}
	
	public void performDoubleClick(WebElement element) {
		actions.doubleClick(element).perform();
	}
	
//	--------------- COMBINED LOGIC ------------------------------------
	public void navigateSelectAutoSuggestionDropDown(WebElement element, int keyDownTimes) {
		performClickAndWait(element, 5);
		performKeyDown(keyDownTimes);
		performEnter().perform();
	}
	
	public void navigateTypeAutoSuggestionDropDown(
				WebElement element, 
				String searchText,
				int keyDownCount,
				int waitTime				
			) {
		performSearchAndWait(element, searchText, waitTime);
		performKeyDown(keyDownCount);
		performEnter().perform();
	}
}
