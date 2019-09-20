import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import managers.ConfigurationManager;
import managers.PlatformCapabilities;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumTestBase {

    @Before
    public static void setUp(){
        String expectedText = "The required \"client_id\" parameter is missing.";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "XCUITest");

        caps.setCapability(MobileCapabilityType.APP, "/Users/niko/IdeaProjects/appiumtests/src/WordPress.app");

        try {
            URL url = new URL("http://127.0.0.1:4723/wd/hub");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    protected WordpressApp getMobileApp() throws Exception {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        WordpressApp app;
        if(ConfigurationManager.getInstance().getMobilePlatform().equals("iOS")) {
            IOSDriver driver = new IOSDriver(url, PlatformCapabilities.iosCapabilities());
            app = new IosWordPressApp(driver);
        } else {
            AndroidDriver driver = new AndroidDriver(url, PlatformCapabilities.androidCapabilities());
            app = new AndroidWordpressApp(driver);
        }

        return app;
    }

}
