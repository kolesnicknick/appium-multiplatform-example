import io.appium.java_client.AppiumDriver;
import managers.WebDriverController;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;



public class Lesson14HWTest extends AppiumTestBase{

    AppiumDriver driver;
    @Test
    public void verifyHillelIsOnFirstLinkGoogle(){
        //System envs should be et
        driver = (AppiumDriver) WebDriverController.getInstance().getDriver();
        driver.get("http://www.duckduckgo.com");

        driver.findElement(By.id("search_form_input_homepage")).sendKeys("hillel");
        driver.findElement(By.id("search_button_homepage")).click();
        ((WebElement) driver.findElements(By.className(".result__body")).get(0)).click();

        Assert.assertEquals(driver.getTitle(), Matchers.containsString("Компьютерная Школа"));
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }


}
