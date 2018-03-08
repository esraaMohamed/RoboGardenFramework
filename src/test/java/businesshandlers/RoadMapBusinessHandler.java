package businesshandlers;

import java.util.ArrayList;
import java.util.List;

import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class RoadMapBusinessHandler {

	RoadMapPageObject roadMapPage;

	MissionBusinessHandler missionBusinessHandler;

	String failedText, successText, failedMission;

	List<String> failedTextObj = new ArrayList<String>();

	public static enum VerificationTextMessages{
		RETRY_MISSION("RETRY MISSION"),
		GO_TO_NEXT_MISSION("GO TO NEXT MISSION"),
		BACK_TO_ROADMAP("BACK TO ROADMAP");
		
		private String friendlyName; 

		private VerificationTextMessages(String name) { 
			friendlyName = name; 
		}

		@Override
		public String toString() { 
			return friendlyName; 
		}
	};

	public RoadMapBusinessHandler(RoadMapPageObject roadMapPage, MissionPageObject missionPage) {
		this.roadMapPage = roadMapPage;
		this.missionBusinessHandler = new MissionBusinessHandler(missionPage, roadMapPage);
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
			failedText = missionBusinessHandler.failedMissionCheck();
			if (!failedText.equals(VerificationTextMessages.RETRY_MISSION.toString())) {
				System.out.println("Failed mission number in failuer case: "+(i+1));
				getFailedMission();
				continue;
			}
			successText = missionBusinessHandler.missionCheck();
			if (!((successText.equals(VerificationTextMessages.GO_TO_NEXT_MISSION.toString()) || (successText.equals(VerificationTextMessages.BACK_TO_ROADMAP.toString()))))) {
				if ((i + 1) % 5 != 0) {
					System.out.println("Failed mission number in success case: "+(i+1));
					getFailedMission();
					missionBusinessHandler.backToRoadmap();
					roadMapPage.clickMissionByIndex(i + 1);
				} else {
					System.out.println("Failed mission number in success case: "+(i+1));
					getFailedMission();
					missionBusinessHandler.backToRoadmap();
				}
			}
		}
	}

	public List<String> getFailedTextForAssertion() {
		return failedTextObj;
	}

	public void getFailedMission() {
		failedMission = missionBusinessHandler.getFailedMissionTest();
		failedTextObj.add(failedMission);
	}

	public void clickJourneyButton() {
		roadMapPage.clickJourneyButton();
	}

	public void clickMission(int missionIndex) {
		roadMapPage.clickSlickDotByIndex(missionIndex / 5)
		.clickMissionByIndex(missionIndex);
	}
}
