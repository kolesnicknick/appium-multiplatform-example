package managers;

import io.appium.java_client.AppiumDriver;

import java.net.URL;

public class WebDriverController {
    private WebDriverController controller;
    private AppiumDriver driver;


    public AppiumDriver getDriver(URL url) {
        if (ConfigurationManager.getInstance().getMobilePlatform().equals("iOS")) ;
        return null;
    }

}
