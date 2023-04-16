package mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class ResultVacancyPage {

    @Step("Проверить по первой выдаче, что нашлась профессия {0}")
    public ResultVacancyPage checkFirstResult(String text) {
        $$(id("ru.hh.android:id/cell_vacancy_card_text_view_job_position")).first().shouldHave(text(text));
        return this;
    }

    @Step("Проверить по первой выдаче, что у вакансии есть кнопка '{0}'")
    public ResultVacancyPage checkVacancyCardResponseButton(String text) {
        $$(id("ru.hh.android:id/cell_vacancy_card_button_response")).first().shouldHave(text(text));
        return this;
    }
}
