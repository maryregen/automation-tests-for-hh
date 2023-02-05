package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckingPageForEmployers extends TestBase {

    @Test
    @Tag("Jenkins")
    public void checkTextForEmployers() {
        step("Открыть страницу", () -> {
            open("https://hh.ru");
        });
        step("Найти раздел 'Работодателям' и кликнуть", () -> {
            $("a[data-qa='mainmenu_employer']").click();
        });
        step("Страница должна содержать текст для работодателя", () -> {
            $("div[data-qa='employer-index-title']").shouldHave(text("Разместите вакансию на hh.ru"));
        });
    }
}
