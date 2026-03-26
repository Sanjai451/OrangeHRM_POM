package com.orangeHRM.seleniumUI.genericUtility;

import java.io.File;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class ScreenShotUtility {

	TakesScreenshot takesScreenshot;

	public ScreenShotUtility(WebDriver driver) {
		takesScreenshot = (TakesScreenshot) driver;
	}

	/*
	 * dest = "./reports/filename"
	 */
	public String takeScreenShot(String dest, String filename, FileExtension extension) {

		File tempScreenShotFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String extensionString = String.valueOf(extension).toLowerCase();

		String timeStamp = new SimpleDateFormat("yyyy-MM-DD hh-mm-ss").format(new Date());

		filename = filename + timeStamp;
		String path = dest + "/" + filename + "." + extensionString;
		// to store screen shot
		try {
			File permanent = new File(path);
			FileHandler.copy(tempScreenShotFile, permanent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Path : " + Paths.get(path).toAbsolutePath().toString());
		return Paths.get(path).toAbsolutePath().toString();
	}

	public void takeScreenShot(WebElement element, String dest, String filename, FileExtension extension) {

		File tempScreenShotFile = element.getScreenshotAs(OutputType.FILE);

		String extensionString = String.valueOf(extension).toLowerCase();

		String timeStamp = new SimpleDateFormat("yyyy-MM-DD hh-mm-ss").format(new Date());

		filename = filename + timeStamp;

		// to store screen shot
		try {
			File permanent = new File(dest + "/" + filename + "." + extensionString);
			FileHandler.copy(tempScreenShotFile, permanent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
