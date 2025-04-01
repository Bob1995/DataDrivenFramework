package pageobjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
			Assert.assertTrue(true, "Home page loaded successfully");
			ReportGeneration.extentReportGeneration("Home Page", "Validate Home page", "Home Page loaded successfully",
					"PASS");
		}
	}
}
