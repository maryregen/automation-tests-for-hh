package mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class LoginPage {
    @Step("Нажать кнопку выбора пользователя")
    public MainPage close() {
        $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_image_close")).click();
        return page(MainPage.class);
    }
}
