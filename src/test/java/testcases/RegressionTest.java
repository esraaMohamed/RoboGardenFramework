package testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import businesshandlers.JourneyBusinessHandler;
import businesshandlers.LoginBusinessHandler;
import businesshandlers.RoadMapBusinessHandler;
import pageobjects.HomePageObject;
import pageobjects.JourneyPageObject;
import pageobjects.LoginPageObject;
import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class RegressionTest extends BaseTest {

	LoginPageObject loginPage;

	HomePageObject homePage;

	JourneyPageObject journeyPage;

	RoadMapPageObject roadMapPage;

	MissionPageObject missionPage;

	LoginBusinessHandler loginBusinessHandler;

	JourneyBusinessHandler journeyBusinessHandler;

	RoadMapBusinessHandler roadMapBusinessHandler;

	String username, password, journeyIndexNumber;

	int journeyCount;

	List<String> failedMissions;

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
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
		journeyIndexNumber = jsonTestData.getData("Journey").get("journeyIndexNumber");
		failedMissions = new ArrayList<String>();
	}

	/**
	 * Verifying Regression Scenario for specific journey functionality
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 1, enabled = true)
	public void regressionForSpecificJourney() throws InterruptedException {
		journeyPage = loginBusinessHandler.validLogin(username, password);
		roadMapPage = journeyBusinessHandler.clickPlayNowButtonByIndex(Integer.valueOf(journeyIndexNumber));
		roadMapBusinessHandler.closeHint();
		roadMapBusinessHandler.clickOnMission();
		failedMissions = roadMapBusinessHandler.getFailedTextForAssertion();
		if (failedMissions.size() > 0) {
			System.out.println("Failed missions are:");
			for (int i = 0; i < failedMissions.size(); i++) {
				logger.error("Failed Mission number: "+failedMissions.get(i) +" , in method "+ new Object(){}.getClass().getEnclosingMethod().getName());
			}
			Assert.fail("There are errors in testing missions");
		}
	}

	/**
	 * Verifying Regression Scenario for all journeys functionality
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 2, enabled = false)
	public void regressionForAllJourneys() throws InterruptedException {
		journeyPage = loginBusinessHandler.validLogin(username, password);
		journeyCount = journeyBusinessHandler.journeyCount();
		for (int i = 0; i < journeyCount; i++) {
			System.out.println("Journey no. "+(i+1));
			roadMapPage = journeyBusinessHandler.clickPlayNowButtonByIndex(i);
			if (i == 0)
				roadMapBusinessHandler.closeHint();
			roadMapBusinessHandler.clickOnMission();
			roadMapBusinessHandler.clickJourneyButton();
		}
		failedMissions = roadMapBusinessHandler.getFailedTextForAssertion();
		if (failedMissions.size() > 0) {
			System.out.println("Failed missions are:");
			for (int i = 0; i < failedMissions.size(); i++) {
				logger.error("Failed Mission number: "+failedMissions.get(i) +" , in method "+ new Object(){}.getClass().getEnclosingMethod().getName());
			}
			Assert.fail("There are errors in testing missions");
		}
	}
}
