package managers;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PlatformCapabilities {
    private static ConfigurationManager config = ConfigurationManager.getInstance();

    // TODO: Move platform version value to managers.ConfigurationManager
    // TODO: Move device name value to managers.ConfigurationManager
    // TODO: Move app value to managers.ConfigurationManager
    public static DesiredCapabilities iosCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getPlatformVersion());
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone X");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/mako/Develoment/mobile/WordPress.app");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);

        return desiredCapabilities;
    }


    // TODO: Move platform version value to managers.ConfigurationManager
    // TODO: Move device name value to managers.ConfigurationManager
    // TODO: Move app value to managers.ConfigurationManager

    // TODO: appPackage
    // TODO: appActivity
    public static DesiredCapabilities androidCapabilities() {

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.1");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_3");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/mako/Develoment/mobile/WordPress.apk");
        desiredCapabilities.setCapability("appPackage", "org.wordpress.android");
        desiredCapabilities.setCapability("appActivity", "org.wordpress.android.ui.WPLaunchActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);

        return desiredCapabilities;
    }
}
