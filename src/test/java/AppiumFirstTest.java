import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumFirstTest {

    @Test
    public void verifyRegistration() throws Exception{
        String expectedText = "The required \"client_id\" parameter is missing.";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "XCUITest");

        caps.setCapability(MobileCapabilityType.APP, "/Users/niko/IdeaProjects/appiumtests/src/WordPress.app");

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
        driver.findElement(By.xpath("//[@name=\"Login Email Next Button\"]")).click();
        driver.findElement(By.xpath("//[@name=\"Send Link Button\"]")).click();

        Thread.sleep(2000);
        String text = driver.findElement(By.xpath("//[contains(@name,'client_id')]"))
                .getText();
        Thread.sleep(2000);

        Assert.assertEquals("Text is not as expected", text, expectedText);
    }
}
