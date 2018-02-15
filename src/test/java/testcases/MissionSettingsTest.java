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

	String username, password, journeyIndexNumber, missionIndexNumber;

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
		missionIndexNumber = jsonTestData.getData("MissionTextual").get("missionIndexNumber");
	}

	/**
	 * Verifying mission description button is working properly
	 */
	@Test(priority = 1, enabled = true)
	public void missionDescriptionTest() throws InterruptedException {
		roadMapPage = journeyConfiguration.clickPlayNowButtonByIndex(Integer.valueOf(journeyIndexNumber));
		roadMapConfiguration.closeHint();
		roadMapConfiguration.clickMission(Integer.valueOf(missionIndexNumber));
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

	/**
	 * Verifying decor checkbox is working properly
	 * @throws InterruptedException 
	 */
	@Test(priority = 7, enabled = true)
	public void decorCheckboxTest() throws InterruptedException {
		missionSettingsConfiguration.clickDecorCheckbox();
		Assert.assertTrue(missionSettingsConfiguration.isDecorCheckboxChecked());
	}

	/**
	 * Verifying dots checkbox is working properly
	 */
	@Test(priority = 8, enabled = true)
	public void dotsCheckboxTest() {
		missionSettingsConfiguration.clickDotsCheckbox();
		Assert.assertTrue(missionSettingsConfiguration.isDotsCheckboxChecked());
	}

	/**
	 * Verifying keep code checkbox is working properly
	 */
	@Test(priority = 9, enabled = true)
	public void keepCodeCheckboxTest() {
		missionSettingsConfiguration.clickKeepCodeCheckbox();
		Assert.assertTrue(missionSettingsConfiguration.isKeepCodeCheckboxChecked());
	}

	/**
	 * Verifying toggle sound checkbox is working properly
	 */
	@Test(priority = 10, enabled = true)
	public void toogleSoundCheckboxTest() {
		missionSettingsConfiguration.clickToggleSoundCheckbox();
		Assert.assertTrue(missionSettingsConfiguration.isToggleSoundCheckboxUnchecked());
	}

	/**
	 * Verifying opacity slider is working properly
	 */
	@Test(priority = 11, enabled = true)
	public void opacitySliderTest() {
		missionSettingsConfiguration.moveOpacitySlider();
		Assert.assertTrue(missionSettingsConfiguration.checkIfOpacityChanged());
	}
}
