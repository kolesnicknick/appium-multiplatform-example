import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidLoginScreen implements LoginScreen {
    private AppiumDriver driver;

    public AndroidLoginScreen(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public void enterEmail(String email) {
        driver.findElement(By.id("input"))
                .sendKeys(email);
    }

    @Override
    public void clickNextButton() {
        driver.findElement(By.id("login_request_magic_link")).click();
    }

    @Override
    public void clickSubmitButton() {
        driver.findElement(By.id("login_request_magic_link")).click();
    }

    @Override
    public String getErrorMessage() {
        return null;
    }
}
