package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.JourneyConfiguration;
import configuration.LoginConfiguration;
import pageobjects.HomePageObject;
import pageobjects.JourneyPageObject;
import pageobjects.LoginPageObject;
import pageobjects.RoadMapPageObject;

public class RegressionTest extends BaseTest{
	LoginPageObject loginPage;
	HomePageObject homePage;
	JourneyPageObject journeyPage;
	RoadMapPageObject roadMapPage;
	LoginConfiguration loginConfiguration;
	JourneyConfiguration journeyConfiguration;
	String username, password;

	@BeforeTest
	public void init() {
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		journeyPage = new JourneyPageObject(driver);
		roadMapPage = new RoadMapPageObject(driver);
		loginConfiguration = new LoginConfiguration(loginPage, homePage);
		journeyConfiguration = new JourneyConfiguration(journeyPage);
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
	}

	/**
	 * Verifying Regression Scenario functionality
	 */
	@Test(priority = 1)
	public void regression() {
		journeyPage = loginConfiguration.validLogin(username, password);
		roadMapPage = journeyConfiguration.clickPlayNowButton();
	}
}
