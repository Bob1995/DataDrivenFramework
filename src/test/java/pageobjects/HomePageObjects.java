package pageobjects;

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
			ReportGeneration.extentReportGeneration("Home Page", "Validate Home page",
					"Validate Home Page loaded successfully");
		}

	}
}
