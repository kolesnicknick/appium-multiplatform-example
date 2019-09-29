import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import managers.ConfigurationManager;
import managers.PlatformCapabilities;
import managers.WebDriverController;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import utils.ExtendedTestWatcher;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumTestBase {

    @Rule
    public TestName name = new TestName();

    @Rule
    public ExtendedTestWatcher testWatcher = new ExtendedTestWatcher();

    @Before
    public void setUp(){

    }


    protected WordpressApp getMobileApp() {
        WordpressApp app;
        AppiumDriver driver = WebDriverController.getInstance().getDriver();
        if(ConfigurationManager.getInstance().getMobilePlatform().equals("iOS")) {
            WebDriverController.getInstance().getDriver();
            app = new IosWordPressApp((IOSDriver) driver);
        } else {
            app = new AndroidWordpressApp((AndroidDriver) driver);
        }

        return app;
    }

    protected void beforeTest(){

    }
}
