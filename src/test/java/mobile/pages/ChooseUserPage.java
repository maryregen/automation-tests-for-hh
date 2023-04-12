package mobile.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.appium.java_client.AppiumBy.id;

public class ChooseUserPage {
    String denyText = "Don’t allow";

    public ChooseUserPage pressButton() {
        $(id("ru.hh.android:id/fragment_intentions_onboarding_choose_direction_image_close")).click();
        return this;
    }

    public ChooseUserPage denyNotification() {
        $(id("com.android.permissioncontroller:id/permission_deny_button"))
                .shouldHave(text(denyText));
        $(id("com.android.permissioncontroller:id/permission_deny_button")).click();
        return this;
    }
}
