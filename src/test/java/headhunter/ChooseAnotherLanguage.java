package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class ChooseAnotherLanguage extends TestBase {

    @Test
    @Tag("Jenkins")
    public void switchLanguageToEnglish() {
        step("Открыть страницу", () -> {
            open("https://hh.ru");
        });
        step("Нажать на кнопку смены языка", () -> {
            $("[data-qa='change-locale-EN']").click();
        });
        step("Убедиться, что текст сменился на английский", () -> {
            $("h3[data-qa='bloko-header-3']").shouldHave(text("There's a job for everyone"));
        });
    }
}
