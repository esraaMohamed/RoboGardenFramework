package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.JourneyConfiguration;
import configuration.LoginConfiguration;
import configuration.MissionConfiguration;
import configuration.RoadMapConfiguration;
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

	LoginConfiguration loginConfiguration;

	JourneyConfiguration journeyConfiguration;

	RoadMapConfiguration roadMapConfiguration;
	
	MissionConfiguration missionConfiguration;
	
	String username, password, journeyIndexNumber, missionIndexNumber, answerIndexNumber;
	
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
		missionConfiguration = new MissionConfiguration(missionPage, roadMapPage);
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
		journeyPage = loginConfiguration.validLogin(username, password);
		journeyIndexNumber = jsonTestData.getData("Journey").get("journeyIndexNumber");
		missionIndexNumber = jsonTestData.getData("MissionTextual").get("missionIndexNumber");
		answerIndexNumber = jsonTestData.getData("MissionTextual").get("answerIndexNumber");
	}
	
	@Test
	public void mcqMissionTest() throws InterruptedException {
		journeyConfiguration.clickTextualJourneysLink();
		roadMapPage = journeyConfiguration.clickPlayNowButtonByIndex(Integer.valueOf(journeyIndexNumber));
		roadMapConfiguration.closeHint();
		roadMapConfiguration.clickMission(Integer.valueOf(missionIndexNumber));
		missionConfiguration.generateModelAnswer();
        if (Integer.valueOf(missionIndexNumber) == 0)
		missionConfiguration.closeJavascriptPopup();
		missionConfiguration.selectAndSubmitJavascriptAnswer(Integer.valueOf(answerIndexNumber));
	}

}
