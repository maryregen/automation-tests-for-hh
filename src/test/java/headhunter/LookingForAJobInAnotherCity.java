package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LookingForAJobInAnotherCity extends TestBase {

    @Test
    @Tag("Jenkins")
    public void chooseAnotherCity() {
        step("Открыть страницу", () -> {
            open("https://hh.ru");
        });
        step("Нажать на кнопку города", () -> {
            $("[data-page-analytics-event='vacancy_search_region']").click();
        });
        step("Выбрать город Казань", () -> {
            $(byText("Казань")).click();
        });
        step("Проверить, что вакансии показываются именно для города Казань", () -> {
            $("a[data-qa='index__work-in-company-header']").shouldHave(text("Работа в компаниях Казани"));
        });
    }
}
