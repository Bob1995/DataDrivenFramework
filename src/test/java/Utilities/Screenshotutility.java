package Utilities;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshotutility {

	static String formattedNow;

	public static void takeScreenshot(WebDriver webdriver) {
		TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
		File screenshot = scrShot.getScreenshotAs(OutputType.FILE);
		File DestFile = new File(
				System.getProperty("user.dir") + "//src//test//resources//Screenshots//Screenshot.png");
		try {
			FileUtils.copyFile(screenshot, DestFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void currentDateTimeStamp() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		formattedNow = now.format(formatter);
		System.out.println(formattedNow);
	}

}
