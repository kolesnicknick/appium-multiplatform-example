import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IosLoginScreen implements LoginScreen {
    IOSDriver driver;
    WebDriverWait wait;
    public IosLoginScreen(IOSDriver driver) {
        this.driver =  driver;
        wait = new WebDriverWait(this.driver, 30);
    }

    @Override
    public void enterEmail(String email) {
        String id = "Login Email Address";
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id(id)));
        driver.findElement(MobileBy.id(id)).click();
        driver.findElement(MobileBy.id(id)).sendKeys(email);
    }

    @Override
    public void clickNextButton() {
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Login Email Next Button")));
        driver.findElement(MobileBy.AccessibilityId("Login Email Next Button")).click();
    }

    public void clickSubmitButton(){
        By sendButtonID = MobileBy.AccessibilityId("Send Link Button");
        wait.until(ExpectedConditions.presenceOfElementLocated(sendButtonID));
        driver.findElement(sendButtonID).click();

    }

    @Override
    public String getErrorMessage() {
        return driver.findElement(MobileBy.xpath("//XCUIElementTypeScrollView//XCUIElementTypeStaticText"))
                .getText();
    }
}
