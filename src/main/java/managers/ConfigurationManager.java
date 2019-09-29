package managers;

public class ConfigurationManager {
    private static ConfigurationManager holder;

    private ConfigurationManager() {

    }

    public static ConfigurationManager getInstance() {
        return holder == null ? new ConfigurationManager() : holder;
    }

    public String getPlatformVersion() {
        return getEnvironmentVariableValueOrDefault("platformVersion", "12.4");
    }

    public String getMobilePlatform() {
        return getEnvironmentVariableValueOrDefault("platform", "iOS");
    }

    public String getDeviceName() {
        return getEnvironmentVariableValueOrDefault("deviceName", "iPhone XR");
    }

    public String getURL() {
        return getEnvironmentVariableValueOrDefault("url", "http://127.0.0.1:4723/wd/hub");
    }

    public String androidAppPackage() {
        return getEnvironmentVariableValueOrDefault("appPackage", "org.wordpress.android");
    }

    public String androidAppActivity() {
        return getEnvironmentVariableValueOrDefault("appActivity", "org.wordpress.android.ui.WPLaunchActivity");
    }

    private String getEnvironmentVariableValueOrDefault(String envVar, String defValue) {
        String value = System.getenv(envVar);
        return value != null ? value : defValue;
    }

}
