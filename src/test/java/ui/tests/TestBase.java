package ui.tests;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.AfterEach;
import ui.drivers.WebDriverProvider;
import ui.helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ui.pages.*;

public class TestBase {
    MainPage mainPage = new MainPage();
    EmployerMainPage employerMainPage = new EmployerMainPage();
    ApplicantMainPage applicantMainPage = new ApplicantMainPage();
    ApplicantSearchPage applicantSearchPage = new ApplicantSearchPage();
    public static String env = System.getProperty("env");
    @BeforeAll
    static void beforeAll() {
        WebDriverProvider provider = new WebDriverProvider();
        System.setProperty("chromeoptions.args", "--remote-allow-origins=*");

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    void clearCookies() {
        Selenide.clearBrowserCookies();
    }

    @AfterEach
    void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();

        if (env.equals("remote")) {
            Attachments.addVideo();
        }
    }
}
