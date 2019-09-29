import enums.ParametricDataDuck;
import io.appium.java_client.AppiumDriver;
import managers.WebDriverController;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class Lesson3HWTest extends AppiumTestBase {




    @ParameterizedTest
    @EnumSource(ParametricDataDuck.class)
    public void parametricTest(ParametricDataDuck data){
        AppiumDriver driver = (AppiumDriver) WebDriverController.getInstance().getDriver();
        driver.get("http://www"+data.getCode() + ".wix.com");
        Assert.assertEquals(driver.getTitle(), Matchers.containsString(data.getExpectedTitle()));
    }
}
