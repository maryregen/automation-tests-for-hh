package mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {
    @Step("Нажать на кнопку отображения фильтров")
    public SearchVacancyPage pressFilterButton() {
        $(id("ru.hh.android:id/view_main_search_image_button_filters")).click();
        return page(SearchVacancyPage.class);
    }

    @Step("Запретить нотификации")
    public MainPage denyNotifications() {
        $(id("com.android.permissioncontroller:id/permission_deny_button"))
                .shouldBe(Condition.enabled)
                .click();
        return this;
    }

    @Step("Текст заголовка страницы с вакансиями {0}")
    public MainPage checkHeader(String header) {
        $(id("ru.hh.android:id/cell_section_header_large_narrow_text_view")).shouldHave(text(header));
        return this;
    }
}
