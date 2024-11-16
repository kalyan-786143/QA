package guru99bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import guru99bank.listeners.ReportListeners;

public class CustomerRegisteredPage {

	public WebDriver driver;

	@FindBy(xpath = "//p[@class='heading3']")
	WebElement customerRegisteredMsg;

	@FindBy(xpath = "//td[text()='Customer ID']")
	WebElement customerIdText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[4]/td[2]")
	WebElement customerId;

	@FindBy(xpath = "//td[text()='Customer Name']")
	WebElement customerNameText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[5]/td[2]")
	WebElement customerName;

	@FindBy(xpath = "//td[normalize-space()='Gender']")
	WebElement customerGenderText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[6]/td[2]")
	WebElement customerGender;

	@FindBy(xpath = "//td[normalize-space()='Birthdate']")
	WebElement customerDOBText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[7]/td[2]")
	WebElement customerDOB;

	@FindBy(xpath = "//td[normalize-space()='Address']")
	WebElement customerAddressText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[8]/td[2]")
	WebElement customerAddress;

	@FindBy(xpath = "//td[normalize-space()='City']")
	WebElement customerCityText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[9]/td[2]")
	WebElement customerCity;

	@FindBy(xpath = "//td[normalize-space()='State']")
	WebElement customerStateText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[10]/td[2]")
	WebElement customerState;

	@FindBy(xpath = "//td[normalize-space()='Pin']")
	WebElement customerPinText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[11]/td[2]")
	WebElement customerPin;

	@FindBy(xpath = "//td[normalize-space()='Mobile No.']")
	WebElement customerMobileText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[12]/td[2]")
	WebElement customerMobile;

	@FindBy(xpath = "//td[normalize-space()='Email']")
	WebElement customerEmailText;

	@FindBy(xpath = "//*[@id='customer']/tbody/tr[13]/td[2]")
	WebElement customerEmail;

	@FindBy(xpath = "//a[text()='Continue']")
	WebElement btnContinue;

	public CustomerRegisteredPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isPageDisplayed() {
    	try {
			ReportListeners.test.log(Status.PASS, "Customer registered message displayed.");
			System.out.println("Customer registered message displayed.");
			return customerRegisteredMsg.isDisplayed();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Customer registered page not displayed. Exception occured : " + e);
			System.out.println("Customer registered page not displayed. Exception occured : " + e);
			return false;
		}
	}

	public String getCustomerId() {
    	try {
			ReportListeners.test.log(Status.PASS, "Customer id displayed : " + customerId.getText());
			System.out.println("Customer id displayed : " + customerId.getText());
			return customerId.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer id. Exception occured : " + e);
			System.out.println("Unable to get Customer id. Exception occured : " + e);
			return "";
		}
	}

	public String getCustomerName() {
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

	public String getCustomerDob() {
    	try {
			ReportListeners.test.log(Status.PASS, "Customer date of birth displayed : " + customerDOB.getText());
			System.out.println("Customer date of birth displayed : " + customerDOB.getText());
			return customerDOB.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer date of bith. Exception occured : " + e);
			System.out.println("Unable to get Customer date of bith. Exception occured : " + e);
			return "";
		}
	}

	public String getCustomerGender() {
    	try {
			ReportListeners.test.log(Status.PASS, "Customer gender displayed : " + customerGender.getText());
			System.out.println("Customer gender displayed : " + customerGender.getText());
			return customerGender.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer gender. Exception occured : " + e);
			System.out.println("Unable to get Customer gender. Exception occured : " + e);
			return "";
		}
	}

	public String getCustomerAddress() {
    	try {
			ReportListeners.test.log(Status.PASS, "Customer address displayed : " + customerAddress.getText());
			System.out.println("Customer address displayed : " + customerAddress.getText());
			return customerAddress.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer address. Exception occured : " + e);
			System.out.println("Unable to get Customer address. Exception occured : " + e);
			return "";
		}
	}

	public String getCustomerCity() {
    	try {
			ReportListeners.test.log(Status.PASS, "Customer city displayed : " + customerCity.getText());
			System.out.println("Customer city displayed : " + customerCity.getText());
			return customerCity.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer city. Exception occured : " + e);
			System.out.println("Unable to get Customer city. Exception occured : " + e);
			return "";
		}
	}

	public String getCustomerState() {
    	try {
			ReportListeners.test.log(Status.PASS, "Customer state displayed : " + customerState.getText());
			System.out.println("Customer state displayed : " + customerState.getText());
			return customerState.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer state. Exception occured : " + e);
			System.out.println("Unable to get Customer state. Exception occured : " + e);
			return "";
		}
	}

	public String getCustomerPin() {
    	try {
			ReportListeners.test.log(Status.PASS, "Customer pin displayed : " + customerPin.getText());
			System.out.println("Customer pin displayed : " + customerPin.getText());
			return customerPin.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer pincode. Exception occured : " + e);
			System.out.println("Unable to get Customer pincode. Exception occured : " + e);
			return "";
		}
	}

	public String getCustomerMobileNo() {
		try {
			ReportListeners.test.log(Status.PASS, "Customer mobile displayed : " + customerMobile.getText());
			System.out.println("Customer mobile displayed : " + customerMobile.getText());
			return customerMobile.getText();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to get Customer mobile number. Exception occured : " + e);
			System.out.println("Unable to get Customer mobile number. Exception occured : " + e);
			return "";
		}
	}

	public String getCustomerEmail() {
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

	public ManagerHomePage clickContinue() {
    	try {
    		btnContinue.click();
			ReportListeners.test.log(Status.PASS, "Clicked on Continue button.");
			System.out.println("Clicked on Continue button.");
			return new ManagerHomePage(driver);
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Error occured while clicking on the Continue button. Exception occured : " + e);
			System.out.println("Error occured while clicking on the Continue button. Exception occured : " + e);
			return null;
		}
	}
	
}
