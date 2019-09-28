import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AndroidWelcomeScreen implements WelcomeScreen {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public AndroidWelcomeScreen(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
    }


    @Override
    public void clickLoginButton() {
        String id = "login_button";
        driver.findElement(By.id("login_button"));
        driver.findElement(By.id("login_request_magic_link")).click();
        driver.findElement(By.id("login_open_email_client")).click();
    }
}
