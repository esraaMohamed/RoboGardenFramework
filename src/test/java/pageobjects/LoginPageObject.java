package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePage{
	@FindBy(linkText="Login")
	private WebElement loginButton;

	@FindBy(id = "username-login")
	private WebElement userName;

	@FindBy(id = "password-login")
	private WebElement password;
	
	@FindBy(id = "login-popup")
	private WebElement popupLoginButton;
	
	@FindBy(css = ".sweet-alert.showSweetAlert.visible>p")
	private WebElement wrongUsernamePasswordPopup;
	
	@FindBy(css = ".confirm")
	private WebElement closeWrongUsernamePasswordPopupButton;
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
	}
	
	public LoginPageObject setUsername(String username) {
		setText(userName, username);
		return this;
	}
	
	public LoginPageObject setPassword(String password) {
		setText(this.password, password);
		return this;
	}
	
	public LoginPageObject clickLogin() {
		waitForVisibilityOf(loginButton);
		clickByJavaExecutor(loginButton);
		return this;
	}
	
	public JourneyPageObject clickPopupLoginButton() {
		click(popupLoginButton);
		return new JourneyPageObject(driver);
	}
	
	public String getWrongUsernameAndPasswordPopupText() {
		return wrongUsernamePasswordPopup.getText();
	}
	
	public void clickCloseWrongUsernamePasswordPopup() {
		click(closeWrongUsernamePasswordPopupButton);
	}
}
