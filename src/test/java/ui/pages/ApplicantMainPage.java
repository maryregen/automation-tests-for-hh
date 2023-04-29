package ui.pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ApplicantMainPage extends MainPage {
    @Step("Ищем в поиске по выражению {0}")
    public ApplicantSearchPage search(String text) {
        $("[data-qa='search-input']").setValue(text).pressEnter();
        return page(ApplicantSearchPage.class);
    }

    @Step("Страница должна содержать текст для соискателя")
    public ApplicantMainPage checkIndexTitle(String title) {
        $("h3[data-qa='bloko-header-3']").shouldHave(text(title));
        return this;
    }

    @Step("Проверить, что вакансии показываются именно для города {0}")
    public ApplicantMainPage checkWorkInCompanyTitle(String title) {
        $("a[data-qa='index__work-in-company-header']").shouldHave(text(title));
        return this;
    }
}
