package mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

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
    public static void denyNotifications() {
        $(id("com.android.permissioncontroller:id/permission_deny_button"))
                .shouldBe(Condition.enabled)
                .click();
    }

    public SelenideElement getHeader() {
        return $(id("ru.hh.android:id/cell_section_header_large_narrow_text_view"));
    }
}
