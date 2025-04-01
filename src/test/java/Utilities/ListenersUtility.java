package Utilities;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;

import testcases.Setup;

public class ListenersUtility extends Setup implements ITestListener {

	public void onTestFailure(ITestResult result) {
		Assert.assertTrue(false, result.getName());
		Screenshotutility.takeScreenshot(webdriver);
	}

	public void onTestSuccess(ITestResult result) {
		Assert.assertTrue(true, result.getName());
		Screenshotutility.takeScreenshot(webdriver);

	}

}
