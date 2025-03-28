package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Setup {

	public static WebDriver webdriver;

	@BeforeTest
	public void navigateToURL() {
		WebDriverManager.chromedriver().setup();
		webdriver = new ChromeDriver();
		webdriver.get("https://practicetestautomation.com/practice-test-login/");
		webdriver.manage().window().maximize();

	}

	@AfterTest
	public void closeBrowser() {
		webdriver.quit();

	}
}
