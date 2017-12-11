package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BasePage{
	
	@FindBy(css = "i[class='fa fa-sign-out']")
	private List<WebElement> logoutButtons;
	
	@FindBy(xpath = ".//*[@id='menuzord-right']/ul/li[5]/a/div")
	private WebElement usernameDiv;

	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	public void clickLogout() {
		click(logoutButtons.get(0));
	}
	
	public boolean isUsernameVisibile() {
		return usernameDiv.isDisplayed();
	}
}
