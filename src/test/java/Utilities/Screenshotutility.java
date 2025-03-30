package Utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotutility {

	static String formattedNow = null;
	static String path = "//src//test//resources//Screenshots//Screenshot";

	public static void takeScreenshot(WebDriver webdriver) {
		
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File screenshot = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(System.getProperty("user.dir") + path + currentDateTimeStamp() + ".png");
		try {
			FileUtils.copyFile(screenshot, DestFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String currentDateTimeStamp() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss");
		formattedNow = now.format(formatter);
		return formattedNow.toString().replace("+", "").replace("-", "").replace(":", "");
	}

}
