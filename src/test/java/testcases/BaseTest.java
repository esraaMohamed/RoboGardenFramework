package testcases;

import java.io.File;
import java.util.concurrent.TimeUnit;

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

    @BeforeSuite
    @Parameters({ "browser", "URL" })
    public void startDriver(@Optional("firefox") String WindowBrowser, @Optional("https://automation.robogarden.ca") String URL) {
        jsonTestData = new JsonClass();
        final String os = System.getProperty("os.name");
        final String userDirectory = System.getProperty("user.dir");
        if (WindowBrowser.equalsIgnoreCase("firefox")) {
            final StringBuilder geckoDriverPath = new StringBuilder();
            geckoDriverPath.append(userDirectory + File.separator + "resources");
            if (os.contains("Mac OS")) {
                geckoDriverPath.append(File.separator + "mac" + File.separator + "geckodriver");
            } else if (os.contains("Windows")) {
                geckoDriverPath.append(File.separator + "win" + File.separator + "geckodriver.exe");
            }
            System.setProperty("webdriver.gecko.driver", geckoDriverPath.toString());
            driver = new FirefoxDriver();
        } else if (WindowBrowser.equalsIgnoreCase("chrome")) {
            final StringBuilder chromeDriverPath = new StringBuilder();
            chromeDriverPath.append(userDirectory + File.separator + "resources");
            if (os.contains("Mac OS")) {
                chromeDriverPath.append(File.separator + "mac" + File.separator + "chromedriver");
            } else if (os.contains("Windows")) {
                chromeDriverPath.append(File.separator + "win" + File.separator + "chromedriver.exe");
            }
            final StringBuilder geckoDriverPath = new StringBuilder();
            geckoDriverPath.append(userDirectory + File.separator + "resources");
            if (os.contains("Mac OS")) {
                geckoDriverPath.append(File.separator + "mac" + File.separator + "geckodriver");
            } else if (os.contains("Windows")) {
                geckoDriverPath.append(File.separator + "win" + File.separator + "geckodriver.exe");
            }
            System.setProperty("webdriver.gecko.driver", geckoDriverPath.toString());
            System.setProperty("webdriver.chrome.driver", chromeDriverPath.toString());
            driver = new ChromeDriver();
        } else if (WindowBrowser.equalsIgnoreCase("safari")) {
            driver = new SafariDriver();

        }
        // driver.manage().window().maximize();
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
