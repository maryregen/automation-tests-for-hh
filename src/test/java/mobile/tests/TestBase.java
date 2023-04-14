package mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import mobile.drivers.BrowserstackMobileDriver;
import mobile.drivers.EmulationMobileDriver;
import mobile.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.pages.ChooseUserPage;
import mobile.pages.MainPage;
import mobile.pages.SearchVacancyPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;

    public class TestBase {
        ChooseUserPage chooseUserPage = new ChooseUserPage();
        MainPage mainPage = new MainPage();
        SearchVacancyPage searchVacancyPage = new SearchVacancyPage();

        public static String deviceHost = System.getProperty("deviceHost");
        @BeforeAll
        static void beforeAll() {

            if (deviceHost.equals("emulation")) {
                Configuration.browser = EmulationMobileDriver.class.getName();
            } else {
                if (deviceHost.equals("browserstack")) {
                    Configuration.browser = BrowserstackMobileDriver.class.getName();
                }
            }
            Configuration.browserSize = null;
        }

        @BeforeEach
        void addListener() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            open();
        }

        @AfterEach
        void afterEach() {

            Attach.pageSource();

            closeWebDriver();
        }

    }
