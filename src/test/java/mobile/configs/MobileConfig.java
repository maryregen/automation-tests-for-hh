package mobile.configs;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties",
        "classpath:emulator.properties"
})

public interface MobileConfig extends Config {
    @Key("platformVersion")
    String getPlatformVersion();

    @Key("platformName")
    String getPlatformName();

    @Key("deviceName")
    String getDeviceName();

    @Key("app")
    String getApp();

    @Key("appPath")
    String getAppPath();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("deviceUrl")
    String getDeviceUrl();
}
