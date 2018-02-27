package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class MissionPageObject extends BasePage {

	String opacityValueBefore;

	@FindBy(css = ".close.ng-scope")
	private WebElement missionTutorial;

	@FindBy(xpath = "/html/body/div[1]/div/div/div/div[3]/div/div[2]/button")
	private WebElement gotItButton;

	@FindBy(css = ".close")
	private WebElement dialogueCloseButton;

	@FindBy(id = "actions")
	private WebElement actions;

	@FindBy(id = "modelanswer")
	private WebElement modelAnswer;

	@FindBy(id = "run_button")
	private WebElement runButton;

	@FindBy(css = ".modal-title.ng-binding")
	private WebElement popupTitle;

	@FindBy(id = "check_answer_button")
	private WebElement checkAnswerButton;

	@FindBy(css = ".btn.btn-garden.ml-50")
	private WebElement roadmapButton;

	@FindBy(id = "mission_description")
	private WebElement missionDescription;

	@FindBy(id = "mission_popup")
	private WebElement missionDescriptionPopup;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/uib-accordion/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div[5]/a/span")
	private WebElement loadCodeButton;
	
	@FindBy(id= "code_list")
	private WebElement loadCodeList;

	@FindBy(xpath = "/html/body/div[1]/div/div")
	private WebElement loadCodePopup;

	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/img")
	private WebElement closeLoadCodePopupButton;

	@FindBy(css = ".glyphicon-floppy-disk")
	private WebElement saveCodeButton;
	
	@FindBy(name = "mission_snippet_name")
	private WebElement snippetNameTxt;
	
	@FindBy(id = "check_answer_button")
	private WebElement saveSnippetNameButton;
	
	@FindBy(css = ".btn-danger")
	private WebElement deleteCodeSnippetButton;

	@FindBy(css = ".confirm")
	private WebElement confirmButton;
	
	@FindBy(css = "div[class='sa-icon sa-success animate']")
	private WebElement saveMissionCodePopup;

	@FindBy(xpath = "/html/body/div[7]")
	private WebElement saveCodeErrorPopup;

	@FindBy(xpath = "/html/body/div[7]/div[7]/div/button")
	private WebElement closeSaveCodePopupButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/uib-accordion/div/div/div[2]/div/div/div/div[1]/div[2]/div[2]/div[3]/a")
	private WebElement showTourGuideButton;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div")
	private WebElement tourGuidePopup;

	@FindBy(css = ".enjoyhint_close_btn")
	private WebElement closeTourGuidePopupButton;

	@FindBy(css = "g[class='blocklyDraggable']")
	private WebElement answerBlock;

	@FindBy(id = "reset")
	private WebElement resetButton;

	@FindBy(css = "g[class='blocklyBlockCanvas']")
	private WebElement parentElement;

	@FindBy(xpath = "/html/body/div[1]/div/div/div[1]/img")
	private WebElement closeJavascriptPopup;

	@FindBy(css = "div[class='well']")
	private List<WebElement> textualMissionAnswer;

	@FindBy(id = "check_answer_button")
	private WebElement checkAnswerSubmitButton;

	@FindBy(css = ".fa-cog")
	private WebElement workspaceSettings;

	@FindBy(xpath ="/html/body/div[2]/div/div/div[2]/div/div[1]/uib-accordion/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div[1]/div[1]/label/input")
	private WebElement decorCheckbox;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/uib-accordion/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div[2]/div/label/input")
	private WebElement dotsCheckbox;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/uib-accordion/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div[3]/div/label/input")
	private WebElement keepCodeCheckbox;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/uib-accordion/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div[4]/div/label/input")
	private WebElement toggleSoundCheckbox;

	@FindBy(css = "i.pull-left")
	private WebElement myCode;

	@FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[1]/uib-accordion/div/div/div[2]/div/div/div/div[1]/div[1]/div[2]/div[1]/div[2]/label/input")
	private WebElement opacitySlider;

	@FindBy(css = "g.blocklyZoom > image:nth-child(4)")
	private WebElement zoomIn;

	@FindBy(css = "g.blocklyZoom > image:nth-child(2)")
	private WebElement zoomOut;

	@FindBy(css = "g.blocklyZoom > image:nth-child(6)")
	private WebElement resetZoom;

	@FindBy(css = "g.blocklyTrash > image:nth-child(2)")
	private WebElement trash;

	@FindBy(id = "stop_button")
	private WebElement stopButton;

	@FindBy(id = "pause_button")
	private WebElement pauseButton;

	@FindBy(id = "continue_button")
	private WebElement continueButton;

	WebElement resumeButton;

	public MissionPageObject(WebDriver driver) {
		super(driver);
	}

	public MissionPageObject closeMissionHint() {
		waitForVisibilityOf(missionTutorial);
		clickByJavaExecutor(missionTutorial);
		return this;
	}

	public MissionPageObject clickSettingButton() throws InterruptedException {
		waitForVisibilityOf(actions);
		clickByJavaExecutor(actions);
		Thread.sleep(500);
		hover(actions);
		return this;
	}

	public MissionPageObject clickModelAnswerButton() throws InterruptedException {
		waitForVisibilityOf(modelAnswer);
		Thread.sleep(500);
		click(modelAnswer);
		return this;
	}

	public MissionPageObject clickRunButton() throws InterruptedException {
		clickByJavaExecutor(runButton);
		return this;
	}

	public String dialogueButtonText() throws InterruptedException {
		waitForVisibilityOf(checkAnswerButton);
		Thread.sleep(100);
		return checkAnswerButton.getText();
	}

	public void clickContinueButton() {
		waitForVisibilityOf(checkAnswerButton);
		clickByJavaExecutor(checkAnswerButton);
	}

	public void clickRoadmapButton() {
		waitForVisibilityOf(roadmapButton);
		hover(roadmapButton);
		clickByJavaExecutor(roadmapButton);
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public void clickDialogueCloseButton(){
		click(dialogueCloseButton);
	}

	public MissionPageObject clickOnMissionDescription() {
		waitForVisibilityOf(missionDescription);
		click(missionDescription);
		return this;
	}

	public boolean isMissionDescriptionPopupDisplayed() {
		return missionDescriptionPopup.isDisplayed();
	}

	public MissionPageObject clickLoadCodeButton() {
		clickByJavaExecutor(loadCodeButton);
		return this;
	}

	public boolean isLoadCodePopupDisplayed() {
		waitForVisibilityOf(loadCodePopup);
		return loadCodePopup.isDisplayed();
	}

	public MissionPageObject closeLoadCodePopup() {
		clickByJavaExecutor(closeLoadCodePopupButton);
		return this;
	}

	public MissionPageObject clickSaveCodeButton() {
		clickByJavaExecutor(saveCodeButton);
		return this;
	}

	public boolean isSaveCodeErrorPopupDisplayed() {
		waitForVisibilityOf(saveCodeErrorPopup);
		return saveCodeErrorPopup.isDisplayed();
	}

	public MissionPageObject closeSaveCodeErrorPopup() {
		clickByJavaExecutor(closeSaveCodePopupButton);
		return this;
	}

	public MissionPageObject clickOnShowTourGuideButton() {
		clickByJavaExecutor(showTourGuideButton);
		return this;
	}

	public boolean isTourGuideDisplayed() {
		waitForVisibilityOf(tourGuidePopup);
		return tourGuidePopup.isDisplayed();
	}

	public MissionPageObject clickCloseTourGuideButton() throws InterruptedException{
		waitForVisibilityOf(closeTourGuidePopupButton);
		click(closeTourGuidePopupButton);
		click(myCode);
		clickSettingButton();
		return this;
	}

	public MissionPageObject clickResetButton() {
		click(resetButton);
		return this;
	}

	public boolean isCodeBlockDisplayed() {
		waitForVisibilityOf(answerBlock);
		return answerBlock.isDisplayed();
	}

	public boolean isCodeBlockNotDisplayed() {
		try {
			answerBlock.isDisplayed();
			return false;
		} catch (Exception e) {
			return true;
		}
	}

	public void clickCloseJavascriptPopup() {
		waitForVisibilityOf(closeJavascriptPopup);
		clickByJavaExecutor(closeJavascriptPopup);
	}

	public MissionPageObject clickTextualMissionAnswer(int index) throws InterruptedException {
		waitForVisibilityOf(textualMissionAnswer.get(index));
		clickByJavaExecutor(textualMissionAnswer.get(index));
		return this;
	}

	public MissionPageObject clickCheckAnswerButton() {
		waitForVisibilityOf(checkAnswerButton);
		clickByJavaExecutor(checkAnswerButton);
		return this;
	}

	public MissionPageObject clickGotItButton() {
		clickByJavaExecutor(gotItButton);
		return this;
	}

	public MissionPageObject clickWorkspaceSettingsButton() throws InterruptedException {
		clickByJavaExecutor(workspaceSettings);
		hover(workspaceSettings);
		return this;
	}

	public MissionPageObject clickDecorCheckbox() {
		waitForVisibilityOf(decorCheckbox);
		clickByJavaExecutor(decorCheckbox);
		return this;
	}

	public boolean checkIfDecorCheckboxIsChecked() {
		if(decorCheckbox.getAttribute("class").contains("ng-not-empty")) {
			return true;
		}
		return false;
	}

	public MissionPageObject clickDotsCheckbox() {
		clickByJavaExecutor(dotsCheckbox);
		return this;
	}

	public boolean checkIfDotsCheckboxIsChecked() {
		if(dotsCheckbox.getAttribute("class").contains("ng-not-empty")) {
			return true;
		}
		return false;
	}

	public MissionPageObject clickKeepCodeCheckbox() {
		clickByJavaExecutor(keepCodeCheckbox);
		return this;
	}

	public boolean checkIfKeepCodeCheckboxIsChecked() {
		if(keepCodeCheckbox.getAttribute("class").contains("ng-not-empty")) {
			return true;
		}
		return false;
	}

	public MissionPageObject clickToggleSoundCheckbox() {
		clickByJavaExecutor(toggleSoundCheckbox);
		return this;
	}

	public boolean checkIfToggleSoundCheckboxIsUnchecked() {
		if(!(toggleSoundCheckbox.getAttribute("class").contains("ng-not-empty"))) {
			return true;
		}
		return false;
	}

	public MissionPageObject increaseOpacity() {
		waitForVisibilityOf(opacitySlider);
		setValueByJavaExecutor(opacitySlider, "50");
		return this;
	}

	public boolean checkIfOpacityValueChanged() {
		if(Integer.parseInt(opacitySlider.getAttribute("aria-valuenow").toString())>20) {
			return true;
		}
		return false;
	}

	public MissionPageObject clickZoomIn() {
		click(zoomIn);
		click(zoomIn);
		return this;
	}

	public MissionPageObject clickZoomOut() {
		click(zoomOut);
		return this;
	}

	public MissionPageObject clickZoomReset() {
		click(resetZoom);
		return this;
	}

	public String getBlockLocation() {
		return parentElement.getLocation().toString();
	}

	public MissionPageObject removeCode() {
		dragAndDropByElement(parentElement, trash);
		return this;
	}

	public MissionPageObject clickPauseButton() {
		click(pauseButton);
		return this;
	}

	public MissionPageObject clickStopButton() {
		click(stopButton);
		return this;
	}

	public MissionPageObject clickResumeButton() {
		click(continueButton);
		return this;
	}

	public boolean stopButtonEnabled() {
		return stopButton.isEnabled();
	}

	public boolean runButtonEnabled() {
		return runButton.isEnabled();
	}

	public boolean pauseButtonEnabled() {
		return pauseButton.isEnabled();
	}

	public boolean continueButtonVisible() {
		try {
			Thread.sleep(100);
			resumeButton.isDisplayed();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public MissionPageObject waitStopButtonToBeEnabled() {
		waitForEnableOf(stopButton);
		return this;
	}

	public MissionPageObject waitContinueButtonToBeVisible() {
		waitForVisibilityOf(continueButton);
		resumeButton = driver.findElement(By.id("continue_button"));
		return this;
	}

	public MissionPageObject waitRunButtonToBeEnabled() {
		waitForEnableOf(runButton);
		return this;
	}

	public boolean checkIfMissionAccomplishedPopupAppeared() {
		waitForVisibilityOf(popupTitle);
		return popupTitle.isDisplayed();
	}
	
	public MissionPageObject inputSnippetName(String snippetName) throws InterruptedException {
		waitForVisibilityOf(snippetNameTxt);
		Thread.sleep(100);
		setText(snippetNameTxt, snippetName);
		return this;
	}
	
	public MissionPageObject clickSaveSnippetNameButton() {
		waitForVisibilityOf(saveSnippetNameButton);
		clickByJavaExecutor(saveSnippetNameButton);
		return this;
	}
	
	public boolean isSaveCodeSuccessPopupDisplayed() {
		waitForVisibilityOf(saveMissionCodePopup);
		return saveMissionCodePopup.isDisplayed();
	}
	
	public MissionPageObject clickConfirmButton() {
		clickByJavaExecutor(confirmButton);
		return this;
	}
	
	public MissionPageObject selectSavedCode(String snippetName) {
		Select codeList  = new Select(loadCodeList);
		codeList.selectByVisibleText(snippetName);
		return this;
	}
	
	public MissionPageObject clickLoadCodeSnippetButton() {
		waitForVisibilityOf(saveSnippetNameButton);
		clickByJavaExecutor(saveSnippetNameButton);
		return this;
	}

	public MissionPageObject clickDeleteCodeSnippetButton() {
		waitForVisibilityOf(deleteCodeSnippetButton);
		clickByJavaExecutor(deleteCodeSnippetButton);
		return this;
	}
}
