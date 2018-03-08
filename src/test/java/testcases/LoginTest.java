package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import businesshandlers.LoginBusinessHandler;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;

/**
 * This class contains the test cases of the login and logout functionality
 */
public class LoginTest extends BaseTest {

	LoginPageObject loginPage;

	LoginBusinessHandler loginBusinessHandler;

	HomePageObject homePage;

	String username, password, failedUsername, failedPassword;

	@BeforeTest
	public void init() {
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		loginBusinessHandler = new LoginBusinessHandler(loginPage, homePage);
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
		failedUsername = jsonTestData.getData("invalidLogin").get("username");
		failedPassword = jsonTestData.getData("invalidLogin").get("password");
	}

	/**
	 * Verifying invalid login functionality
	 */
	@Test(priority = 1)
	public void invalidLogin() {
		loginBusinessHandler.invalidLogin(failedUsername, failedPassword);
		Assert.assertEquals("Wrong Username or Password, Please try again!", loginBusinessHandler.getWrongUsernameAndPasswordText());
	}

	/**
	 * Verifying valid login functionality
	 */
	@Test(priority = 2)
	public void validLogin() {
		loginBusinessHandler.validLogin(username, password);
		Assert.assertTrue(loginBusinessHandler.isUserLoggedIn(), "Login Failed");
	}

	/**
	 * Verifying logout functionality
	 */
	@Test(priority = 3)
	public void logout() {
		loginBusinessHandler.logout();
		Assert.assertTrue(loginBusinessHandler.isLoginButtonDisplayed(), "Logout Failed");
	}
}
