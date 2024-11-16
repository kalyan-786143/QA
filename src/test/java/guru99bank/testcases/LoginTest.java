package guru99bank.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import guru99bank.base.BaseTest;
import guru99bank.pages.LoginPage;
import guru99bank.pages.ManagerHomePage;
import guru99bank.utilities.DataReader;

public class LoginTest extends BaseTest {

	private LoginPage loginPage;
	private ManagerHomePage managerHomePage;

	@Test(priority = 1, description = "Test To Verify Login With Valid UserId And Valid Password")
	public void testToVerifyLoginWithValidUserIdAndValidPassword() {
		loginPage = new LoginPage(driver);
		managerHomePage = loginPage.performLogin(DataReader.getPropertyFromKey("validUserId"), DataReader.getPropertyFromKey("validPassword"));
		Assert.assertEquals(managerHomePage.getPageTitle(), DataReader.getPropertyFromKey("managerHomePageTitle"));
		Assert.assertEquals(managerHomePage.getWelcomeMessage(), DataReader.getPropertyFromKey("managerHomePageWelcomeMessage"));
	}

	@Test(priority = 2, description = "Test To Verify after successful login, managers Id is displayed on managers home page")
	public void testToVerifyManagersIdOnHomePage() {
		loginPage = new LoginPage(driver);
		managerHomePage = loginPage.performLogin(DataReader.getPropertyFromKey("validUserId"), DataReader.getPropertyFromKey("validPassword"));
		Assert.assertEquals(managerHomePage.getManagerId(), DataReader.getPropertyFromKey("managersIdText") + DataReader.getPropertyFromKey("validUserId"));
	}

	@Test(priority = 3, description = "Test To Verify Login With In-Valid UserId And Valid Password")
	public void testToVerifyLoginWithInvalidUserIdAndValidPassword() {
		loginPage = new LoginPage(driver);
		loginPage.performLogin(DataReader.getPropertyFromKey("invalidUserId"), DataReader.getPropertyFromKey("validPassword"));
		Assert.assertTrue(loginPage.isAlertPresent());
		Assert.assertEquals(loginPage.getAlertText(), DataReader.getPropertyFromKey("inValidLoginAlertMessage"));
	}

	@Test(priority = 4, description = "Test To Verify Login With Valid UserId And In-Valid Password")
	public void testToVerifyLoginWithValidUserIdAndInvalidPassword() {
		loginPage = new LoginPage(driver);
		loginPage.performLogin(DataReader.getPropertyFromKey("validUserId"), DataReader.getPropertyFromKey("invalidPassword"));
		Assert.assertEquals(loginPage.getAlertText(), DataReader.getPropertyFromKey("inValidLoginAlertMessage"));
	}

	@Test(priority = 5, description = "Test To Verify Login With In-Valid UserId And In-Valid Password")
	public void testToVerifyLoginWithInvalidUserIdAndInvalidPassword() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.performLogin(DataReader.getPropertyFromKey("invalidUserId"), DataReader.getPropertyFromKey("invalidPassword"));
		Assert.assertEquals(loginPage.getAlertText(), DataReader.getPropertyFromKey("inValidLoginAlertMessage"));
	}
}
