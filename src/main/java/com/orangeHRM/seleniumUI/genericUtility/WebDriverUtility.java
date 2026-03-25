package com.orangeHRM.seleniumUI.genericUtility;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

    WebDriver driver;

    public WebDriverUtility(WebDriver driver) {
        this.driver = driver;
    }

    // ================= WINDOW MANAGEMENT =================

    public void setMaximizeBrowser() {
        driver.manage().window().maximize();
    }

    public void setMinimizeBrowser() {
        driver.manage().window().minimize();
    }

    public void setFullscreenBrowser() {
        driver.manage().window().fullscreen();
    }

    public Dimension getSize() {
        return driver.manage().window().getSize();
    }

    public void setSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public Point getPosition() {
        return driver.manage().window().getPosition();
    }

    public void setPosition(int x, int y) {
        driver.manage().window().setPosition(new Point(x, y));
    }

    // ================= NAVIGATION =================

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }
    
    // ================= DETAILS =================
    
    public String getTitle() {
    	return driver.getTitle();
    }
    
    public String getUrl() {
    	return driver.getCurrentUrl();
    }
    
    // ================= TIMEOUTS =================

    public void implicitlyWait(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void pageLoadTimeout(int seconds) {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(seconds));
    }

    // ================= EXPLICIT WAIT =================

    public void waitForElementVisible(WebElement element, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForTitleContains(String title, int seconds) {
        new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.titleContains(title));
    }

    // ================= ALERT / POPUPS =================

    public void acceptPopup() {
        driver.switchTo().alert().accept();
    }

    public void dismissPopup() {
        driver.switchTo().alert().dismiss();
    }

    public String getPopupText() {
        return driver.switchTo().alert().getText();
    }
    
    public void printTextOnPopup() {
    	System.out.println(driver.switchTo().alert().getText());
    }

    public void sendTextToPopup(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    // ================= WINDOW HANDLES =================
    
    public void switchToWindowByTitle(String textTitle) {
    	Set<String> all = driver.getWindowHandles();
    	String currentWindowHandle = driver.getWindowHandle();
    	all.remove(currentWindowHandle);
    	
    	for(String window : all) {
    		driver.switchTo().window(window);
    		if(driver.getTitle().contains(textTitle)) {
    			break;
    		}
    	}    	  
    }
    
    public void switchToWindowByUrl(String url) {
    	Set<String> all = driver.getWindowHandles();
    	String currentWindowHandle = driver.getWindowHandle();
    	all.remove(currentWindowHandle);
    	
    	for(String window : all) {
    		driver.switchTo().window(window);
    		if(driver.getCurrentUrl().contains(url)) {
    			break;
    		}
    	}    	  
    }

    
    
    
    
    
    
    
    // ================= IFRAME =================

    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(String nameOrId) {
        driver.switchTo().frame(nameOrId);
    }

    public void switchToFrame(WebElement frameElement) {
        driver.switchTo().frame(frameElement);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
    
    public void switchControlToParentFrame() {
    	driver.switchTo().parentFrame();
    }
    
    public void switchControlToMainFrame() {
    	driver.switchTo().defaultContent();
    }


    // ================= CLOSE =================

    public void closeBrowser() {
        driver.close();
    }

    public void quitBrowser() {
        driver.quit();
    }
}