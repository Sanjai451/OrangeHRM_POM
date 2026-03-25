package demo_DDT_prac;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class LearningExtendReport {
	
	@Test
	public void practice() {
		ExtentReports extentReports = new ExtentReports();
		// Create Reporter 
		String filePath = "./reports/sample_extent_report.html";
		ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(filePath);
		
		extentReports.attachReporter(extentSparkReporter);
		
		ExtentTest ref = extentReports.createTest("GokulTest");
		
		ref.info("Started Execution");
		ref.pass("Test case passed");
		ref.fail("Steps failed successfully");
		
		extentReports.flush();
	}

}
