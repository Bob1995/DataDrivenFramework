package testcases;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import Utilities.PropertiesReader;

public class Setup {

	Logger logger = Logger.getLogger("testcases.Setup");
	public static WebDriver webdriver;

	@BeforeMethod
	public void navigateToURL() {
		
		ChromeOptions chromeOptions=new ChromeOptions();
		PropertiesReader.readProperties("ChromeOptions.properties");
		chromeOptions.addArguments(PropertiesReader.properties.getProperty("headlessFlag"));
		logger.info("Running browser in headless mode:"+PropertiesReader.properties.getProperty("headlessFlag"));
		webdriver = new ChromeDriver(chromeOptions);
		
		PropertiesReader.readProperties("URL.properties");
		webdriver.get(PropertiesReader.properties.getProperty("baseURL"));
		logger.info("Launching Brower:" + webdriver.getTitle());
		Assert.assertTrue(webdriver.getTitle().contains("Test Login | Practice Test Automation"), "Login Page is loaded successfully");
		
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void closeBrowser() {
		webdriver.quit();

	}
}
