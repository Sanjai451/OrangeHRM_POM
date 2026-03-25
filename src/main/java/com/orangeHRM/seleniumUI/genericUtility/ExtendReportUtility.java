package com.orangeHRM.seleniumUI.genericUtility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtility {
	
	public static ExtentReports extentReports;
	
	public static ExtentReports getExtendInstance() {
		if(extentReports == null) {			
			ExtentSparkReporter spark = new ExtentSparkReporter("./reports/test_result.html");
			spark.config().setReportName("OrangeHRM Automation UI Report");
			spark.config().setDocumentTitle("Test Results");
			extentReports = new ExtentReports();
			extentReports.attachReporter(spark);
			extentReports.setSystemInfo("Automation", "Spiderman");
			extentReports.setSystemInfo("UI Framework", "Selenium + TestNG");
		}
		return extentReports;
	}
}
