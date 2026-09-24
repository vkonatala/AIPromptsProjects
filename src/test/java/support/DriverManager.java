package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public final class DriverManager {

    private DriverManager() {
    }

    public static WebDriver createDriver() {
        String browser = TestConfig.browser().toLowerCase();
        if (!browser.equals("chrome")) {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }
        try {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            return new ChromeDriver(options);
        } catch (RuntimeException exception) {
            throw new IllegalStateException("Unable to create the browser driver", exception);
        }
    }
}
