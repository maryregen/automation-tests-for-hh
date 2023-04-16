package mobile.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.appium.java_client.AppiumBy.id;

public class MainPage {

    public MainPage checkHeader(String header){
        $(id("ru.hh.android:id/cell_section_header_large_narrow_text_view"))
                .shouldHave(text(header));
        return this;
    }


}
