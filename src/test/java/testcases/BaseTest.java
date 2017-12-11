package testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import datareaders.JsonClass;
import utilities.CaptureScreenShotHandler;

public class BaseTest {
	public static WebDriver driver;
	public static JsonClass jsonTestData;
	public static String BaseURl;

	@BeforeSuite
	@Parameters({ "browser", "URL" })
	public void startDriver(@Optional("firefox") String WindowBrowser,
			@Optional("https://qc.rgp-dev.com/home") String URL) {
		jsonTestData = new JsonClass();
		if (WindowBrowser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") 
					+ File.separator + "resources"
					+ File.separator + "geckodriver");
			driver = new FirefoxDriver();
		}
		else if (WindowBrowser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.gecko.driver",
					System.getProperty("user.dir") 
					+ File.separator + "resources"
					+ File.separator + "geckodriver");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") 
					+ File.separator + "resources"
					+ File.separator + "chromedriver");
			driver = new ChromeDriver();
		}
		else if (WindowBrowser.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();

		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BaseURl = URL;
		driver.get(BaseURl);
	}

	@AfterSuite(alwaysRun=true)
	public void stopDriver() {
		driver.quit();
	}


	@AfterMethod
	public void screeshotOnFailure(ITestResult result){
		if (result.getStatus() == ITestResult.FAILURE) {
			CaptureScreenShotHandler.captureScreenshot(driver, result.getName());
		}
	}
}
