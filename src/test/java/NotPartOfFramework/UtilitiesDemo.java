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
	public void excelReader() throws Exception {

		fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//TestData//Credentials.xlsx" );
		XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int numberofRows = sheet.getPhysicalNumberOfRows();



		for (int i = 1; i < numberofRows; i++) {
			XSSFRow row = sheet.getRow(i);
			XSSFCell userName = row.getCell(0);
			XSSFCell password = row.getCell(1);
			logger.info("Username:"+userName);
			logger.info("Password:"+password);
		}
		

	}

}
