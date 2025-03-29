package testcases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.helpers.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.LoginPageObjects;

public class TC01_Login extends Setup {

	LoginPageObjects loginPageobjects;

	@Test(dataProvider = "DataDriven")
	public void testCaseLogin(String userName, String password) {
		loginPageobjects = new LoginPageObjects(webdriver);
		System.out.println("UserName:"+userName);
		System.out.println("Password:"+password);
		loginPageobjects.enterUsername(userName);
		loginPageobjects.enterPassword(password);
		loginPageobjects.clickOnLoginButton();
		loginPageobjects.validateLogin();

	}

	@DataProvider(name = "DataDriven")
	public Object[][] testDataGenerator() throws Exception {
		FileInputStream fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//TestData//Credentials.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		// Get first/desired sheet from the workbook
		XSSFSheet sheet = workbook.getSheetAt(0);
		int numberofRows = sheet.getPhysicalNumberOfRows();
		
		Object[][] testData = new Object[numberofRows][2];

		for (int i = 0; i < numberofRows; i++) {
			Reporter.info("Number of rows"+numberofRows);
			XSSFRow row = sheet.getRow(i);
			XSSFCell userName = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = userName.getStringCellValue();
			testData[i][1] = password.getStringCellValue();

		}
		return testData;
	}

}
