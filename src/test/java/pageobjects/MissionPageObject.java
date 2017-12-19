package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MissionPageObject extends BasePage {

    @FindBy(css = ".close.ng-scope")
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

    public MissionPageObject(WebDriver driver) {
        super(driver);
    }

    public MissionPageObject closeMissionHint() {
        waitForVisibilityOf(missionTutorial);
        click(missionTutorial);
        return this;
    }

    public MissionPageObject clickSettingButton() {
        waitForVisibilityOf(actions);
        hover(actions);
        action.moveToElement(actions).click().perform();
        return this;
    }

    public MissionPageObject clickModelAnswerButton() {
        waitForVisibilityOf(modelAnswer);
        click(modelAnswer);
        return this;
    }

    public MissionPageObject clickRunButton() throws InterruptedException {
        clickByJavaExecutor(runButton);
        return this;
    }

    public String dialogueButtonText() {
        waitForVisibilityOf(checkAnswerButton);
        return checkAnswerButton.getText();
    }

    public void clickContinueButton() {
        click(checkAnswerButton);
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
    

}
