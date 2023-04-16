package mobile.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.AppiumBy.id;

public class ChooseUserPage {
    // String denyText = "Don’t allow";

    public ChooseUserPage pressButton() {
        $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_image_close")).click();
        return this;
    }

    public ChooseUserPage denyNotification() {
        SelenideElement denyButton = $(id("com.android.permissioncontroller:id/permission_deny_button"));
        denyButton.shouldBe(Condition.enabled);
                //.shouldHave(text(denyText));
        denyButton.click();
        return this;
    }
}
