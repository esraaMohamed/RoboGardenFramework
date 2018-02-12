package configuration;

import pageobjects.HomePageObject;
import pageobjects.JourneyPageObject;
import pageobjects.LoginPageObject;

public class LoginConfiguration {
	LoginPageObject loginPage;
	HomePageObject homePage;

	public LoginConfiguration(LoginPageObject loginPage, HomePageObject homePage) {
		this.loginPage = loginPage;
		this.homePage = homePage;
	}

	public JourneyPageObject validLogin(String username, String password) {
		return loginPage.clickLogin()
				.setUsername(username)
				.setPassword(password)
				.clickPopupLoginButton();
	}

	public void logout() {
		homePage.clickLogout();
	}

	public boolean isUserLoggedIn() {
		return homePage.isUsernameVisibile();
	}

	public void invalidLogin(String username, String password) {
		loginPage.clickLogin()
		.setUsername(username)
		.setPassword(password)
		.clickPopupLoginButton();
	}

	public String getWrongUsernameAndPasswordText() {
		String text = loginPage.getWrongUsernameAndPasswordPopupText();
		loginPage.clickCloseWrongUsernamePasswordPopup();
		return text;
	}
	
	public boolean isLoginButtonDisplayed() {
		return homePage.isLoginButtonDisplayed();
	}

}
