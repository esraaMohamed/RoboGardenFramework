package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RoadMapPageObject extends BasePage{
	
	@FindBy(css = ".enjoyhint_close_btn")
	private WebElement hintClose;

	@FindBy(css = ".slick-dots>li")
	private WebElement slickDots;

	@FindBy(css = "div[class='unlocked_class zoom_in_hover']")
	private WebElement missions;
	
	public RoadMapPageObject(WebDriver driver) {
		super(driver);
	}
}
