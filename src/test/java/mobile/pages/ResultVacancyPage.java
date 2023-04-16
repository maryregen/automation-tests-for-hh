package mobile.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class ResultVacancyPage {

    public SelenideElement getFirstResult() {
        return $$(id("ru.hh.android:id/cell_vacancy_card_text_view_job_position")).first();
    }

    public SelenideElement getVacancyCardResponseButton() {
        return $$(id("ru.hh.android:id/cell_vacancy_card_button_response")).first();
    }
}
