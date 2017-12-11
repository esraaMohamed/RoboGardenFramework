package testcases;

import org.junit.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.LoginConfiguration;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;


/** 
 * This class contains the test cases of the login and logout functionality*/
public class LoginTest extends BaseTest{
	LoginPageObject loginPage;
	LoginConfiguration loginConfiguration;
	HomePageObject homePage;
	String username , password;
	
	@BeforeTest
	public void init() {
		loginPage = new LoginPageObject(driver);
		homePage = new HomePageObject(driver);
		loginConfiguration = new LoginConfiguration(loginPage, homePage);
		username = jsonTestData.getData("Login").get("username");
		password = jsonTestData.getData("Login").get("password");
	}

	/**
	 * Verifying login functionality*/
	@Test(priority = 1)
	public void login() {
		loginConfiguration.login(username, password);
		Assert.assertTrue("Login Failed", loginConfiguration.isUserLoggedIn());
	}
	
	/**
	 * Verifying logout functionality*/
	@Test(priority = 2)
	public void logout() {
		loginConfiguration.logout();
		AssertJUnit.assertTrue("Logout Failed", driver.getCurrentUrl().contains("home"));
	}
}
