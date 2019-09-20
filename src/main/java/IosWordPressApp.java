import io.appium.java_client.ios.IOSDriver;

public class IosWordPressApp implements WordpressApp {

    private IOSDriver driver;
    public IosWordPressApp(IOSDriver driver){
        this.driver = driver;
    }
    @Override
    public LoginScreen loginScreen() {
        return new IosLoginScreen(driver);

    }

    @Override
    public WelcomeScreen welcomeScreen() {
        return new IosWelcomeScreen(driver);
    }
}
