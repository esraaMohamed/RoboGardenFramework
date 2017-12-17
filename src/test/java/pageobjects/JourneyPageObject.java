package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JourneyPageObject extends BasePage{

	@FindBy(css = "a[class='btn btn-flat btn-dark btn-theme-colored btn-md pull-left font-15']")
	private List<WebElement> playNowButton;
	
	public JourneyPageObject(WebDriver driver) {
		super(driver);
	}
	
	public RoadMapPageObject clickOnPlayNowButton() {
		hover(playNowButton.get(0));
		click(playNowButton.get(0));
		return new RoadMapPageObject(driver);
	}

}
