package testcases;



import java.util.logging.Logger;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Utilities.ExcelDataDriven;
import pageobjects.LoginPageObjects;
@Listeners(Utilities.ListenersUtility.class)
public class TC01_Login extends Setup {

	Logger logger = Logger.getLogger("testcases.TC01_Login");
	
	LoginPageObjects loginPageobjects; 
	
			
	@Test(dataProvider = "DataDriven")
	public void VerifyLoginValidCredentials(String userName, String password) {
		logger.info("Verifying Login Valid credentials");
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
