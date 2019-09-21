import io.appium.java_client.AppiumDriver;

public class AndroidWordpressApp implements WordpressApp {
    private AppiumDriver driver;

    public AndroidWordpressApp(AppiumDriver driver){
    this.driver = driver;
    }

    @Override
    public LoginScreen loginScreen() {
        return new AndroidLoginScreen(driver);
    }

    @Override
    public WelcomeScreen welcomeScreen() {
        return new AndroidWelcomeScreen(driver);
    }
}
