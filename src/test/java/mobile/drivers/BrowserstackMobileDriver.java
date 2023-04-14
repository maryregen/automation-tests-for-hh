package mobile.drivers;

import mobile.configs.AuthConfig;
import mobile.configs.MobileConfig;
import mobile.configs.ProjectConfig;
import com.codeborne.selenide.WebDriverProvider;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {

    static AuthConfig authConfig = ConfigFactory.create(AuthConfig.class);

    static MobileConfig mobileConfig = ConfigFactory.create(MobileConfig.class);

    static ProjectConfig projectConfig = ConfigFactory.create(ProjectConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull Capabilities capabilities) {
        MutableCapabilities caps = new MutableCapabilities();
        caps.merge(capabilities);

        // Set your access credentials
        caps.setCapability("browserstack.user", authConfig.getUser());
        caps.setCapability("browserstack.key", authConfig.getPassword());

        // Set URL of the application under test
        caps.setCapability("app", mobileConfig.getApp());

        // Specify device and os_version for testing
        caps.setCapability("device", mobileConfig.getDeviceName());
        caps.setCapability("os_version", mobileConfig.getPlatformVersion());

        // Set other BrowserStack capabilities
        caps.setCapability("project", projectConfig.getProject());
        caps.setCapability("build", projectConfig.getBuild());
        caps.setCapability("name", projectConfig.getName());

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(getBrowserstackUrl(), caps);
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(projectConfig.getRemoteUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
