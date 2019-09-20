import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import managers.ConfigurationManager;
import managers.PlatformCapabilities;
import org.junit.Test;

import java.net.URL;

public class WordPressLoginTests extends AppiumTestBase{


    @Test
    public void testIncorrectEmail() throws Exception {
        System.out.println("Start application");
        WordpressApp app = getMobileApp();

        System.out.println("Click Login button");
        app.welcomeScreen().clickLoginButton();

        System.out.println("Enter email");
        app.loginScreen().enterEmail("test@git.com");

        System.out.println("Click Next");
        app.loginScreen().clickNextButton();

        System.out.println("Check error message");
        // Assert for error msg
    }



}