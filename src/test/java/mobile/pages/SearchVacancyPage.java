package mobile.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.appium.java_client.AppiumBy.id;

public class SearchVacancyPage {

    public SearchVacancyPage clickMainSearchFilterButton() {

        $(id("ru.hh.android:id/view_main_search_image_button_filters")).click();
        return this;
    }

    public SearchVacancyPage searchProfession(String profession){

        $(id("ru.hh.android:id/cell_text_view_layout_text_view_value")).click();
        $(id("ru.hh.android:id/toolbar_search_query")).sendKeys(profession);
        $(id("ru.hh.android:id/cell_compound_left_image_title_text_view_title")).click();

        return this;
    }

    public SearchVacancyPage clickApplyFilterButton() {

        $(id("ru.hh.android:id/fragment_search_filters_button_apply")).click();
        return this;
    }
}
