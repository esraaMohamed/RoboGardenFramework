package configuration;

import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class MissionConfiguration {

    MissionPageObject missionPage;

    RoadMapPageObject roadMapPage;

    String failedText, successText;

    public MissionConfiguration(MissionPageObject missionPage, RoadMapPageObject roadMapPage) {
        this.missionPage = missionPage;
        this.roadMapPage = roadMapPage;
    }

    public String failedMissionCheck() throws InterruptedException {
        missionPage.closeMissionHint()
        .clickRunButton();
        failedText = missionPage.dialogueButtonText();
        missionPage.clickContinueButton();
        return failedText;
    }

    public String missionCheck() throws InterruptedException {
        missionPage.clickSettingButton()
        .clickModelAnswerButton()
        .clickRunButton();
        successText = missionPage.dialogueButtonText();
        missionPage.clickContinueButton();
        return successText;
    }

}
