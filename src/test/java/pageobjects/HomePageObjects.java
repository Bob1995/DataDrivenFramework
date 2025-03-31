package pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Utilities.ReportGeneration;

public class HomePageObjects {

	WebDriver webdriver;
	By helloText = By.xpath("//h1[text()='Hello']");
	By homeText = By.xpath("//a[text()='Home']");

	public HomePageObjects(WebDriver webdriver) {
		this.webdriver = webdriver;
	}

	public void clickOnHomeTab() {
		webdriver.findElement(homeText).click();

	}

	public void AssertHomePage() {
		WebElement homePageText = webdriver.findElement(helloText);
		if (homePageText.isDisplayed()) {
			assertTrue(true,"Home page loaded successfully");
			ReportGeneration.extentReportGeneration("Home Page", "Validate Home page",
					"Home Page loaded successfully", "PASS");
			
		} else {
			assertEquals(false, "Home page loading failed");
			ReportGeneration.extentReportGeneration("Home Page", "Validate Home page",
					"Home Page loading failed", "fail");
		}

	}
}
