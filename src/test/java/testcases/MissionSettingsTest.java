package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.JourneyConfiguration;
import configuration.LoginConfiguration;
import configuration.MissionSettingsConfiguration;
import configuration.RoadMapConfiguration;
import pageobjects.HomePageObject;
import pageobjects.JourneyPageObject;
import pageobjects.LoginPageObject;
import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class MissionSettingsTest extends BaseTest{

	LoginPageObject loginPage;

	HomePageObject homePage;

	JourneyPageObject journeyPage;

	RoadMapPageObject roadMapPage;

	MissionPageObject missionPage;

	LoginConfiguration loginConfiguration;

	JourneyConfiguration journeyConfiguration;

	RoadMapConfiguration roadMapConfiguration;
	
	MissionSettingsConfiguration missionSettingsConfiguration;
	
	String username, password, journeyIndexNumber;
	
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
		missionSettingsConfiguration = new MissionSettingsConfiguration(missionPage);
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
		journeyPage = loginConfiguration.validLogin(username, password);
		journeyIndexNumber = jsonTestData.getData("Journey").get("journeyIndexNumber");
	}
	
	/**
	 * Verifying mission description button is working properly
	 */
	@Test(priority = 1, enabled = true)
	public void missionDescriptionTest() throws InterruptedException {
		roadMapPage = journeyConfiguration.clickPlayNowButtonByIndex(Integer.valueOf(journeyIndexNumber));
		roadMapConfiguration.closeHint();
		roadMapConfiguration.clickFirstMission();
		missionSettingsConfiguration.clickMissionDescription();
		Assert.assertTrue(missionSettingsConfiguration.isMissionDescriptionPopupDisplayed());
	}
	
	/**
	 * Verifying load code button is working properly
	 */
	@Test(priority = 2, enabled = true)
	public void loadCodeButtonTest() {
		missionSettingsConfiguration.clickLoadCodeButton();
		Assert.assertTrue(missionPage.isLoadCodePopupDisplayed());
	}
	
	/**
	 * Verifying save code button is working properly
	 */
	@Test(priority = 3, enabled = true)
	public void saveCodeButtonTest() {
		missionSettingsConfiguration.clickSaveCodeButton();
		Assert.assertTrue(missionSettingsConfiguration.isSaveCodeErrorPopupDisplayed());
	}
	
	/**
	 * Verifying tour guide button is working properly
	 */
	@Test(priority = 4, enabled = true)
	public void tourGuideButtonTest() {
		missionSettingsConfiguration.clickTourGuideButton();
		Assert.assertTrue(missionSettingsConfiguration.isTourGuideDisplayed());
	}
	
	/**
	 * Verifying model answer button is working properly
	 */
	@Test(priority = 5, enabled = true)
	public void modelAnswerButtonTest() throws InterruptedException {
		missionSettingsConfiguration.clickModelAnswerButton();
		Assert.assertTrue(missionSettingsConfiguration.isModelAnswerCodeBlockDisplayed());
	}
	
	/**
	 * Verifying reset button is working properly
	 */
	@Test(priority = 6, enabled = true)
	public void resetButtonTest() {
		missionSettingsConfiguration.clickResetButton();
		Assert.assertTrue(missionSettingsConfiguration.isModelAnswerCodeNotDisplayed());
	}
}
