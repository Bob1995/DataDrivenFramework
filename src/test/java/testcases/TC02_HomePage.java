package testcases;

import org.testng.annotations.Test;

import pageobjects.HomePageObjects;

public class TC02_HomePage extends Setup {

	HomePageObjects homePageObjects;

	@Test
	public void NavigateToHomePage() {
		homePageObjects = new HomePageObjects(webdriver);
		homePageObjects.clickOnHomeTab();
		homePageObjects.AssertHomePage();

	}

}
