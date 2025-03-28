package Utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	public void excelReader(String workbookName, String sheetName) {
		try {
			FileInputStream fileInputStream = new FileInputStream(
					System.getProperty("user.dir") + "//src//test//resources//TestData//" + workbookName);
			XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheetAt(0);
			Row headerRow = sheet.getRow(2);
			System.out.println(headerRow.getCell(1));
			System.out.println(headerRow.getCell(2));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
