package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MissionPageObject extends BasePage {

    @FindBy(css = ".nivo-lightbox-close")
    private WebElement missionTutorial;

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

    @FindBy(css = ".go_next.animated.bounceInDown.ng-binding.ng-scope")
    private WebElement successButton;

    @FindBy(css = ".bonus_div")
    private WebElement objectiveButton;

    public MissionPageObject(WebDriver driver) {
        super(driver);
    }

    public MissionPageObject closeMissionHint() {
        waitForVisibilityOf(missionTutorial);
        clickByJavaExecutor(missionTutorial);
        return this;
    }
    
    public MissionPageObject clickObjectiveButton(){
        waitForVisibilityOf(objectiveButton);
        clickByJavaExecutor(objectiveButton);
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
        click(modelAnswer);
        return this;
    }

    public MissionPageObject clickRunButton() throws InterruptedException {
        clickByJavaExecutor(runButton);
        return this;
    }

    public String failRunButtonText() {
        waitForVisibilityOf(checkAnswerButton);
        return checkAnswerButton.getText();
    }

    public void clickRetryButton() {
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

    public void clickDialogueCloseButton() {
        click(dialogueCloseButton);
    }

    public String successRunButtonText() {
        try{
            waitForVisibilityOf(successButton);
            return successButton.getText();
        }catch (Exception e){
            return checkAnswerButton.getText();
        }
        
    }

    public void clickContinueButton() {
        try{
            clickByJavaExecutor(successButton);
        }catch (Exception e){
             clickByJavaExecutor(checkAnswerButton);
        }
        
    }

}
