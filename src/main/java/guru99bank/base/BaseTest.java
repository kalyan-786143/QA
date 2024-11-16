package guru99bank.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import guru99bank.constants.CommonConstants;
import guru99bank.utilities.ConfigReader;

public class BaseTest {
	public static WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		String strBrowser = ConfigReader.getPropertyFromKey("browser");
		System.out.println("'" + strBrowser + "' browser selected for test.");
		String url = ConfigReader.getPropertyFromKey("url");
		System.out.println("Application under test : '" + url + "'.");
		
		if (strBrowser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (strBrowser.equalsIgnoreCase("Firefox")) {
			driver = new FirefoxDriver();
		} else if (strBrowser.equalsIgnoreCase("Edge")) {
			driver = new EdgeDriver();
		} else {
			System.out.println("Unsupported browser type mentioned in the config.properties file.");
			System.out.println("Edge browser selected for test as default.");
			driver = new EdgeDriver();
		}
		
		System.out.println("'" + strBrowser + "' browser initialized.");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonConstants.getImplicitWaitTime()));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonConstants.getPageLoadTimeOut()));
		driver.manage().window().maximize();
		driver.get(url);
		System.out.println("Navigated to url '" + url + "'.");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
		System.out.println("All '" + ConfigReader.getPropertyFromKey("browser") + "' browser instances closed.");
	}

}