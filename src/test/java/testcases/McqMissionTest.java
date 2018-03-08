package testcases;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import businesshandlers.JourneyBusinessHandler;
import businesshandlers.LoginBusinessHandler;
import businesshandlers.MissionBusinessHandler;
import businesshandlers.RoadMapBusinessHandler;
import pageobjects.HomePageObject;
import pageobjects.JourneyPageObject;
import pageobjects.LoginPageObject;
import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class McqMissionTest extends BaseTest{
	LoginPageObject loginPage;

	HomePageObject homePage;

	JourneyPageObject journeyPage;

	RoadMapPageObject roadMapPage;

	MissionPageObject missionPage;

	LoginBusinessHandler loginBusinessHandler;

	JourneyBusinessHandler journeyBusinessHandler;

	RoadMapBusinessHandler roadMapBusinessHandler;

	MissionBusinessHandler missionBusinessHandler;

	String username, password, journeyIndexNumber, missionIndexNumber, answerIndexNumber;

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
		missionBusinessHandler = new MissionBusinessHandler(missionPage, roadMapPage);
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
		journeyPage = loginBusinessHandler.validLogin(username, password);
		journeyIndexNumber = jsonTestData.getData("Journey").get("journeyIndexNumber");
		missionIndexNumber = jsonTestData.getData("MissionTextual").get("missionIndexNumber");
		answerIndexNumber = jsonTestData.getData("MissionTextual").get("answerIndexNumber");
	}

	@Test
	public void mcqMissionTest() throws InterruptedException {
		journeyBusinessHandler.clickTextualJourneysLink();
		roadMapPage = journeyBusinessHandler.clickPlayNowButtonByIndex(Integer.valueOf(journeyIndexNumber));
		roadMapBusinessHandler.closeHint();
		roadMapBusinessHandler.clickMission(Integer.valueOf(missionIndexNumber));
		missionBusinessHandler.generateModelAnswer();
		if (Integer.valueOf(missionIndexNumber) == 0)
		{
			missionBusinessHandler.closeJavascriptPopup();
		}
		missionBusinessHandler.selectAndSubmitJavascriptAnswer(Integer.valueOf(answerIndexNumber));
		Assert.assertTrue(missionBusinessHandler.checkSuccessPopupAppears());	
	}

}
