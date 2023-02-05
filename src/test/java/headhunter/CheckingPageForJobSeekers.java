package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CheckingPageForJobSeekers {
    @Test
    @Tag("Jenkins")
    public void checkTextForJobSeekers() {
        step("Открыть страницу", () -> {
            open("https://hh.ru");
        });
        step("Найти раздел 'Соискателям' и кликнуть", () -> {
            $(byText("Соискателям")).click();
        });
        step("Страница должна содержать текст для соискателя", () -> {
            $("h3[data-qa='bloko-header-3']").shouldHave(text("Работа найдется для каждого"));
        });
    }

}
