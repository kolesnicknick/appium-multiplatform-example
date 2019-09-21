import io.appium.java_client.AppiumDriver;

public class AndroidLoginScreen implements LoginScreen {
    private AppiumDriver driver;

    public AndroidLoginScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public void enterEmail(String email) {

    }

    @Override
    public void clickNextButton() {

    }

    @Override
    public void clickSubmitButton() {

    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
