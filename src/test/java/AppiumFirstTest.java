import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumFirstTest {

    @Test
    public void verifyRegistration() throws Exception{
        String expectedText = "client_id";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "XCUITest");

        caps.setCapability(MobileCapabilityType.APP, "/Users/mkolis/projects/personal/hillel/appium-multiplatform-example/src/main/resources/WordPress.app");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AppiumDriver driver = new IOSDriver(url, caps);

        Thread.sleep(2000);
        driver.findElement(By.xpath("///XCUIElementTypeButton[@name=\"Prologue Log In Button\"]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log in with Email Button\"]")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Login Email Address\"]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Login Email Address\"]"))
                .sendKeys("kolesniknikolai92@gmail.com");

        Thread.sleep(2000);
        driver.findElement(MobileBy.AccessibilityId("Login Email Next Button")).click();
        Thread.sleep(1000);

        driver.findElement(MobileBy.AccessibilityId("Send Link Button")).click();

        Thread.sleep(1000);
        String text = driver.findElement(By.xpath("//XCUIElementTypeScrollView//XCUIElementTypeStaticText"))
                .getText();
        Assert.assertEquals("Text is not as expected", Matchers.containsString(expectedText), text);

        driver.quit();
    }
}
