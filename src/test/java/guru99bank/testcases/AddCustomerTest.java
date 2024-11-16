package guru99bank.testcases;

import guru99bank.base.BaseTest;
import guru99bank.pages.AddCustomerPage;
import guru99bank.pages.CustomerRegisteredPage;
import guru99bank.pages.LoginPage;
import guru99bank.pages.ManagerHomePage;
import guru99bank.testdata.DataProviders;
import guru99bank.utilities.CommonMethods;
import guru99bank.utilities.DataReader;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AddCustomerTest extends BaseTest {
	
	private LoginPage loginPage;
	private ManagerHomePage managerHomePage;
	private AddCustomerPage addCustomerPage;
	private CustomerRegisteredPage customerRegisteredPage;

	@Test(priority = 1, description = "Test To Verify after clicking on New Customer, page redirects to Add New Customer page.")
	public void testToVerifyAddNewCustomerPage() {
		loginPage = new LoginPage(driver);
		managerHomePage = loginPage.performLogin(DataReader.getPropertyFromKey("validUserId"), DataReader.getPropertyFromKey("validPassword"));
		addCustomerPage = managerHomePage.clickAddCustomer();
		Assert.assertTrue(addCustomerPage.isPageDisplayed());
	}

	@Test(priority = 2, dataProvider = "AddNewCustomer", dataProviderClass = DataProviders.class, description = "Test To Verify after creating new Customer, page redirects to details of added customer")
	public void testToVerifyCustomerDetailsPage(String name, String gender, String dob, String Address, String City,
			String State, String pincode, String Mobile, String email, String password) {
		loginPage = new LoginPage(driver);
		managerHomePage = loginPage.performLogin(DataReader.getPropertyFromKey("validUserId"), DataReader.getPropertyFromKey("validPassword"));
		addCustomerPage = managerHomePage.clickAddCustomer();
		customerRegisteredPage = addCustomerPage.createNewCustomer(name, gender, dob, Address, City, State, pincode, Mobile, email, password);
		Assert.assertTrue(customerRegisteredPage.isPageDisplayed());
        CommonMethods.capturePageScreenshot("testToVerifyCustomerDetailsPage");
	}

	@Test(priority = 3, dataProvider = "VerifyCustomer", dataProviderClass = DataProviders.class, description = "Test To Verify after creating new Customer, page redirects to details of added customer")
	public void testToVerifyNewlyCreatedCustomerDetails(String name, String gender, String dob, String Address, String City, String State, String pincode, String Mobile, String email, String password) {
		loginPage = new LoginPage(driver);
		managerHomePage = loginPage.performLogin(DataReader.getPropertyFromKey("validUserId"), DataReader.getPropertyFromKey("validPassword"));
		addCustomerPage = managerHomePage.clickAddCustomer();
		customerRegisteredPage = addCustomerPage.createNewCustomer(name, gender, dob, Address, City, State, pincode, Mobile, email, password);
		Assert.assertTrue(customerRegisteredPage.isPageDisplayed());
		Assert.assertTrue(name.equalsIgnoreCase(customerRegisteredPage.getCustomerName()));
		Assert.assertTrue(gender.equalsIgnoreCase(customerRegisteredPage.getCustomerGender()));
        Assert.assertTrue(dob.equalsIgnoreCase(customerRegisteredPage.getCustomerDob()));
		Assert.assertTrue(Address.equalsIgnoreCase(customerRegisteredPage.getCustomerAddress()));
		Assert.assertTrue(City.equalsIgnoreCase(customerRegisteredPage.getCustomerCity()));
		Assert.assertTrue(State.equalsIgnoreCase(customerRegisteredPage.getCustomerState()));
		Assert.assertTrue(pincode.equalsIgnoreCase(customerRegisteredPage.getCustomerPin()));
		Assert.assertTrue(Mobile.equalsIgnoreCase(customerRegisteredPage.getCustomerMobileNo()));
        Assert.assertTrue(email.equalsIgnoreCase(customerRegisteredPage.getCustomerEmail()));
        CommonMethods.capturePageScreenshot("testToVerifyNewlyCreatedCustomerDetails");
	}
}
