package pageobjects;

import java.util.List;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoadMapPageObject extends BasePage {

    @FindBy(css = ".enjoyhint_close_btn")
    private WebElement hintClose;

    @FindBy(css = ".slick-dots>li")
    private List<WebElement> slickDots;

    @FindBy(css = "div[class='unlocked_class zoom_in_hover']")
    private List<WebElement> missions;

    @FindBy(css = ".slick-next")
    private WebElement nextSlickDot;

    @FindBy(linkText = "Journeys")
    private WebElement journeyButton;
    
    public RoadMapPageObject(WebDriver driver) {
        super(driver);
    }

    public RoadMapPageObject closeHintWindow() {
        try {
            waitForVisibilityOf(hintClose);
            click(hintClose);
        } catch (ElementNotVisibleException elementNotVisibleException) {
            System.out.println("Hint was shown before");
        }
        return this;
    }

    public RoadMapPageObject clickSlickDotByIndex(int index) {
        try {
            click(slickDots.get(index));
        } catch (Exception e) {
            System.out.println("User is already on first mission");
        }
        return this;
    }

    public RoadMapPageObject clickMissionByIndex(int index) {
        waitForVisibilityOf(missions.get(index));
        clickByJavaExecutor(missions.get(index));
        return this;
    }

    public int getMissionsSize() {
        return missions.size();
    }

    public RoadMapPageObject clickNextSlickDot() throws InterruptedException {
        waitForVisibilityOf(nextSlickDot);
        Thread.sleep(3000);
        click(nextSlickDot);
        return this;
    }

    public void clickJourneyButton() {
        waitForVisibilityOf(journeyButton);
        clickByJavaExecutor(journeyButton);
    }
}
