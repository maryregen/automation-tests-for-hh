package mobile.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Step;
import mobile.drivers.BrowserstackMobileDriver;
import mobile.drivers.EmulatorMobileDriver;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.pages.LoginPage;
import mobile.pages.MainPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ui.helpers.Attachments;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class TestBase {
    private LoginPage loginPage = new LoginPage();
    public MainPage mainPage = new MainPage();
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;

        if (deviceHost == null) {
            Configuration.browser = EmulatorMobileDriver.class.getName();
            return;
        }

        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
            case "emulator":
                Configuration.browser = EmulatorMobileDriver.class.getName();
        }
    }

    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    void denyNotifications() {
        $(id("com.android.permissioncontroller:id/permission_deny_button"))
                .shouldBe(Condition.enabled)
                .click();
    }
    @BeforeEach
    public void setUp() {
        this.addListener();
        open();
        loginPage.close();
        denyNotifications();
    }

    @AfterEach
    void afterEach() {
        if (Configuration.browser.equals(EmulatorMobileDriver.class.getName())) {
            Attachments.screenshotAs("Last screenshot");
            Attachments.pageSource();
            Attachments.addVideo();
        }
    }

    @AfterAll
    static void afterAll() {
        closeWebDriver();
    }
}
