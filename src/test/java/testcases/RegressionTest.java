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

public class RegressionTest extends BaseTest {

    LoginPageObject loginPage;

    HomePageObject homePage;

    JourneyPageObject journeyPage;

    RoadMapPageObject roadMapPage;

    MissionPageObject missionPage;

    LoginConfiguration loginConfiguration;

    JourneyConfiguration journeyConfiguration;

    RoadMapConfiguration roadMapConfiguration;

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
        loginConfiguration = new LoginConfiguration(loginPage, homePage);
        journeyConfiguration = new JourneyConfiguration(journeyPage);
        roadMapConfiguration = new RoadMapConfiguration(roadMapPage, missionPage);
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
        journeyPage = loginConfiguration.validLogin(username, password);
        roadMapPage = journeyConfiguration.clickPlayNowButtonByIndex(Integer.valueOf(journeyIndexNumber));
        roadMapConfiguration.closeHint();
        roadMapConfiguration.clickOnMission();
        failedMissions = roadMapConfiguration.getFailedTextForAssertion();
        if (failedMissions.size() > 0) {
            System.out.println("Failed missions are:");
            for (int i = 0; i < failedMissions.size(); i++) {
                System.out.println(failedMissions.get(i));
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
        journeyPage = loginConfiguration.validLogin(username, password);
        journeyCount = journeyConfiguration.journeyCount();
        for (int i = 3; i < journeyCount; i++) {
            roadMapPage = journeyConfiguration.clickPlayNowButtonByIndex(i);
            if (i == 0)
                roadMapConfiguration.closeHint();
            roadMapConfiguration.clickOnMission();
            roadMapConfiguration.clickJourneyButton();
        }
        failedMissions = roadMapConfiguration.getFailedTextForAssertion();
        if (failedMissions.size() > 0) {
            System.out.println("Failed missions are:");
            for (int i = 0; i < failedMissions.size(); i++) {
                System.out.println(failedMissions.get(i));
            }
            Assert.fail("There are errors in testing missions");
        }
    }
}
