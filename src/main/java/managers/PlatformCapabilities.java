package managers;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PlatformCapabilities {
    private static ConfigurationManager config = ConfigurationManager.getInstance();

    // TODO: Move app value to managers.ConfigurationManager
    public static DesiredCapabilities iosCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getPlatformVersion());
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/mkolis/projects/personal/hillel/appium-multiplatform-example/src/main/resources/WordPress.app");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);

        return desiredCapabilities;
    }


    // TODO: Move app value to managers.ConfigurationManager

    // TODO: appPackage
    // TODO: appActivity
    public static DesiredCapabilities androidCapabilities() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, config.getPlatformVersion());
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, config.getDeviceName());
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/mako/Develoment/mobile/WordPress.apk");
        desiredCapabilities.setCapability("appPackage", "org.wordpress.android");
        desiredCapabilities.setCapability("appActivity", "org.wordpress.android.ui.WPLaunchActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);

        return desiredCapabilities;
    }
}
