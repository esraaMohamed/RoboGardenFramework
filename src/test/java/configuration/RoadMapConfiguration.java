package configuration;

import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class RoadMapConfiguration {
	RoadMapPageObject roadMapPage;
	MissionConfiguration missionConfiguration;

	public RoadMapConfiguration(RoadMapPageObject roadMapPage, MissionPageObject missionPage) {
		this.roadMapPage = roadMapPage;
		this.missionConfiguration = new MissionConfiguration(missionPage, roadMapPage);
	}

	public void closeHint() {
		roadMapPage.closeHintWindow();
	}


	public void clickOnMission() {
		roadMapPage.clickSlickDotByIndex(0);
		roadMapPage.clickMissionByIndex(0);
		int missionsSize = roadMapPage.getMissionsSize();
		for (int i = 0; i < missionsSize; i++) {
			// every 5 missions will do the following
			if (i != 0 && i % 5 == 0) {
				roadMapPage.clickNextSlickDot();
				roadMapPage.clickMissionByIndex(i);
			}
			missionConfiguration.failedMissionCheck();
			missionConfiguration.missionCheck();

		}
	}
}
