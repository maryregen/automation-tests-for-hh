package mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
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

public class TestBase {
    private LoginPage loginPage = new LoginPage();
    public MainPage mainPage = new MainPage();
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = null;

        switch (deviceHost) {
            case "browserstack":
                Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            default:
                Configuration.browser = EmulatorMobileDriver.class.getName();
        }
    }

    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    public void setUp() {
        this.addListener();
        open();
        mainPage = loginPage.close().denyNotifications();
    }

    @AfterEach
    void afterEach() {
        if (deviceHost.equals("emulator")) {
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
