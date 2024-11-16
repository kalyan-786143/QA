package guru99bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import guru99bank.listeners.ReportListeners;

public class LoginPage {

	public WebDriver driver;

	@FindBy(name = "uid")
	WebElement userid;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(name = "btnLogin")
	WebElement btnLogin;

	@FindBy(xpath = "//input[@name='btnReset']")
	WebElement btnReset;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isPageDisplayed() {
		try {
			ReportListeners.test.log(Status.PASS, "Login page displayed.");
			System.out.println("Login page displayed.");
			return btnLogin.isDisplayed() && btnReset.isDisplayed();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Login page not displayed. Exception occured : " + e);
			System.out.println("Login page not displayed. Exception occured : " + e);
			return false;
		}
	}

	public ManagerHomePage performLogin(String strUsername, String strPassword) {
		try {
			userid.clear();
			userid.sendKeys(strUsername);
			ReportListeners.test.log(Status.PASS, "Entered text '" + strUsername + "' in the userid field.");
			System.out.println("Entered text '" + strUsername + "' in the userid field.");
			password.clear();
			password.sendKeys(strPassword);
			ReportListeners.test.log(Status.PASS, "Entered text '" + strPassword + "' in the password field.");
			System.out.println("Entered text '" + strPassword + "' in the password field.");
			btnLogin.click();
			ReportListeners.test.log(Status.PASS, "Clicked on Login button.");
			System.out.println("Clicked on Login button.");
			return new ManagerHomePage(driver);
		} catch (Exception e) {
			System.out.println("Error occured while performing login."  + e);
			return null;
		}
	}

	public Alert getAlert() {
		try {
			ReportListeners.test.log(Status.PASS, "Switching to alert.");
			System.out.println("Switching to alert.");
			return driver.switchTo().alert();
		} catch (NoAlertPresentException e) {
			ReportListeners.test.log(Status.FAIL, "Unable to switch to alert. Exception occured : " + e);
			System.out.println("Unable to switch to alert. Exception occured : " + e);
			return null;
		}
	}

	public boolean isAlertPresent() {
		try {
			ReportListeners.test.log(Status.PASS, "Alert is present.");
			System.out.println("Alert is present.");
			return (driver.switchTo().alert() != null);
		} catch (NoAlertPresentException e) {
			ReportListeners.test.log(Status.FAIL, "Alert not found. Exception occured : " + e);
			System.out.println("Alert not found. Exception occured : " + e);
			return false;
		}
	}

	public String getAlertText() {
		try {
			driver.switchTo().alert().getText();
			ReportListeners.test.log(Status.PASS, "Text on the Alert popup is : " + driver.switchTo().alert().getText());
			System.out.println("Text on the Alert popup is : " + driver.switchTo().alert().getText());
			return driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Alert text. Exception occured : " + e);
			System.out.println("Unable to get Alert text. Exception occured : " + e);
			return "";
		}
	}

	public void acceptAlert() {
		try {
			driver.switchTo().alert().accept();
			ReportListeners.test.log(Status.PASS, "Alert accepted.");
			System.out.println("Alert accepted.");
		} catch (NoAlertPresentException e) {
			ReportListeners.test.log(Status.FAIL, "Unable to accept Alert. Exception occured : " + e);
			System.out.println("Unable to accept Alert. Exception occured : " + e);
		}
	}

}
