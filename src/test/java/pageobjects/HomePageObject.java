package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject extends BasePage{
	
	@FindBy(xpath = "/html/body/div[2]/div/div/div[1]/header/div/div[1]/div/nav/ul/li[8]/a/div")
	private List<WebElement> logoutButtons;
	
	@FindBy(xpath = ".//*[@id='menuzord-right']/ul/li[5]/a/div")
	private WebElement usernameDiv;
	
	@FindBy(linkText="Login")
	private WebElement loginButton;

	public HomePageObject(WebDriver driver) {
		super(driver);
	}

	public void clickLogout() {
		waitForVisibilityOf(logoutButtons.get(0));
		clickByJavaExecutor(logoutButtons.get(0));
	}
	
	public boolean isUsernameVisibile() {
		return usernameDiv.isDisplayed();
	}
	
	public boolean isLoginButtonDisplayed() {
		return loginButton.isDisplayed();
	}
}
