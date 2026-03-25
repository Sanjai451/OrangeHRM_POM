package demo_DDT_prac;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.orangeHRM.seleniumUI.genericUtility.FileExtension;
import com.orangeHRM.seleniumUI.genericUtility.ScreenShotUtility;

public class ListenerImplementationD implements ITestListener{
	
	ExtentReports extentReports = new ExtentReports();
	ExtentSparkReporter sparkReporter = new ExtentSparkReporter("./reports/listener_report.html");
	ExtentTest test;
	WebDriver driver = new EdgeDriver();
	ScreenShotUtility screenShotUtility = new ScreenShotUtility(driver);
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extentReports.createTest(result.getMethod().getMethodName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		test.pass("Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.fail("Test Failed");
		test.fail(result.getThrowable());
		screenShotUtility.takeScreenShot("./reports", result.getMethod().getMethodName(), FileExtension.PNG);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test.skip("Test has been skipped");
	}
	
	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
	}
	
}
