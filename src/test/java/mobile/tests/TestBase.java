package mobile.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import mobile.drivers.BrowserstackMobileDriver;
import mobile.drivers.EmulationMobileDriver;
import mobile.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import mobile.pages.ChooseUserPage;
import mobile.pages.MainPage;
import mobile.pages.ResultVacancyPage;
import mobile.pages.SearchVacancyPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
        ChooseUserPage chooseUserPage = new ChooseUserPage();
        MainPage mainPage = new MainPage();
        SearchVacancyPage searchVacancyPage = new SearchVacancyPage();

        ResultVacancyPage resultVacancyPage = new ResultVacancyPage();

        public static String deviceHost = System.getProperty("deviceHost");
        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = null;

            if (deviceHost.equals("emulator")) {
                Configuration.browser = EmulationMobileDriver.class.getName();
            } else {
                if (deviceHost.equals("browserstack")) {
                    Configuration.browser = BrowserstackMobileDriver.class.getName();
                }
            }
        }

        @BeforeEach
        void addListener() {
            SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
            open();
        }

        @AfterEach
        void afterEach() {

            //if (deviceHost.equals("browserstack")) {
            //Attach.pageSource();
//                String sessionId = Selenide.sessionId().toString();
//                Attach.addVideo(sessionId);
            //}

            closeWebDriver();
        }
    }
