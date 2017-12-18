package configuration;

import java.util.ArrayList;
import java.util.List;

import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class RoadMapConfiguration {

	RoadMapPageObject roadMapPage;

	MissionConfiguration missionConfiguration;

	String failedText, successText;
	
	List<String> failedTextObj = new ArrayList<String>();
	
	List<String> successTextObj = new ArrayList<String>();
	
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
			String failedText = missionConfiguration.failedMissionCheck();
			String successText = missionConfiguration.missionCheck();
			failedTextObj.add(failedText);
			System.out.println(failedTextObj.size());
			successTextObj.add(successText);
			System.out.println(successTextObj.size());
		}
	}
	
	public List<String> getFailedTextForAssertion(){
		return failedTextObj;
	}
	
	public List<String> getSuccessTextForAssertion(){
		return successTextObj;
	}
}
