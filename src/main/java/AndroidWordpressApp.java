import io.appium.java_client.android.AndroidDriver;

public class AndroidWordpressApp implements WordpressApp {
    private AndroidDriver driver;

    public AndroidWordpressApp(AndroidDriver driver){
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
