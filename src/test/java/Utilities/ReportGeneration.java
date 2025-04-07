package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportGeneration {

	static ExtentHtmlReporter extenthtmlReporter = null;
	static ExtentReports extentReports = null;
	static ExtentTest extentTest = null;
	static String path = "//src//test//resources//ExtentReports//ExtentReports_";

	public static void extentReportGeneration(String scenarioName, String testCaseName, String testStep, String flag) {
		extenthtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + path + scenarioName + ".html");
		extentReports = new ExtentReports();
		extentReports.attachReporter(extenthtmlReporter);
		extentTest = extentReports.createTest(scenarioName, testCaseName);
		if (flag.equalsIgnoreCase("PASS") || flag.equalsIgnoreCase("Pass") || flag.equalsIgnoreCase("pass")) {
			extentTest.log(Status.PASS, testStep);
		} else if (flag.equalsIgnoreCase("FAIL") || flag.equalsIgnoreCase("fail") || flag.equalsIgnoreCase("fail")) {
			extentTest.log(Status.FAIL, testStep);
			
		}
		extentReports.flush();
	}

}
