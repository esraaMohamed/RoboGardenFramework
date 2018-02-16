package configuration;

import pageobjects.MissionPageObject;

public class MissionSettingsConfiguration {
	MissionPageObject missionPage;
	String beforeZoom , afterZoom;
	
	public MissionSettingsConfiguration(MissionPageObject missionPage) {
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
	
    public boolean clickLoadCodeButton() {
        boolean isLoadCodePopupDisplayed = missionPage.clickLoadCodeButton()
                .isLoadCodePopupDisplayed();
        missionPage.closeLoadCodePopup();
        return isLoadCodePopupDisplayed;
    }
	
	public boolean clickSaveCodeButton() {
		boolean isSaveCodeErrorPopupDisplayed = missionPage.clickSaveCodeButton()
		        .isSaveCodeErrorPopupDisplayed();
		missionPage.closeSaveCodeErrorPopup();
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
	
	
	public boolean clickResetButton() throws InterruptedException {
		boolean isCodeBlockNotDisplayed = missionPage.clickModelAnswerButton()
		        .clickResetButton()
		        .isCodeBlockNotDisplayed();
		return isCodeBlockNotDisplayed;
	}
	
	
	public boolean clickDecorCheckbox() throws InterruptedException {
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
	
    public boolean clickZoomIn() throws InterruptedException {
        missionPage.clickZoomReset();
        beforeZoom = missionPage.getBlockLocation();
        missionPage.clickZoomIn();
        afterZoom = missionPage.getBlockLocation();
        if (beforeZoom != afterZoom)
            return true;
        else
            return false;
    }

    public boolean clickZoomOut() throws InterruptedException {
        beforeZoom = missionPage.getBlockLocation();
        missionPage.clickZoomOut();
        afterZoom = missionPage.getBlockLocation();
        if (beforeZoom != afterZoom)
            return true;
        else
            return false;
    }

    public boolean clickZoomReset() throws InterruptedException {
        beforeZoom = missionPage.getBlockLocation();
        missionPage.clickZoomReset();
        afterZoom = missionPage.getBlockLocation();
        if (beforeZoom != afterZoom)
            return true;
        else
            return false;
    }
    public boolean removeCode() throws InterruptedException{
        return missionPage.removeCode().isCodeBlockNotDisplayed();
        
    }
}
