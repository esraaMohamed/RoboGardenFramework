package configuration;

import pageobjects.MissonPageObject;
import pageobjects.RoadMapPageObject;

public class MissionConfiguration {

    MissonPageObject missionPage;

    RoadMapPageObject roadMapPage;

    public MissionConfiguration(MissonPageObject missionPage, RoadMapPageObject roadMapPage) {
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
