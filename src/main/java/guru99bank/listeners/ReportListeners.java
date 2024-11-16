package guru99bank.listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import guru99bank.base.BaseTest;
import guru99bank.constants.CommonConstants;
import guru99bank.reports.ExtentReportManager;

public class ReportListeners implements ITestListener {

	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ITestContext context) {
		report = ExtentReportManager.setupExtentReport();
	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();
		File extentReport = new File(ExtentReportManager.extentReportFile);
		System.out.println("ExtentReport generated : " + ExtentReportManager.extentReportFile);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			System.out.println("Extent Report opened on the default browser.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getTestClass().getRealClass().getName() + " :: " +result.getMethod().getMethodName());
		test.log(Status.INFO, "Test case '" + result.getMethod().getMethodName() + "' execution started.");
		test.log(Status.INFO, "Test description -'" + result.getMethod().getDescription() + "'.");
		System.out.println("Execution of '" + result.getMethod().getMethodName() + "' test has started.");
		System.out.println("Test description -'" + result.getMethod().getDescription() + "'.");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case '" + result.getMethod().getMethodName() + "' execution passed.");
		Markup markup = MarkupHelper.createLabel("Test case '" + result.getMethod().getMethodName() + "' execution passed.", ExtentColor.GREEN);
		test.log(Status.PASS, markup);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test case '" + result.getMethod().getMethodName() + "' execution failed.");
		Markup markup = MarkupHelper.createLabel("Test case '" + result.getMethod().getMethodName() + "' execution failed.", ExtentColor.RED);
		test.log(Status.FAIL, markup);
		test.log(Status.FAIL, result.getThrowable());

		
		File source = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
		String fileName = "Screenshot_" + result.getMethod().getMethodName() + "_" + new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date()) + ".png";
		String destinationPath = CommonConstants.getScreenshotFilePath() + fileName;
		try {
			FileHandler.copy(source, new File(destinationPath));
		} catch (IOException e) {
			throw new RuntimeException("Error occured while copying screenshot to " + destinationPath);
		}
		test.addScreenCaptureFromPath(destinationPath);
		System.out.println("Screenshot captured : " + fileName);
		System.out.println("Exception occured : " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case '" + result.getMethod().getMethodName() + "' execution skipped.");
		System.out.println("Exception occured : " + result.getThrowable());
		Markup markup = MarkupHelper.createLabel("Test case '" + result.getMethod().getMethodName() + "' execution skipped.", ExtentColor.AMBER);
		test.log(Status.SKIP, markup);
		test.log(Status.SKIP, result.getThrowable());
	}
}
