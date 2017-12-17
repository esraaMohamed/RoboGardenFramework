package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class RoadMapPageObject extends BasePage{

	@FindBy(css = ".enjoyhint_close_btn")
	private WebElement hintClose;

	@FindBy(css = ".slick-dots>li")
	private List<WebElement> slickDots;

	@FindBy(css = "div[class='unlocked_class zoom_in_hover']")
	private List<WebElement> missions;

	@FindBy(css = ".slick-next")
	private WebElement nextSlickDot;

	public RoadMapPageObject(WebDriver driver) {
		super(driver);
	}

	public RoadMapPageObject closeHintWindow() {
		waitForVisibilityOf(By.cssSelector(".enjoyhint_close_btn"));
		try {
			click(hintClose);
		} catch(ElementNotFoundException elementNotFoundException) {
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
		click(missions.get(index));
		return this;
	}

	public int getMissionsSize() {
		return missions.size();
	}

	public RoadMapPageObject clickNextSlickDot() {
		waitForVisibilityOf(By.cssSelector(".slick-next"));
		click(nextSlickDot);
		return this;
	}
}
