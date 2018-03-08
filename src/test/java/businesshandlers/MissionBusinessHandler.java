package businesshandlers;

import pageobjects.MissionPageObject;
import pageobjects.RoadMapPageObject;

public class MissionBusinessHandler {

	MissionPageObject missionPage;

	RoadMapPageObject roadMapPage;

	String failedText, successText, failedMissionId, title;

	String[] urlSubString, urlSubString1;

	public MissionBusinessHandler(MissionPageObject missionPage, RoadMapPageObject roadMapPage) {
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

	public void backToRoadmap(){
		missionPage.clickRoadmapButton();
	}

	public String getFailedMissionTest() {
		title = missionPage.getPageURL();
		urlSubString = title.split("/");
		urlSubString1 = urlSubString[urlSubString.length - 1].split("\\?");
		failedMissionId = urlSubString[urlSubString.length - 2] + "-" + urlSubString1[0];
		return failedMissionId;
	}

	public void generateModelAnswer() throws InterruptedException {
		missionPage.closeMissionHint()
		.clickSettingButton()
		.clickModelAnswerButton()
		.clickRunButton();
	}
	
	public void closeJavascriptPopup() {
		missionPage.clickCloseJavascriptPopup();
	}
	
	public void selectAndSubmitJavascriptAnswer(int index) throws InterruptedException {
		missionPage.clickTextualMissionAnswer(index)
		.clickCheckAnswerButton();
	}
	
	public boolean checkSuccessPopupAppears() {
		return missionPage.checkIfMissionAccomplishedPopupAppeared();
	}
}
