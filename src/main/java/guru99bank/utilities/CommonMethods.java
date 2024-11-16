package guru99bank.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import guru99bank.base.BaseTest;
import guru99bank.constants.CommonConstants;

public class CommonMethods {
	
	public static void capturePageScreenshot(String methodName) {
		File source = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		System.out.println("Screenshot captured");
		File destination = new File(CommonConstants.getScreenshotFilePath()+ "Screenshot_" + methodName + "_" + CommonConstants.getDateTimeStamp() + ".png"); 
		try {
			FileHandler.copy(source, destination);
			System.out.println("Screenshot copied to " + CommonConstants.getScreenshotFilePath());
		} catch (IOException e) {
			System.out.println("Unable to copy screenshot file to '" + CommonConstants.getScreenshotFilePath() +"'. Error occured :" + e);
		}
	}

	public static String getTimeStamp() {
		return new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
	}
}
