package configuration;

import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;

public class LoginConfiguration {
	LoginPageObject loginPage;
	HomePageObject homePage;
	
	public LoginConfiguration(LoginPageObject loginPage, HomePageObject homePage) {
		this.loginPage = loginPage;
		this.homePage = homePage;
	}
	
	public void login(String username, String password) {
		loginPage.clickLogin()
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

}
