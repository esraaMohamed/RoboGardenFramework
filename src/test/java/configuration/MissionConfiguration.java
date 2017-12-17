package configuration;

import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class MissionConfiguration {

    MissionPageObject missionPage;

    RoadMapPageObject roadMapPage;

    public MissionConfiguration(MissionPageObject missionPage, RoadMapPageObject roadMapPage) {
        this.missionPage = missionPage;
        this.roadMapPage = roadMapPage;
    }

    public String failedMissionCheck() {
        missionPage.closeMissionHint().clickRunButton();
        String text = missionPage.dialogueText();
        missionPage.clickContinueButton();
        return text;
    }
    
    public void missionCheck(){
        missionPage.clickSettingButton()
        .clickModelAnswerButton()
        .clickRunButton()
        .clickContinueButton();
    }

}
