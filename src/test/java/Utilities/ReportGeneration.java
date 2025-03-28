package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ReportGeneration {
	
	static ExtentHtmlReporter extenthtmlReporter=null;
	static ExtentReports extentReports=null;
	static ExtentTest extentTest=null;
	
	public static void extentReportGeneration(String scenarioName,String testCaseName,String testStep)
	{
		extenthtmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"//src//test//resources//ExtentReports//report.html");
		extentReports=new ExtentReports();
		extentReports.attachReporter(extenthtmlReporter);
		extentTest=extentReports.createTest(scenarioName,testCaseName);
		extentTest.log(Status.PASS, testStep);
		extentReports.flush();
	}

}
