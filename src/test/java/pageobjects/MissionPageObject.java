package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MissionPageObject extends BasePage {

    @FindBy(css = ".close.ng-scope")
    private WebElement missionTutorial;

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

    public MissionPageObject(WebDriver driver) {
        super(driver);
    }

    public MissionPageObject closeMissionHint() {
        waitForVisibilityOf(missionTutorial);
        click(missionTutorial);
        return this;
    }

    public MissionPageObject clickSettingButton() {
        click(actions);
        return this;
    }

    public MissionPageObject clickModelAnswerButton() {
        waitForVisibilityOf(modelAnswer);
        click(modelAnswer);
        return this;
    }

    public MissionPageObject clickRunButton() {
        click(runButton);
        return this;
    }

    public String dialogueButtonText() {
        waitForVisibilityOf(checkAnswerButton);
        return checkAnswerButton.getText();
    }

    public void clickContinueButton() {
        click(checkAnswerButton);
    }

}
