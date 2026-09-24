package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import support.BaseTest;
import support.TestConfig;

public final class InvalidLoginTest extends BaseTest {

    @Test
    public void invalidUserReceivesLoginError() {
        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(TestConfig.invalidUsername(), TestConfig.invalidPassword(), false);
            String errorMessage = loginPage.errorMessage();
            Assert.assertTrue(errorMessage.contains("Please check your username and password"),
                    "Unexpected Salesforce login error: " + errorMessage);
        } catch (RuntimeException exception) {
            throw new AssertionError("Invalid Salesforce login test failed", exception);
        }
    }
}
