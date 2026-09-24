package support;

public final class TestConfig {

    private static final String DEFAULT_LOGIN_URL = "https://login.salesforce.com/?locale=in";
    private static final String DEFAULT_BROWSER = "chrome";

    private TestConfig() {
    }

    public static String loginUrl() {
        return value("SALESFORCE_LOGIN_URL", "salesforce.login.url", DEFAULT_LOGIN_URL);
    }

    public static String username() {
        return required("SALESFORCE_USERNAME", "salesforce.username");
    }

    public static String password() {
        return required("SALESFORCE_PASSWORD", "salesforce.password");
    }

    public static String browser() {
        return value("BROWSER", "browser", DEFAULT_BROWSER);
    }

    public static String invalidUsername() {
        return value("SALESFORCE_INVALID_USERNAME", "salesforce.invalid.username", "invalid.user@example.invalid");
    }

    public static String invalidPassword() {
        return value("SALESFORCE_INVALID_PASSWORD", "salesforce.invalid.password", "InvalidPassword!123");
    }

    private static String required(String environmentName, String propertyName) {
        String configuredValue = value(environmentName, propertyName, "");
        if (configuredValue.isBlank()) {
            throw new IllegalStateException("Required configuration is missing: " + environmentName);
        }
        return configuredValue;
    }

    private static String value(String environmentName, String propertyName, String defaultValue) {
        String propertyValue = System.getProperty(propertyName);
        if (propertyValue != null && !propertyValue.isBlank()) {
            return propertyValue.trim();
        }
        String environmentValue = System.getenv(environmentName);
        if (environmentValue != null && !environmentValue.isBlank()) {
            return environmentValue.trim();
        }
        return defaultValue;
    }
}
