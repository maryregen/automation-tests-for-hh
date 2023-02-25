package headhunter;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import headhunter.pages.SearchThingsOnSite;
import helpers.Attachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    SearchThingsOnSite searchThingsOnSite = new SearchThingsOnSite();

    @BeforeAll
    static void beforeAll() {
        WebDriverProvider provider = new WebDriverProvider();

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @BeforeEach
    void clearCookies() {
        Selenide.clearBrowserCookies();
    }

    @AfterAll
    static void addAttachments() {
        Attachments.screenshotAs("Last screenshot");
        Attachments.pageSource();
        Attachments.browserConsoleLogs();
        Attachments.addVideo();
    }
}
