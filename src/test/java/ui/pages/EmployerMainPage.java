package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class EmployerMainPage extends MainPage {
    @Step("Ищем в поиске по выражению {0}")
    public EmployerSearchPage search(String text) {
        $("[data-qa='search-input']").setValue(text).pressEnter();
        return page(EmployerSearchPage.class);
    }

    @Step("Страница должна сожержать текст для работодателя")
    public EmployerMainPage checkIndexTitle(String title) {
        $("div[data-qa='employer-index-title']").shouldHave(text(title));
        return this;
    }
}
