package NotPartOfFramework;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Properties;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import Utilities.PropertiesReader;

public class UtilitiesDemo {

	public static Logger logger = Logger.getLogger("NotPartOfFramework.UtilitiesDemo");
	public static Properties properties = null;
	public static FileReader filereader = null;
	public static FileInputStream fileInputStream = null;

	@Test(priority = 1)
	public void propertiesReader() {

		PropertiesReader.properties.getProperty("baseURL");
		try {
			filereader = new FileReader(
					System.getProperty("user.dir") + "//src//test//resources//Configuration//URL.properties");
			properties = new Properties();
			properties.load(filereader);
			logger.info("Value of properties:" + properties.getProperty("baseURL"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public static Object[][] excelReader(String excelFileName, String sheetName) throws Exception {

		fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//TestData//Credentials.xlsx" );

		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int numberofRows = sheet.getPhysicalNumberOfRows();

		Object[][] testData = new Object[numberofRows][2];

		for (int i = 0; i < numberofRows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell userName = row.getCell(0);
			XSSFCell password = row.getCell(1);
			testData[i][0] = userName.getStringCellValue();
			testData[i][1] = password.getStringCellValue();

		}
		logger.info("TestData:"+testData);
		return testData;
		

	}

}
