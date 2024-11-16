package guru99bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import guru99bank.listeners.ReportListeners;

public class AddCustomerPage {

	public WebDriver driver;

	@FindBy(xpath = "//p[@class='heading3']")
	WebElement addCustomerText;

	@FindBy(xpath = "//input[@name='name']")
	WebElement customerName;

	@FindBy(xpath = "//input[@value='m']")
	WebElement custGenderMale;

	@FindBy(xpath = "//input[@value='f']")
	WebElement custGenderFemale;

	@FindBy(id = "dob")
	WebElement custDob;
	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement custAddress;

	@FindBy(xpath = "//input[@name='city']")
	WebElement custCity;

	@FindBy(xpath = "//input[@name='state']")
	WebElement custState;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement custPin;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement custMobileNumber;

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement custEmail;

	@FindBy(xpath = "//input[@name='password']")
	WebElement custPassword;

	@FindBy(xpath = "//input[@name='sub']")
	WebElement btnSubmit;

	@FindBy(xpath = "//input[@name='res']")
	WebElement btnReset;

	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isPageDisplayed() {
    	try {
			ReportListeners.test.log(Status.PASS, "Add Customer page is displayed.");
			System.out.println("Add Customer page is displayed.");
			return addCustomerText.isDisplayed();
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Add Customer page not displayed. Exception occured : " + e);
			System.out.println("Add Customer page not displayed. Exception occured : " + e);
			return false;
		}
	}

	public CustomerRegisteredPage createNewCustomer(String name, String gender, String dob, String address, String city, String state, String pincode, String mobile, String email, String password) {
		try {
			customerName.sendKeys(name);
			ReportListeners.test.log(Status.PASS,"Entered text '" + name +"' in the customer name field." );
			System.out.println("Entered text '" + name +"' in the customer name field." );
			if (gender.equalsIgnoreCase("male")) {
				custGenderMale.click();	
				ReportListeners.test.log(Status.PASS,"Selected Male as gender.");
				System.out.println("Selected Male as gender.");
			} else if (gender.equalsIgnoreCase("female")) {
				custGenderFemale.click();
				ReportListeners.test.log(Status.PASS,"Selected Female as gender.");
				System.out.println("Selected Female as gender.");
			}
			custDob.sendKeys(dob.split("-")[2]);
			custDob.sendKeys(dob.split("-")[1]);
			custDob.sendKeys(dob.split("-")[0]);
			ReportListeners.test.log(Status.PASS,"Entered text '" + dob.split("-")[2] + "-" + dob.split("-")[1] + "-" + dob.split("-")[0] + "' in the dob field." );		
			System.out.println("Entered text '" + dob.split("-")[2] + "-" + dob.split("-")[1] + "-" + dob.split("-")[0] + "' in the dob field." );		
			custAddress.sendKeys(address);
			ReportListeners.test.log(Status.PASS,"Entered text '" + address +"' in the address field." );
			System.out.println("Entered text '" + address +"' in the address field." );
			custCity.sendKeys(city);
			ReportListeners.test.log(Status.PASS,"Entered text '" + city +"' in the city field." );
			System.out.println("Entered text '" + city +"' in the city field." );
			custState.sendKeys(state);
			ReportListeners.test.log(Status.PASS,"Entered text '" + state +"' in the state field." );
			System.out.println("Entered text '" + state +"' in the state field." );
			custPin.sendKeys(pincode);
			ReportListeners.test.log(Status.PASS,"Entered text '" + pincode +"' in the pincode field." );
			System.out.println("Entered text '" + pincode +"' in the pincode field." );
			custMobileNumber.sendKeys(mobile);
			ReportListeners.test.log(Status.PASS,"Entered text '" + mobile +"' in the mobile field." );
			System.out.println("Entered text '" + mobile +"' in the mobile field." );
			custEmail.sendKeys(email);
			ReportListeners.test.log(Status.PASS,"Entered text '" + email +"' in the email field." );
			System.out.println("Entered text '" + email +"' in the email field." );
			custPassword.sendKeys(password);
			ReportListeners.test.log(Status.PASS,"Entered text '" + password +"' in the password field." );
			System.out.println("Entered text '" + password +"' in the password field." );
			btnSubmit.click();
			ReportListeners.test.log(Status.PASS,"Clicked on Submit button." );
			System.out.println("Clicked on Submit button." );
			return new CustomerRegisteredPage(driver);
		} catch (Exception e) {
			ReportListeners.test.log(Status.FAIL, "Unable to create new Customer. Exception occured : " + e);
			System.out.println("Unable to create new Customer. Exception occured : " + e);
			return null;
		}
	}
}
