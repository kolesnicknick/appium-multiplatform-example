import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IosWelcomeScreen implements WelcomeScreen {
    private AppiumDriver driver;
    private WebDriverWait wait;

    public IosWelcomeScreen(AppiumDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 30);
    }


    @Override
    public void clickLoginButton() {
        driver.findElement(By.id("Prologue Log In Button")).click();

        String welcomeScreenLoginBtn = "Log in with Email Button";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(welcomeScreenLoginBtn)));
        driver.findElement(By.id(welcomeScreenLoginBtn)).click();
    }
}
