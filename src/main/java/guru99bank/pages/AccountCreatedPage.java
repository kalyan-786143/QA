package guru99bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import guru99bank.listeners.ReportListeners;

public class AccountCreatedPage {
	
    public WebDriver driver;
    
    @FindBy(xpath="//p[@class='heading3']")
    WebElement accountGeneratedMsg;

    @FindBy(xpath="//td[normalize-space()='Account ID']")
    WebElement accountIdText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[4]/td[2]")
    WebElement accountId;

    @FindBy(xpath="//td[text()='Customer ID']")
    WebElement customerIdText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[5]/td[2]")
    WebElement customerId;

    @FindBy(xpath="//td[normalize-space()='Customer Name']")
    WebElement customerNameText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[6]/td[2]")
    WebElement customerName;

    @FindBy(xpath="//td[normalize-space()='Email']")
    WebElement customerEmailText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[7]/td[2]")
    WebElement customerEmail;

    @FindBy(xpath="//td[normalize-space()='Account Type']")
    WebElement customerAccountTypeText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[8]/td[2]")
    WebElement customerAccountType;

    @FindBy(xpath="//td[normalize-space()='Date of Opening']")
    WebElement customerDooText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[9]/td[2]")
    WebElement customerDoo;

    @FindBy(xpath="//td[normalize-space()='Current Amount']")
    WebElement customerCurrentAmtText;

    @FindBy(xpath="//*[@id='account']/tbody/tr[10]/td[2]")
    WebElement customerCurrentAmt;


    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageDisplayed(){
    	try {
			ReportListeners.test.log(Status.PASS, "Account created page displayed.");
			System.out.println("Account created page displayed.");
			return accountGeneratedMsg.isDisplayed();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Account created page not displayed. Exception occured : " + e);
			System.out.println("Account created page not displayed. Exception occured : " + e);
			return false;
		}
    }

    public String getAccountId(){
    	try {
			ReportListeners.test.log(Status.PASS, "Account id displayed : " + accountId.getText());
			System.out.println("Account id displayed : " + accountId.getText());
			return accountId.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Account Id. Exception occured : " + e);
			System.out.println("Unable to get Account Id. Exception occured : " + e);
			return "";
		}
    }

    public String getCustomerId(){
    	try {
			ReportListeners.test.log(Status.PASS, "Customer id displayed : " + customerId.getText());
			System.out.println("Customer id displayed : " + customerId.getText());
			return customerId.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer Id. Exception occured : " + e);
			System.out.println("Unable to get Customer Id. Exception occured : " + e);
			return "";
		}
    }

    public String getCustomerName(){
    	try {
			ReportListeners.test.log(Status.PASS, "Customer name displayed : " + customerName.getText());
			System.out.println("Customer name displayed : " + customerName.getText());
			return customerName.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer Name. Exception occured : " + e);
			System.out.println("Unable to get Customer Name. Exception occured : " + e);
			return "";
		}
    }

    public String getCustomerEmail(){
    	try {
			ReportListeners.test.log(Status.PASS, "Customer email displayed : " + customerEmail.getText());
			System.out.println("Customer email displayed : " + customerEmail.getText());
			return customerEmail.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer email. Exception occured : " + e);
			System.out.println("Unable to get Customer email. Exception occured : " + e);
			return "";
		}
    }

    public String getCustomerAccountType(){
    	try {
			ReportListeners.test.log(Status.PASS, "Customer account type displayed : " + customerAccountType.getText());
			System.out.println("Customer account type displayed : " + customerAccountType.getText());
			return customerAccountType.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer account type. Exception occured : " + e);
			System.out.println("Unable to get Customer account type. Exception occured : " + e);
			return "";
		}
    }

    public String getCustomerDoo(){
    	try {
			ReportListeners.test.log(Status.PASS, "Customer date of opening account displayed : " + customerDoo.getText());
			System.out.println("Customer date of opening account displayed : " + customerDoo.getText());
			return customerDoo.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer date of opening acccout. Exception occured : " + e);
			System.out.println("Unable to get Customer date of opening acccout. Exception occured : " + e);
			return "";
		}
    }

    public String getCustomerCurrentAmount(){
    	try {
			ReportListeners.test.log(Status.PASS, "Customer current account amount : " + customerCurrentAmt.getText());
			System.out.println("Customer current account amount : " + customerCurrentAmt.getText());
			return customerCurrentAmt.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer current amount. Exception occured : " + e);
			System.out.println("Unable to get Customer current amount. Exception occured : " + e);
			return "";
		}
    }

    public ManagerHomePage clickContinue(){
    	try {
			ReportListeners.test.log(Status.PASS, "Clicked on continue button.");
			System.out.println("Clicked on continue button.");
			return new ManagerHomePage(driver);
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Error occured while clicking on the Continue button. Exception occured : " + e);
			System.out.println("Error occured while clicking on the Continue button. Exception occured : " + e);
			return null;
		}
    }

}
