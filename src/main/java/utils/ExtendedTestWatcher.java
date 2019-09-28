package utils;

import managers.WebDriverController;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

public class ExtendedTestWatcher extends TestWatcher {

    @Override
    protected void failed(Throwable e, Description desc) {
        Screenshoter.takeScreenShot(WebDriverController.getDriver(), desc.getMethodName());
    }

    @Override
    protected void finished(Description desc) {

    }
}
