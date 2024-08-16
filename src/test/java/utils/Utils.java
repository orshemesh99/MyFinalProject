package utils;

import java.util.Properties;
import java.io.InputStream;
import java.io.FileInputStream;

public class Utils {

	public static String readProperty(String key) {

		String value="";
		try (InputStream input = new FileInputStream("./src/test/java/data/configuration.properties")) {
			Properties prop = new Properties();
			// load a properties file
			prop.load(input);
			// get the property value and print it out
			value = prop.getProperty(key);

		} catch (Exception e) {		
		}
		return value;
	}
}
