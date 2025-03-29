package Utilities;

import java.io.FileReader;
import java.util.Properties;

public class PropertiesReader {

	public static Properties properties = null;
	public static FileReader filereader=null;

	public static void readProperties(String propertyFileName){
		try {
			filereader = new FileReader(
					System.getProperty("user.dir") + "//src//test//resources//Configuration//" + propertyFileName);
			properties = new Properties();
			properties.load(filereader);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
