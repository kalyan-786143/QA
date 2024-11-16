package guru99bank.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import guru99bank.constants.CommonConstants;

public class DataReader {
	
	static Properties property;
	static FileInputStream propertyFile;
	
	public static String getPropertyFromKey(String key) {

		try {
			property = new Properties();
			propertyFile = new FileInputStream(CommonConstants.getDataFilePath());
		} catch (FileNotFoundException e) {
			System.out.println("Unable to locate data.properties file.");
		}
		try {
			property.load(propertyFile);
		} catch (IOException e) {
			System.out.println("Unable to open data.properties file.");
		}
		return property.getProperty(key);
	}

}
