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
    public void setUp(){

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
