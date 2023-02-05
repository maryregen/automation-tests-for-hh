package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SearchJobInSearchArea {

    @Test
    @Tag("Jenkins")
    public void searchJobForQAAuto() {
        step("Открыть страницу", () -> {
            open("https://hh.ru");
        });
        step("Ввести текст в область поиска", () -> {
            $("[data-qa='search-input']").setValue("QA инженер автоматизация").pressEnter();
        });
        step("Убедиться, что найдены вакансии именно для QA", () -> {
            $("div[data-qa='employer-index-title']").shouldHave(text("Разместите вакансию на hh.ru"));
        });
    }
}
