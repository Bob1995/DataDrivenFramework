package testcases;

import java.util.logging.Logger;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageobjects.HomePageObjects;

@Listeners(Utilities.ListenersUtility.class)
public class TC02_HomePage extends Setup {

	HomePageObjects homePageObjects;
	Logger logger = Logger.getLogger("testcases.TC02_HomePage");
	@Test
	public void verifyHomePage() {
		logger.info("Verifying home page");
		homePageObjects = new HomePageObjects(webdriver);
		homePageObjects.clickOnHomeTab();
		homePageObjects.AssertHomePage();

	}

}
