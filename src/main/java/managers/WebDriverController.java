package managers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverController {
    private static WebDriverController controller;
    private static AppiumDriver driver;

    private WebDriverController() {
    }

    public static WebDriverController getInstance() {
        return controller == null ? new WebDriverController() : controller;
    }


    public AppiumDriver getDriver() {
        URL url = null;
        try {
            url = new URL(ConfigurationManager.getInstance().getURL());
        } catch (MalformedURLException ign) {
        }


        if (driver != null) {
            return driver;
        } else if (ConfigurationManager.getInstance().getMobilePlatform().equals("ios")) {
            return new IOSDriver(url, PlatformCapabilities.iosCapabilities());
        } else if (ConfigurationManager.getInstance().getMobilePlatform().equals("iosweb")) {
            return new IOSDriver(url, PlatformCapabilities.iosSafariCapabilities());
        } else if (ConfigurationManager.getInstance().getMobilePlatform().equals("android")) {
            return new AndroidDriver(url, PlatformCapabilities.androidCapabilities());
        } else if (ConfigurationManager.getInstance().getMobilePlatform().equals("androidweb")) {
            return new AndroidDriver(url, PlatformCapabilities.androidChromeCapabilities());

        } else return null;
    }
}
