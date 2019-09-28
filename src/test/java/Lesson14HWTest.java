import io.appium.java_client.ios.IOSDriver;
import managers.PlatformCapabilities;
import org.junit.Test;

public class Lesson14HWTest extends AppiumTestBase{

    @Test
    public void verifyHillelIsOnFirstLinkGoogle(){
        IOSDriver driver = new IOSDriver(getURL("127.0.0.1","4723"), PlatformCapabilities.iosSafariCapabilities());

        driver.get("http://www.google.com");

    }


}
