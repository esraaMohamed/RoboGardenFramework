package configuration;

import pageobjects.MissionPageObject;

public class MissionSettingsConfiguration {
	MissionPageObject missionPage;
	
	public MissionSettingsConfiguration(MissionPageObject missionPage) {
		this.missionPage = missionPage;
	}

	public void clickMissionDescription() throws InterruptedException {
		missionPage.closeMissionHint()
		.clickSettingButton()
		.clickOnMissionDescription();
	}
	
	public boolean isMissionDescriptionPopupDisplayed() {
		return missionPage.isMissionDescriptionPopupDisplayed();
	}
	
	public void clickLoadCodeButton() {
		missionPage.closeMissionHint()
		.clickLoadCodeButton();
	}
	
	public boolean isLoadCodePopupDisplayed() {
		return missionPage.isLoadCodePopupDisplayed();
	}
	
	public void clickSaveCodeButton() {
		missionPage.closeLoadCodePopup()
		.clickSaveCodeButton();
	}
	
	public boolean isSaveCodeErrorPopupDisplayed() {
		return missionPage.isSaveCodeErrorPopupDisplayed();
	}
	
	public void clickTourGuideButton() {
		missionPage.closeSaveCodeErrorPopup()
		.clickOnShowTourGuideButton();
	}
	
	public boolean isTourGuideDisplayed() {
		return missionPage.isTourGuideDisplayed();
	}
	
	public void clickModelAnswerButton() throws InterruptedException {
		missionPage.clickCloseTourGuideButton()
		.clickModelAnswerButton();
	}
	
	public boolean isModelAnswerCodeBlockDisplayed() {
		return missionPage.isCodeBlockDisplayed();
	}
	
	public void clickResetButton() {
		missionPage.clickResetButton();
	}
	
	public boolean isModelAnswerCodeNotDisplayed() {
		return missionPage.isCodeBlockNotDisplayed();
	}
	
	public void clickDecorCheckbox() {
		missionPage.clickWorkspaceSettingsButton()
		.clickDecorCheckbox();
	}
	
	public boolean isDecorCheckboxChecked() {
		return missionPage.checkIfDecorCheckboxIsChecked();
	}
	
	public void clickDotsCheckbox() {
		missionPage.clickDotsCheckbox();
	}
	
	public boolean isDotsCheckboxChecked() {
		return missionPage.checkIfDotsCheckboxIsChecked();
	}
	
	public void clickKeepCodeCheckbox() {
		missionPage.clickKeepCodeCheckbox();
	}
	
	public boolean isKeepCodeCheckboxChecked() {
		return missionPage.checkIfKeepCodeCheckboxIsChecked();
	}
	
	public void clickToggleSoundCheckbox() {
		missionPage.clickToggleSoundCheckbox();
	}
	
	public boolean isToggleSoundCheckboxUnchecked() {
		return missionPage.checkIfToggleSoundCheckboxIsUnchecked();
	}
}
