package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshoter {

    public static void takeScreenShot(WebDriver webDriver, String testName) {
        File screenData = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
        try {
            File screenFile =
                    new File(System.getProperty("user.dir") + "/src/main/resources/screenshots" + testName + ".png");
            FileUtils.copyFile(screenData, screenFile);
            System.out.println("======== SCREENSHOT ========");
            System.out.println(screenFile.getAbsolutePath());
            System.out.println("================");
        } catch (IOException ignore) {
        }
    }
}
