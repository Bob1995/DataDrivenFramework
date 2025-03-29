package testcases;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.ExcelDataDriven;
import pageobjects.HomePageObjects;
import pageobjects.LoginPageObjects;

public class TC01_Login extends Setup {

	LoginPageObjects loginPageobjects;


	@Test(dataProvider = "DataDriven")
	public void VerifyLoginValidCredentials(String userName, String password) {
		loginPageobjects = new LoginPageObjects(webdriver);
		loginPageobjects.enterUsername(userName);
		loginPageobjects.enterPassword(password);
		loginPageobjects.clickOnLoginButton();
		loginPageobjects.AssertLoginwithValidCredentials();

	}
	


	@DataProvider(name = "DataDriven")
	public Object[][] testDataGenerator() throws Exception {
		Object[][] testdata = ExcelDataDriven.excelReader("Credentials.xlsx", "sheet1");
		return testdata;
	}

}
