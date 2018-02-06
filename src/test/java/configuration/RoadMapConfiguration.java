package configuration;

import java.util.ArrayList;
import java.util.List;

import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class RoadMapConfiguration {

    RoadMapPageObject roadMapPage;

    MissionConfiguration missionConfiguration;

    String failedText, successText, failedMission;

    List<String> failedTextObj = new ArrayList<String>();

    public RoadMapConfiguration(RoadMapPageObject roadMapPage, MissionPageObject missionPage) {
        this.roadMapPage = roadMapPage;
        this.missionConfiguration = new MissionConfiguration(missionPage, roadMapPage);
    }

    public void closeHint() {
        roadMapPage.closeHintWindow();
    }

    public void clickOnMission() throws InterruptedException {
        roadMapPage.clickSlickDotByIndex(0);
        roadMapPage.clickMissionByIndex(0);
        int missionsSize = roadMapPage.getMissionsSize();
        for (int i = 0; i < missionsSize; i++) {
            System.out.println("mission: " + i);
            // every 5 missions will do the following
            if (i != 0 && i % 5 == 0) {
                roadMapPage.clickNextSlickDot();
                roadMapPage.clickMissionByIndex(i);
            }
            failedText = missionConfiguration.failedMissionCheck();
            if (!failedText.equals("RETRY MISSION")) {
                System.out.println("Failed mission number in failuer case: "+(i+1));
                getFailedMission();
                continue;
            }
            successText = missionConfiguration.missionCheck();
            if (!((successText.equals("GO TO NEXT MISSION")) || (successText.equals("BACK TO ROADMAP")))) {
                if ((i + 1) % 5 != 0) {
                    System.out.println("Failed mission number in success case: "+(i+1));
                    getFailedMission();
                    missionConfiguration.backToRoadmap();
                    roadMapPage.clickMissionByIndex(i + 1);
                } else {
                    System.out.println("Failed mission number in success case: "+(i+1));
                    getFailedMission();
                    missionConfiguration.backToRoadmap();
                }
            }
        }
    }

    public List<String> getFailedTextForAssertion() {
        return failedTextObj;
    }

    public void getFailedMission() {
        failedMission = missionConfiguration.getFailedMissionTest();
        failedTextObj.add(failedMission);
    }

    public void clickJourneyButton() {
        roadMapPage.clickJourneyButton();
    }
}
