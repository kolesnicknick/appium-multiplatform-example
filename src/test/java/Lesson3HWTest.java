import enums.ParametricDataDuck;
import io.appium.java_client.AppiumDriver;
import managers.WebDriverController;
import org.junit.Assert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@RunWith(Parameterized.class)
public class Lesson3HWTest extends AppiumTestBase {


    @ParameterizedTest
    @EnumSource(ParametricDataDuck.class)
    public void parametricTest(ParametricDataDuck data) {
        AppiumDriver driver = WebDriverController.getInstance().getDriver();
        driver.get("http://www" + data.getSearchParam() + ".wix.com");

        WebElement signInButton = driver.findElement(By.cssSelector("[role=button]"));
        WebElement welcomeTextHolder = driver.findElement(By.cssSelector(".txtNew"));

        Assert.assertEquals(data.getSignInButtonTitle(), signInButton.getText());
        Assert.assertEquals(data.getCreateButtonTitle(), welcomeTextHolder.getText());

    }
}
