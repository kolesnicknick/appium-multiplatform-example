package managers;

import io.appium.java_client.remote.MobileCapabilityType;

public enum Configurations {

    PLATFORM_VERSION(MobileCapabilityType.PLATFORM_VERSION),
    DEVICE_NAME("deviceName"),
    APP_VALUE("appValue"),
    APP_PACKAGE("appackage"),
    APP_ACTIVITY("appActivity");

    Configurations(String name){
        this.name = name;
    }
    private String name;
}
