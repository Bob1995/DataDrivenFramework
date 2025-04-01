package testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import pageobjects.HomePageObjects;

@Listeners(Utilities.ListenersUtility.class)
public class TC02_HomePage extends Setup {

	HomePageObjects homePageObjects;

	@Test
	public void NavigateToHomePage() {
		homePageObjects = new HomePageObjects(webdriver);
		homePageObjects.clickOnHomeTab();
		homePageObjects.AssertHomePage();

	}

}
