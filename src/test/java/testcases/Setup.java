package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import Utilities.PropertiesReader;

public class Setup {

	public static WebDriver webdriver;

	@BeforeTest
	public void navigateToURL() {
		webdriver = new ChromeDriver();
		PropertiesReader.readProperties("URL.properties");
		webdriver.get(PropertiesReader.properties.getProperty("baseURL"));
		Reporter.log("Launching Brower:"+ PropertiesReader.properties.getProperty("baseURL"));
		webdriver.manage().window().maximize();

	}

	@AfterTest
	public void closeBrowser() {
		webdriver.quit();

	}
}
