package com.orangeHRM.seleniumUI.genericUtility;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionUtility {
	Actions actions;
	public ActionUtility(Actions actions) {
		this.actions = actions;
	}
	
	public Actions manageSearchAndWait(WebElement element, String value, int seconds) {
		return actions
			.sendKeys(element, value)
			.pause(Duration.ofSeconds(seconds));
	}
	
	public Actions manageClickAndWait(WebElement element, int seconds) {
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
}
