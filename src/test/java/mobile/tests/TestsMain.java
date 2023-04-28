package mobile.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class TestsMain extends TestBase {
    private String header = "Вакансии для вас";

    @Tag("MOBILE")
    @DisplayName("Проверка заголовка главной страницы с вакансиями")
    @Test
    void checkMainPageHasWelcomeText() {
        mainPage.checkHeader(header);
    }
}
