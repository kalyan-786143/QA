package guru99bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import guru99bank.listeners.ReportListeners;

public class AddAccountPage {
	
	public WebDriver driver;

	@FindBy(xpath = "//p[@class='heading3']")
	WebElement addAccountText;
	@FindBy(xpath = "//input[@name='cusid']")
	WebElement customerId;
	@FindBy(xpath = "//select[@name='selaccount']")
	WebElement customerAccountType;
	@FindBy(xpath = "//input[@name='inideposit']")
	WebElement initialDeposit;
	@FindBy(xpath = "//input[@name='button2']")
	WebElement btnSubmit;
	@FindBy(xpath = "//input[@name='reset']")
	WebElement btnReset;
	@FindBy(xpath = "//a[normalize-space()='Home']")
	WebElement btnHome;

	public AddAccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isPageDisplayed() {
		try {
			ReportListeners.test.log(Status.PASS, "Add Account page is displayed.");
			System.out.println("Add Account page is displayed.");
			return addAccountText.isDisplayed();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Add Account page not displayed. Exception occured : " + e);
			System.out.println("Add Account page not displayed. Exception occured : " + e);
			return false;
		}
	}

	public AccountCreatedPage createNewAccount(String custId, String accountType, String depositAmt) {
		try {
			customerId.sendKeys(custId);
			ReportListeners.test.log(Status.PASS, "Entered text '" + custId + "' in the customer id field.");
			System.out.println("Entered text '" + custId + "' in the customer id field.");
			if (accountType.equalsIgnoreCase("Savings")) {
				Select accType = new Select(customerAccountType);
				accType.selectByValue(accountType);
				ReportListeners.test.log(Status.PASS, accountType + " selected from from customer account type dropdown.");
				System.out.println(accountType + " selected from from customer account type dropdown.");
			} else if (accountType.equalsIgnoreCase("Current")) {
				Select accType = new Select(customerAccountType);
				accType.selectByValue(accountType);
				ReportListeners.test.log(Status.PASS, accountType + " selected from from customer account type dropdown.");
				System.out.println(accountType + " selected from from customer account type dropdown.");
			}
			initialDeposit.sendKeys(depositAmt);
			ReportListeners.test.log(Status.PASS, "Entered text '" + depositAmt + "' in the initial amount field.");
			System.out.println("Entered text '" + depositAmt + "' in the initial amount field.");
			btnSubmit.click();
			ReportListeners.test.log(Status.PASS, "Clicked on Submit button.");
			System.out.println("Clicked on Submit button.");
			return new AccountCreatedPage(driver);
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to create new Account. Exception occured : " + e);
			System.out.println("Unable to create new Account. Exception occured : " + e);
			return null;
		}

	}
}
