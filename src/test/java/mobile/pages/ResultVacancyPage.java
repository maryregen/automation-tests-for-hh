package mobile.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class ResultVacancyPage {

    public ResultVacancyPage checkFirstFoundProfessionResult(String profession){
        $$(id("ru.hh.android:id/cell_vacancy_card_text_view_job_position")).first().shouldHave(text(profession));
        return this;
    }

    public ResultVacancyPage checkResponseButtonText(String responseButtonText){
        $$(id("ru.hh.android:id/cell_vacancy_card_button_response")).first().shouldHave(text(responseButtonText));
        return this;
    }

}
