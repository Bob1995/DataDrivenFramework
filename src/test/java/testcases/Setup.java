package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Utilities.PropertiesReader;

public class Setup {

	public static WebDriver webdriver;

	@BeforeMethod
	public void navigateToURL() {
		webdriver = new ChromeDriver();
		PropertiesReader.readProperties("URL.properties");
		webdriver.get(PropertiesReader.properties.getProperty("baseURL"));
		Reporter.log("Launching Brower:" + PropertiesReader.properties.getProperty("baseURL"));
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	
	@AfterMethod
	public void closeBrowser() {
		webdriver.quit();

	}
}
