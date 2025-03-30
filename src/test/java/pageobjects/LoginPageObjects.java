package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import Utilities.ReportGeneration;
import Utilities.Screenshotutility;

public class LoginPageObjects {

	WebDriver webdriver;
	By userNameTextBox = By.id("username");
	By passwordTextBox = By.id("password");
	By loginButton = By.id("submit");

	public LoginPageObjects(WebDriver webdriver) {
		// TODO Auto-generated constructor stub
		this.webdriver = webdriver;

	}

	public void enterUsername(String userName) {
		webdriver.findElement(userNameTextBox).sendKeys(userName);
		Screenshotutility.takeScreenshot(webdriver);
	}

	public void enterPassword(String password) {
		webdriver.findElement(passwordTextBox).sendKeys(password);
		Screenshotutility.takeScreenshot(webdriver);
	}

	public void clickOnLoginButton() {
		webdriver.findElement(loginButton).click();
		Screenshotutility.takeScreenshot(webdriver);
	}

	public void AssertLoginwithValidCredentials() {
		
		if (webdriver.getTitle().contains("Logged In Successfully | Practice Test Automation")) {
			ReportGeneration.extentReportGeneration("Student Login", "Login with valid credentials",
					"Login Page loaded successfully with valid credentials");
			Screenshotutility.takeScreenshot(webdriver);
		}

	}

}
