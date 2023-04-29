package mobile.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestsMain extends TestBase {
    private String header = "Вакансии для вас";

    @Tag("MOBILE")
    @DisplayName("Проверка заголовка главной страницы с вакансиями")
    @Test
    void checkMainPageHasWelcomeText() {
        mainPage.checkHeader(header);
    }
}
