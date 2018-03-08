package businesshandlers;

import pageobjects.MissionPageObject;

public class MissionSettingsBusinessHandler {
	MissionPageObject missionPage;
	String beforeZoom , afterZoom;

	public MissionSettingsBusinessHandler(MissionPageObject missionPage) {
		this.missionPage = missionPage;
	}

	public boolean clickMissionDescription() throws InterruptedException {
		boolean isMissionDescriptionPopupDisplayed = missionPage.closeMissionHint()
				.clickSettingButton()
				.clickOnMissionDescription()
				.isMissionDescriptionPopupDisplayed();
		missionPage.closeMissionHint();
		return isMissionDescriptionPopupDisplayed;
	}

	public boolean clickLoadCodeButton(String snippetName) {
		boolean isLoadCodePopupDisplayed = missionPage.clickLoadCodeButton()
				.selectSavedCode(snippetName)
				.clickLoadCodeSnippetButton()
				.isCodeBlockDisplayed();
		return isLoadCodePopupDisplayed;
	}

	public boolean clickDeleteSavedCode(String snippetName) {
		boolean isDeleteCodeSuccessPopupDisplayed = missionPage.clickLoadCodeButton()
				.selectSavedCode(snippetName)
				.clickDeleteCodeSnippetButton()
				.clickConfirmButton()
				.isSaveCodeSuccessPopupDisplayed();
		missionPage.clickConfirmButton();
		return isDeleteCodeSuccessPopupDisplayed;

	}

	public boolean clickSaveCodeButton(String snippetName) throws InterruptedException {
		boolean isSaveCodeErrorPopupDisplayed = missionPage.clickSaveCodeButton()
				.inputSnippetName(snippetName)
				.clickSaveSnippetNameButton()
				.isSaveCodeSuccessPopupDisplayed();
		missionPage.clickConfirmButton();
		return isSaveCodeErrorPopupDisplayed;
	}

	public boolean clickTourGuideButton() throws InterruptedException {
		boolean isTourGuideDisplayed = missionPage.clickOnShowTourGuideButton()
				.isTourGuideDisplayed();
		missionPage.clickCloseTourGuideButton();
		return isTourGuideDisplayed;

	}

	public boolean clickModelAnswerButton() throws InterruptedException {
		boolean isCodeBlockDisplayed = missionPage.clickModelAnswerButton()
				.isCodeBlockDisplayed();
		return isCodeBlockDisplayed;
	}


	public boolean clickResetButton() {
		boolean isCodeBlockNotDisplayed = missionPage.clickResetButton()
				.isCodeBlockNotDisplayed();
		return isCodeBlockNotDisplayed;
	}


	public boolean clickDecorCheckbox()  {
		boolean checkIfDecorCheckboxIsChecked = missionPage.clickWorkspaceSettingsButton()
				.clickDecorCheckbox()
				.checkIfDecorCheckboxIsChecked();
		return checkIfDecorCheckboxIsChecked;
	}

	public boolean clickDotsCheckbox() {
		boolean checkIfDotsCheckboxIsChecked = missionPage.clickDotsCheckbox()
				.checkIfDotsCheckboxIsChecked();
		return checkIfDotsCheckboxIsChecked;
	}

	public boolean clickKeepCodeCheckbox() {
		boolean checkIfKeepCodeCheckboxIsChecked = missionPage.clickKeepCodeCheckbox()
				.checkIfKeepCodeCheckboxIsChecked();
		return checkIfKeepCodeCheckboxIsChecked;
	}

	public boolean clickToggleSoundCheckbox() {
		boolean checkIfToggleSoundCheckboxIsUnchecked = missionPage.clickToggleSoundCheckbox()
				.checkIfToggleSoundCheckboxIsUnchecked();
		return checkIfToggleSoundCheckboxIsUnchecked;
	}

	public boolean moveOpacitySlider() {
		boolean checkIfOpacityValueChanged = missionPage.increaseOpacity()
				.checkIfOpacityValueChanged();
		return checkIfOpacityValueChanged;
	}

	public boolean clickZoomIn()  {
		missionPage.clickZoomReset();
		beforeZoom = missionPage.getBlockLocation();
		missionPage.clickZoomIn();
		afterZoom = missionPage.getBlockLocation();
		if (beforeZoom != afterZoom)
			return true;
		else
			return false;
	}

	public boolean clickZoomOut() {
		beforeZoom = missionPage.getBlockLocation();
		missionPage.clickZoomOut();
		afterZoom = missionPage.getBlockLocation();
		if (beforeZoom != afterZoom)
			return true;
		else
			return false;
	}

	public boolean clickZoomReset() {
		beforeZoom = missionPage.getBlockLocation();
		missionPage.clickZoomReset();
		afterZoom = missionPage.getBlockLocation();
		if (beforeZoom != afterZoom)
			return true;
		else
			return false;
	}

	public boolean removeCode() {
		return missionPage.removeCode()
				.isCodeBlockNotDisplayed();
	}

	public boolean clickRunButton() throws InterruptedException {
		return missionPage.clickModelAnswerButton()
				.clickRunButton()
				.waitStopButtonToBeEnabled()
				.runButtonEnabled();
	}

	public boolean clickPauseButton() {
		return missionPage.clickPauseButton()
				.waitContinueButtonToBeVisible()
				.pauseButtonEnabled();
	}

	public boolean clickContinueButton() {
		return missionPage.clickResumeButton()
				.waitStopButtonToBeEnabled()
				.continueButtonVisible();
	}

	public boolean clickStopButton() {
		return missionPage.clickStopButton()
				.waitRunButtonToBeEnabled()
				.stopButtonEnabled();
	}
}
