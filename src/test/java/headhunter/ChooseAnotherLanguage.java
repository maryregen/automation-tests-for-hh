package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class ChooseAnotherLanguage extends TestBase {

    @Test
    @Tag("Jenkins")
    public void switchLanguageToEnglish() {
        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Нажать на кнопку смены языка", () -> {
            searchThingsOnSite.clickButtonForChangeLanguage();
        });
        step("Убедиться, что текст сменился на английский", () -> {
            searchThingsOnSite.findTextInAnotherLanguage();

        });
    }
}
