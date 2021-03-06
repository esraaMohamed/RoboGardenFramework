package testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import configuration.LoginConfiguration;
import pageobjects.HomePageObject;
import pageobjects.LoginPageObject;

/**
 * This class contains the test cases of the login and logout functionality
 */
public class LoginTest extends BaseTest {

    LoginPageObject loginPage;

    LoginConfiguration loginConfiguration;

    HomePageObject homePage;

    String username, password, failedUsername, failedPassword;

    @BeforeTest
    public void init() {
        loginPage = new LoginPageObject(driver);
        homePage = new HomePageObject(driver);
        loginConfiguration = new LoginConfiguration(loginPage, homePage);
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
        loginConfiguration.invalidLogin(failedUsername, failedPassword);
        Assert.assertEquals("Wrong Username or Password, Please try again!", loginConfiguration.getWrongUsernameAndPasswordText());
    }

    /**
     * Verifying valid login functionality
     */
    @Test(priority = 2)
    public void validLogin() {
        loginConfiguration.validLogin(username, password);
        Assert.assertTrue(loginConfiguration.isUserLoggedIn(), "Login Failed");
    }

    /**
     * Verifying logout functionality
     */
    @Test(priority = 3)
    public void logout() {
        loginConfiguration.logout();
        Assert.assertTrue(driver.getCurrentUrl().contains("home"), "Logout Failed");
    }
}
