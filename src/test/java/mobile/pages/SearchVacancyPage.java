package mobile.pages;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

import io.qameta.allure.Step;

public class SearchVacancyPage {

    @Step("Добавить фильтр по профессии {0}")
    public SearchVacancyPage setProfession(String profession) {
        $(id("ru.hh.android:id/cell_text_view_layout_text_view_value")).click();
        $(id("ru.hh.android:id/toolbar_search_query")).sendKeys(profession);
        $(id("ru.hh.android:id/cell_compound_left_image_title_text_view_title")).click();

        return this;
    }

    @Step("Нажать на кнопку 'Сохранить' на странице фильтров")
    public ResultVacancyPage applyFilter() {
        $(id("ru.hh.android:id/fragment_search_filters_button_apply")).click();
        return page(ResultVacancyPage.class);
    }
}
