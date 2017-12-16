package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JourneyPageObject extends BasePage{

	@FindBy(xpath = ".//*[@id='page-wrapper']/div[2]/div/div/section[2]/div/div/div[1]/div/div[1]/div/div[1]")
	private WebElement journey;
	
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
