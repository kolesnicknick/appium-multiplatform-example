import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;

public class AppiumShitCodeTest {

    @Test
    public void verifyRegistrationIOS() throws Exception{
        String expectedText = "client_id";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4");

        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");

        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "XCUITest");

        caps.setCapability(MobileCapabilityType.APP, "/Users/mkolis/projects/personal/hillel/appium-multiplatform-example/src/main/resources/WordPress.app");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AppiumDriver driver = new IOSDriver(url, caps);

        Thread.sleep(1000);
        driver.findElement(By.xpath("///XCUIElementTypeButton[@name=\"Prologue Log In Button\"]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log in with Email Button\"]")).click();

        Thread.sleep(1000);
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Login Email Address\"]")).click();
        driver.findElement(By.xpath("//XCUIElementTypeTextField[@name=\"Login Email Address\"]"))
                .sendKeys("kolesniknikolai92@gmail.com");

        Thread.sleep(1000);
        driver.findElement(MobileBy.AccessibilityId("Login Email Next Button")).click();
        Thread.sleep(1000);

        driver.findElement(MobileBy.AccessibilityId("Send Link Button")).click();

        Thread.sleep(1000);
        String text = driver.findElement(By.xpath("//XCUIElementTypeScrollView//XCUIElementTypeStaticText"))
                .getText();
        Assert.assertEquals("Text is not as expected", Matchers.containsString(expectedText), text);

        driver.quit();
    }

    @Test
    public void verifyRegistrationAndroid() throws Exception {
        String expectedText = "The required \"client_id\" parameter is missing.";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3");
        caps.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        caps.setCapability(MobileCapabilityType.APP, "/Users/mkolis/projects/personal/hillel/appium-multiplatform-example/src/main/resources/WordPress.apk");
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "org.wordpress.android.ui.WPLaunchActivity");
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "org.wordpress.android");
        caps.setCapability(MobileCapabilityType.NO_RESET, true);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 300);


        URL url = new URL("http://127.0.0.1:4723/wd/hub");

        AppiumDriver driver = new AndroidDriver(url, caps);

        Thread.sleep(1000);
        driver.findElement(By.xpath("///XCUIElementTypeButton[@name=\"Prologue Log In Button\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"Log in with Email Button\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//[@name=\"Login Email Address\"]"))
                .sendKeys("true@wix.com");

        Thread.sleep(1000);

        driver.findElement(By.xpath("//[@name=\"Login Email Next Button\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//[@name=\"Send Link Button\"]")).click();
        Thread.sleep(1000);

        String text = driver.findElement(By.xpath("//[contains(@name,'client_id')]"))
                .getText();
        Thread.sleep(2000);

        Assert.assertEquals("Text is not as expected", text, expectedText);
        Thread.sleep(10000);
    }
}
