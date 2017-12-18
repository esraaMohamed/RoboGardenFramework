package testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.JourneyConfiguration;
import configuration.LoginConfiguration;
import configuration.RoadMapConfiguration;
import pageobjects.HomePageObject;
import pageobjects.JourneyPageObject;
import pageobjects.LoginPageObject;
import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class RegressionTest extends BaseTest{
	LoginPageObject loginPage;
	HomePageObject homePage;
	JourneyPageObject journeyPage;
	RoadMapPageObject roadMapPage;
	MissionPageObject missionPage;
	LoginConfiguration loginConfiguration;
	JourneyConfiguration journeyConfiguration;
	RoadMapConfiguration roadMapConfiguration;
	String username, password;
	List<String> failedTextAssertion , successTextAssertion;

	@BeforeTest
	public void init() {
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		journeyPage = new JourneyPageObject(driver);
		roadMapPage = new RoadMapPageObject(driver);
		missionPage = new MissionPageObject(driver);
		loginConfiguration = new LoginConfiguration(loginPage, homePage);
		journeyConfiguration = new JourneyConfiguration(journeyPage);
		roadMapConfiguration = new RoadMapConfiguration(roadMapPage, missionPage);
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
		failedTextAssertion = new ArrayList<String>();
		successTextAssertion = new ArrayList<String>();
		failedTextAssertion.add("Retry Mission");
		successTextAssertion.add("Go to next mission");
	}

	/**
	 * Verifying Regression Scenario functionality
	 * @throws InterruptedException 
	 */
	@Test(priority = 1)
	public void regression() throws InterruptedException {
		journeyPage = loginConfiguration.validLogin(username, password);
		roadMapPage = journeyConfiguration.clickPlayNowButton();
		roadMapConfiguration.closeHint();
		roadMapConfiguration.clickOnMission();
//		System.out.println(roadMapConfiguration.getFailedTextForAssertion().size());
//		System.out.println(failedTextAssertion.size());
		Assert.assertEquals(failedTextAssertion, roadMapConfiguration.getFailedTextForAssertion());
		Assert.assertEquals(successTextAssertion, roadMapConfiguration.getSuccessTextForAssertion());
	}
}
