import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class AndroidWordpressApp implements WordpressApp {
    private AppiumDriver driver;

    public AndroidWordpressApp(AppiumDriver driver){
    this.driver = driver;
    }

    @Override
    public LoginScreen loginScreen() {
        return null;
    }

    @Override
    public WelcomeScreen welcomeScreen() {
        return null;
    }
}
