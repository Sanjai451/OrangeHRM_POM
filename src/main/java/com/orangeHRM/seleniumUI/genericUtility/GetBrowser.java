package com.orangeHRM.seleniumUI.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetBrowser {
	public static WebDriver getBrowser(String s) {
		return switch (s) {
			case "chrome" -> new ChromeDriver();
			case "edge" -> new EdgeDriver();
			case "firefox" -> new FirefoxDriver();
			default -> null;
		};
	}
}
