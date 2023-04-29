package ui.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class EmployerMainPage {

    @Step("Страница должна сожержать текст для работодателя")
    public EmployerMainPage checkIndexTitle(String title) {
        $("div[data-qa='employer-index-title']").shouldHave(text(title));
        return this;
    }
}
