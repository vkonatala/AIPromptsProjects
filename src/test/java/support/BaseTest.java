package support;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void setUp() {
        driver = DriverManager.createDriver();
        driver.manage().window().maximize();
        driver.get(TestConfig.loginUrl());
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (RuntimeException exception) {
                throw new IllegalStateException("Unable to close the browser driver", exception);
            } finally {
                driver = null;
            }
        }
    }
}
