package Utilities;

import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	static FileInputStream fileInputStream = null;

	public static Object[][] excelReader(String excelFileName,String sheetName) throws Exception {

		fileInputStream = new FileInputStream(
				System.getProperty("user.dir") + "//src//test//resources//TestData//"+excelFileName);

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
		return testData;

	}
}
