package com.orangeHRM.seleniumUI.genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ListenerImplementation implements ITestListener {
//	ExtentReports extentReports = new ExtentReports();
//	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/listener_report.html");
//	ExtentTest test;
	
	ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	
	ExtentReports extentReports = ExtendReportUtility.getExtendInstance();
	
	@Override
	public void onTestStart(ITestResult result) {
		ExtentTest t = extentReports.createTest(result.getMethod().getMethodName());
		test.set(t);
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.get().pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
//		WebDriver driver = new EdgeDriver();
		
		Object object = result.getInstance();
		BaseClass baseClass = (BaseClass)object;
		WebDriver driver = baseClass.driver;
		
		ScreenShotUtility screenShotUtility = new ScreenShotUtility(driver);

		test.get().fail("Test Failed");
		test.get().fail(result.getThrowable());
		
		try {Thread.sleep(4000);} catch (Exception e) {}
		
		String path = screenShotUtility.takeScreenShot("./reports", result.getMethod().getMethodName(), FileExtension.PNG);
		test.get().addScreenCaptureFromPath(path);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.get().skip("Test has been skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
	
}
