package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import support.BaseTest;
import support.TestConfig;

public final class ValidLoginTest extends BaseTest {

    @Test
    public void validUserCanSubmitLoginForm() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(TestConfig.username(), TestConfig.password(), false);
            Assert.assertFalse(loginPage.loginFormIsDisplayed(), "The login form remained visible after valid authentication");
        } catch (RuntimeException exception) {
            throw new AssertionError("Valid Salesforce login test failed", exception);
        }
    }
}
