package mobile.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobile.configs.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import javax.annotation.Nonnull;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;

public class EmulationMobileDriver implements WebDriverProvider {

    static MobileConfig mobileConfig = ConfigFactory
            .create(MobileConfig.class, System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(mobileConfig.getDeviceUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(mobileConfig.getPlatformName())
                .setDeviceName(mobileConfig.getDeviceName())
                .setPlatformVersion(mobileConfig.getPlatformVersion())
                .setApp(getAppPath())
                .setAppPackage(mobileConfig.getAppPackage())
                .setAppActivity(mobileConfig.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {

        String appPath = mobileConfig.getAppPath();

        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}
