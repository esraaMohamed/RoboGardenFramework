package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.Dimension;
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
	static Logger logger;

	public enum BROWSERS{
		CHROME("Chrome"),
		FIREFOX("Firefox"),
		SAFARI("Safari");
		
		private final String browserName;

		private BROWSERS(String browserName) {
			this.browserName = browserName;
		}

		public String getBrowserName() {
			return browserName;
		}
	}

	public enum OS{
		MAC("Mac OS"),
		WIN("Windows"),
		LINUX("Linux");

		private final String osName;

		private OS(final String osName) {
			this.osName = osName;
		}

		public String getOsName() {
			return osName;
		}
	}

	@BeforeSuite
	@Parameters({ "browser", "URL" })
	public void startDriver(@Optional("firefox") String WindowBrowser, @Optional("https://automation.robogarden.ca") String URL) throws FileNotFoundException, IOException {
		jsonTestData = new JsonClass();

		String log4jConfigFile = System.getProperty("user.dir") + File.separator + "resources"
				+ File.separator + "log4j.properties";
		ConfigurationSource source = new ConfigurationSource(new FileInputStream(log4jConfigFile));
		Configurator.initialize(null, source);
		logger = Logger.getLogger(getClass());

		final String os = System.getProperty("os.name");
		final String userDirectory = System.getProperty("user.dir");

		if (WindowBrowser.equalsIgnoreCase(BROWSERS.FIREFOX.getBrowserName())) {
			final StringBuilder geckoDriverPath = new StringBuilder();
			geckoDriverPath.append(userDirectory + File.separator + "resources");
			if (os.contains(OS.MAC.toString())) {
				geckoDriverPath.append(File.separator + "mac" + File.separator + "geckodriver");
			} else if (os.contains(OS.WIN.toString())) {
				geckoDriverPath.append(File.separator + "win" + File.separator + "geckodriver.exe");
			}
			System.setProperty("webdriver.gecko.driver", geckoDriverPath.toString());
			driver = new FirefoxDriver();
		} else if (WindowBrowser.equalsIgnoreCase(BROWSERS.CHROME.getBrowserName())) {
			final StringBuilder chromeDriverPath = new StringBuilder();
			chromeDriverPath.append(userDirectory + File.separator + "resources");
			if (os.contains(OS.MAC.toString())) {
				chromeDriverPath.append(File.separator + "mac" + File.separator + "chromedriver");
			} else if (os.contains(OS.WIN.toString())) {
				chromeDriverPath.append(File.separator + "win" + File.separator + "chromedriver.exe");
			}
			final StringBuilder geckoDriverPath = new StringBuilder();
			geckoDriverPath.append(userDirectory + File.separator + "resources");
			if (os.contains(OS.MAC.toString())) {
				geckoDriverPath.append(File.separator + "mac" + File.separator + "geckodriver");
			} else if (os.contains(OS.WIN.toString())) {
				geckoDriverPath.append(File.separator + "win" + File.separator + "geckodriver.exe");
			}
			System.setProperty("webdriver.gecko.driver", geckoDriverPath.toString());
			System.setProperty("webdriver.chrome.driver", chromeDriverPath.toString());
			driver = new ChromeDriver();
		} else if (WindowBrowser.equalsIgnoreCase(BROWSERS.SAFARI.getBrowserName())) {
			driver = new SafariDriver();

		}
		driver.manage().window().setSize(new Dimension(1440, 844));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		BaseURl = URL;
		driver.get(BaseURl);
	}

	@AfterSuite(alwaysRun = true)
	public void stopDriver() {
		driver.quit();
	}

	@AfterMethod
	public void screeshotOnFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			CaptureScreenShotHandler.captureScreenshot(driver, result.getName());
		}
	}
}
