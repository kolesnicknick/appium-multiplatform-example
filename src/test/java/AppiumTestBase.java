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
    ExtendedTestWatcher testWatcher = new ExtendedTestWatcher();

    @Before
    public void setUp(){

    }


    protected WordpressApp getMobileApp() throws Exception {
        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        WordpressApp app;
        if(ConfigurationManager.getInstance().getMobilePlatform().equals("iOS")) {
            WebDriverController.getInstance().getWebDriver("iOS");
            IOSDriver driver = new IOSDriver(url, PlatformCapabilities.iosCapabilities());
            app = new IosWordPressApp(driver);
        } else {
            WebDriverController.getInstance().getWebDriver("iOS");
            AndroidDriver driver = new AndroidDriver(url, PlatformCapabilities.androidCapabilities());
            app = new AndroidWordpressApp(driver);
        }

        return app;
    }


    public URL getURL(String host, String port){
        URL url = null;
        try {
            url = new URL("http://" + host+ ":"+ port +"/wd/hub");

        }
        catch (MalformedURLException e){}

        return url;
    }
}
