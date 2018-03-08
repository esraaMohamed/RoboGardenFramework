package testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import businesshandlers.JourneyBusinessHandler;
import businesshandlers.LoginBusinessHandler;
import businesshandlers.MissionSettingsBusinessHandler;
import businesshandlers.RoadMapBusinessHandler;
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

	LoginBusinessHandler loginBusinessHandler;

	JourneyBusinessHandler journeyBusinessHandler;

	RoadMapBusinessHandler roadMapBusinessHandler;

	MissionSettingsBusinessHandler missionSettingsBusinessHandler;

	String username, password, journeyIndexNumber, missionIndexNumber, snippetName;

	@BeforeTest
	public void init() {
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		journeyPage = new JourneyPageObject(driver);
		roadMapPage = new RoadMapPageObject(driver);
		missionPage = new MissionPageObject(driver);
		loginBusinessHandler = new LoginBusinessHandler(loginPage, homePage);
		journeyBusinessHandler = new JourneyBusinessHandler(journeyPage);
		roadMapBusinessHandler = new RoadMapBusinessHandler(roadMapPage, missionPage);
		missionSettingsBusinessHandler = new MissionSettingsBusinessHandler(missionPage);
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
		journeyPage = loginBusinessHandler.validLogin(username, password);
		journeyIndexNumber = jsonTestData.getData("Journey").get("journeyIndexNumber");
		missionIndexNumber = jsonTestData.getData("MissionTextual").get("missionIndexNumber");
		snippetName = jsonTestData.getData("CodeSnippetName").get("snippetName");
	}
	
	/**
	 * Verifying mission description button is working properly
	 */
    @Test(priority = 1, enabled = true)
    public void missionDescriptionTest() throws InterruptedException {
        roadMapPage = journeyBusinessHandler.clickPlayNowButtonByIndex(Integer.valueOf(journeyIndexNumber));
        roadMapBusinessHandler.closeHint();
        roadMapBusinessHandler.clickMission(Integer.valueOf(missionIndexNumber));
        boolean isMissionDescriptionPopupDisplayed = missionSettingsBusinessHandler.clickMissionDescription();
        Assert.assertTrue(isMissionDescriptionPopupDisplayed);
    }
    /**
	 * Verifying save code button is working properly
     * @throws InterruptedException 
	 */
	@Test(priority = 2, enabled = true)
	public void saveCodeButtonTest() throws InterruptedException {
		missionSettingsBusinessHandler.clickModelAnswerButton();
		boolean isSaveCodeErrorPopupDisplayed =  missionSettingsBusinessHandler.clickSaveCodeButton(snippetName);
		Assert.assertTrue(isSaveCodeErrorPopupDisplayed);
	}

    /**
	 * Verifying load code button is working properly
	 */
    @Test(priority = 3, enabled = true)
    public void loadCodeButtonTest() {
        boolean isLoadCodePopupDisplayed = missionSettingsBusinessHandler.clickLoadCodeButton(snippetName);
        Assert.assertTrue(isLoadCodePopupDisplayed);
    }
    
    /**
	 * Verifying delete loaded code button is working properly
	 */
    @Test(priority = 4, enabled = true)
    public void deleteLoadedCodeButtonTest() {
        boolean isDeleteCodeSuccessPopupDisplayed = missionSettingsBusinessHandler.clickDeleteSavedCode(snippetName);
        Assert.assertTrue(isDeleteCodeSuccessPopupDisplayed);
    }

	/**
	 * Verifying tour guide button is working properly
	 * @throws InterruptedException 
	 */
	@Test(priority = 5, enabled = true)
	public void tourGuideButtonTest() throws InterruptedException {
		boolean isTourGuideDisplayed = missionSettingsBusinessHandler.clickTourGuideButton();
		Assert.assertTrue(isTourGuideDisplayed);
	}

	/**
	 * Verifying model answer button is working properly
	 */
	@Test(priority = 6, enabled = true)
	public void modelAnswerButtonTest() throws InterruptedException {
	    boolean isModelAnswerCodeBlockDisplayed = missionSettingsBusinessHandler.clickModelAnswerButton();
		Assert.assertTrue(isModelAnswerCodeBlockDisplayed);
	}
	
    /**
     * Verifying zoom in is working properly 
     */
    @Test(priority = 7, enabled = true)
    public void zoomInTest() throws InterruptedException {
        assertTrue(missionSettingsBusinessHandler.clickZoomIn());
    }

    /**
     * Verifying zoom out is working properly
     */
    @Test(priority = 8, enabled = true)
    public void zoomOutTest() throws InterruptedException {
        assertTrue(missionSettingsBusinessHandler.clickZoomOut());
    }

    /**
     * Verifying zoom reset is working properly
     */
    @Test(priority = 9, enabled = true)
    public void zoomResetTest() throws InterruptedException {
        assertTrue(missionSettingsBusinessHandler.clickZoomReset());
    }
    
    /**
     * Verifying delete code is working properly
     * @throws InterruptedException
     */
    @Test(priority = 10, enabled = true)
    public void removeCodeTest() throws InterruptedException {
        boolean isCodeNotDisplayed =  missionSettingsBusinessHandler.removeCode();
        Assert.assertTrue(isCodeNotDisplayed);
    }

    /**
     * Verifyibg run button is working properly
     * 
     * @throws InterruptedException
     */
    @Test(priority = 11, enabled = true)
    public void runButtonTest() throws InterruptedException {
        Assert.assertFalse(missionSettingsBusinessHandler.clickRunButton());
    }

    /**
     * Verifying pause button is working properly
     * 
     * @throws InterruptedException
     */
    @Test(priority = 12, enabled = true)
    public void pauseButtonTest() throws InterruptedException {
        Assert.assertFalse(missionSettingsBusinessHandler.clickPauseButton());
    }

    /**
     * Verifying continue button is working properly
     * 
     * @throws InterruptedException
     */
    @Test(priority = 13, enabled = true)
    public void continueButtonTest() throws InterruptedException {
        Assert.assertFalse(missionSettingsBusinessHandler.clickContinueButton());
    }

    /**
     * Verifying stop button is working properly
     * 
     * @throws InterruptedException
     */
    @Test(priority = 14, enabled = true)
    public void stopButtonTest() throws InterruptedException {
        Assert.assertFalse(missionSettingsBusinessHandler.clickStopButton());
    }
	
	/**
     * Verifying reset button is working properly
     * @throws InterruptedException 
     */
    @Test(priority = 15, enabled = true)
    public void resetButtonTest() throws InterruptedException {
        boolean isModelAnswerCodeNotDisplayed = missionSettingsBusinessHandler.clickResetButton();
        Assert.assertTrue(isModelAnswerCodeNotDisplayed);
    }

	/**
	 * Verifying decor checkbox is working properly
	 * @throws InterruptedException 
	 */
	@Test(priority = 16, enabled = true)
	public void decorCheckboxTest() throws InterruptedException {
		boolean isDecorCheckboxChecked = missionSettingsBusinessHandler.clickDecorCheckbox();
		Assert.assertTrue(isDecorCheckboxChecked);
	}

	/**
	 * Verifying dots checkbox is working properly
	 */
	@Test(priority = 17, enabled = true)
	public void dotsCheckboxTest() {
		boolean isDotsCheckboxChecked = missionSettingsBusinessHandler.clickDotsCheckbox();
		Assert.assertTrue(isDotsCheckboxChecked);
	}

	/**
	 * Verifying keep code checkbox is working properly
	 */
	@Test(priority = 18, enabled = true)
	public void keepCodeCheckboxTest() {
		boolean isKeepCodeCheckboxChecked = missionSettingsBusinessHandler.clickKeepCodeCheckbox();
		Assert.assertTrue(isKeepCodeCheckboxChecked);
	}

	/**
	 * Verifying toggle sound checkbox is working properly
	 */
	@Test(priority = 19, enabled = true)
	public void toogleSoundCheckboxTest() {
		boolean isToggleSoundCheckboxUnchecked = missionSettingsBusinessHandler.clickToggleSoundCheckbox();
		Assert.assertTrue(isToggleSoundCheckboxUnchecked);
	}

	/**
	 * Verifying opacity slider is working properly
	 */
	@Test(priority = 20, enabled = true)
	public void opacitySliderTest() {
		boolean checkIfOpacityChanged = missionSettingsBusinessHandler.moveOpacitySlider();
		Assert.assertTrue(checkIfOpacityChanged);
	}
}
