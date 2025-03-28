package testcases;

import org.testng.annotations.Test;

import pageobjects.LoginPageObjects;

public class TC01_Login extends Setup {

	LoginPageObjects loginPageobjects;

	@Test
	public void verifyLogin() {
		loginPageobjects=new LoginPageObjects(webdriver);
		loginPageobjects.enterUsername("student");
		loginPageobjects.enterPassword("Password123");
		loginPageobjects.clickOnLoginButton();

	}

}
