package guru99bank.constants;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonConstants {

	private final static int IMPLICITWAITTIME = 10;
	private final static int PAGELOADTIMEOUT = 10;

	private static String DATETIMESTAMP = new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date());

	private final static String projectDirectory = System.getProperty("user.dir");
	private final static String RESOURCES_FILEPATH = System.getProperty("user.dir") + "\\src\\test\\resources";
	private final static String CONFIG_FILEPATH = RESOURCES_FILEPATH + "\\properties\\config.properties";
	private final static String DATA_FILEPATH = RESOURCES_FILEPATH + "\\properties\\data.properties";
	private final static String LOG4J_FILEPATH = RESOURCES_FILEPATH +  "\\properties\\log4j.properties";
	private static final String SCREENSHOT_FILEPATH = projectDirectory + "\\Screenshots\\";
	private static final String EXTENTREPORT_FILEPATH = projectDirectory + "\\Reports\\";
	
	private static final String SCREENSHOT_FILENAME = "Screenshot_" + CommonConstants.getDateTimeStamp() + ".png";

	public static String getScreenshotFilePath() {
		return SCREENSHOT_FILEPATH;
	}

	public static String getExtentReportFilepath() {
		return EXTENTREPORT_FILEPATH;
	}
	
	public static String getDataFilePath() {
		return DATA_FILEPATH;
	}
	
	public static String getConfigFilePath() {
		return CONFIG_FILEPATH;
	}

	public static String getDateTimeStamp() {
		return DATETIMESTAMP;
	}
	
	public static String getScreenshotFileName() {
		return SCREENSHOT_FILENAME;
	}

	public static int getImplicitWaitTime() {
		return IMPLICITWAITTIME;
	}

	public static int getPageLoadTimeOut() {
		return PAGELOADTIMEOUT;
	}

	public static String getLog4jFilePath() {
		return LOG4J_FILEPATH;
	}	

}
