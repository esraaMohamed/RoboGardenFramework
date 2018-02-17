package testcases;

import static org.testng.Assert.assertTrue;

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
        boolean isMissionDescriptionPopupDisplayed = missionSettingsConfiguration.clickMissionDescription();
        Assert.assertTrue(isMissionDescriptionPopupDisplayed);
    }

    /**
	 * Verifying load code button is working properly
	 */
    @Test(priority = 2, enabled = true)
    public void loadCodeButtonTest() {
        boolean isLoadCodePopupDisplayed = missionSettingsConfiguration.clickLoadCodeButton();
        Assert.assertTrue(isLoadCodePopupDisplayed);
    }

	/**
	 * Verifying save code button is working properly
	 */
	@Test(priority = 3, enabled = true)
	public void saveCodeButtonTest() {
		boolean isSaveCodeErrorPopupDisplayed =  missionSettingsConfiguration.clickSaveCodeButton();
		Assert.assertTrue(isSaveCodeErrorPopupDisplayed);
	}

	/**
	 * Verifying tour guide button is working properly
	 * @throws InterruptedException 
	 */
	@Test(priority = 4, enabled = true)
	public void tourGuideButtonTest() throws InterruptedException {
		boolean isTourGuideDisplayed = missionSettingsConfiguration.clickTourGuideButton();
		Assert.assertTrue(isTourGuideDisplayed);
	}

	/**
	 * Verifying model answer button is working properly
	 */
	@Test(priority = 5, enabled = true)
	public void modelAnswerButtonTest() throws InterruptedException {
	    boolean isModelAnswerCodeBlockDisplayed = missionSettingsConfiguration.clickModelAnswerButton();
		Assert.assertTrue(isModelAnswerCodeBlockDisplayed);
	}
	
    /**
     * Verifying zoom in is working properly 
     */
    @Test(priority = 6, enabled = true)
    public void zoomInTest() throws InterruptedException {
        assertTrue(missionSettingsConfiguration.clickZoomIn());
    }

    /**
     * Verifying zoom out is working properly
     */
    @Test(priority = 7, enabled = true)
    public void zoomOutTest() throws InterruptedException {
        assertTrue(missionSettingsConfiguration.clickZoomOut());
    }

    /**
     * Verifying zoom reset is working properly
     */
    @Test(priority = 8, enabled = true)
    public void zoomResetTest() throws InterruptedException {
        assertTrue(missionSettingsConfiguration.clickZoomReset());
    }
    
    /**
     * Verifying delete code is working properly
     * @throws InterruptedException
     */
    @Test(priority = 9, enabled = true)
    public void removeCodeTest() throws InterruptedException {
        boolean isCodeNotDisplayed =  missionSettingsConfiguration.removeCode();
        Assert.assertTrue(isCodeNotDisplayed);
    }

    /**
     * Verifyibg run button is working properly
     * 
     * @throws InterruptedException
     */
    @Test(priority = 10, enabled = true)
    public void runButtonTest() throws InterruptedException {
        Assert.assertFalse(missionSettingsConfiguration.clickRunButton());
    }

    /**
     * Verifying pause button is working properly
     * 
     * @throws InterruptedException
     */
    @Test(priority = 11, enabled = true)
    public void pauseButtonTest() throws InterruptedException {
        Assert.assertFalse(missionSettingsConfiguration.clickPauseButton());
    }

    /**
     * Verifying continue button is working properly
     * 
     * @throws InterruptedException
     */
    @Test(priority = 12, enabled = true)
    public void continueButtonTest() throws InterruptedException {
        Assert.assertFalse(missionSettingsConfiguration.clickContinueButton());
    }

    /**
     * Verifying stop button is working properly
     * 
     * @throws InterruptedException
     */
    @Test(priority = 13, enabled = true)
    public void stopButtonTest() throws InterruptedException {
        Assert.assertFalse(missionSettingsConfiguration.clickStopButton());
    }
	
	/**
     * Verifying reset button is working properly
     * @throws InterruptedException 
     */
    @Test(priority = 14, enabled = true)
    public void resetButtonTest() throws InterruptedException {
        boolean isModelAnswerCodeNotDisplayed = missionSettingsConfiguration.clickResetButton();
        Assert.assertTrue(isModelAnswerCodeNotDisplayed);
    }

	/**
	 * Verifying decor checkbox is working properly
	 * @throws InterruptedException 
	 */
	@Test(priority = 15, enabled = true)
	public void decorCheckboxTest() throws InterruptedException {
		boolean isDecorCheckboxChecked = missionSettingsConfiguration.clickDecorCheckbox();
		Assert.assertTrue(isDecorCheckboxChecked);
	}

	/**
	 * Verifying dots checkbox is working properly
	 */
	@Test(priority = 16, enabled = true)
	public void dotsCheckboxTest() {
		boolean isDotsCheckboxChecked = missionSettingsConfiguration.clickDotsCheckbox();
		Assert.assertTrue(isDotsCheckboxChecked);
	}

	/**
	 * Verifying keep code checkbox is working properly
	 */
	@Test(priority = 17, enabled = true)
	public void keepCodeCheckboxTest() {
		boolean isKeepCodeCheckboxChecked = missionSettingsConfiguration.clickKeepCodeCheckbox();
		Assert.assertTrue(isKeepCodeCheckboxChecked);
	}

	/**
	 * Verifying toggle sound checkbox is working properly
	 */
	@Test(priority = 18, enabled = true)
	public void toogleSoundCheckboxTest() {
		boolean isToggleSoundCheckboxUnchecked = missionSettingsConfiguration.clickToggleSoundCheckbox();
		Assert.assertTrue(isToggleSoundCheckboxUnchecked);
	}

	/**
	 * Verifying opacity slider is working properly
	 */
	@Test(priority = 19, enabled = true)
	public void opacitySliderTest() {
		boolean checkIfOpacityChanged = missionSettingsConfiguration.moveOpacitySlider();
		Assert.assertTrue(checkIfOpacityChanged);
	}
}
