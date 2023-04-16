package ui.pages;

import com.codeborne.selenide.SelenideElement;
import com.sun.tools.javac.Main;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ApplicantMainPage extends MainPage {
    @Step("Ищем в поиске по выражению {0}")
    public ApplicantSearchPage search(String text) {
        $("[data-qa='search-input']").setValue(text).pressEnter();
        return page(ApplicantSearchPage.class);
    }

    public SelenideElement getIndexTitle() {
        return $("h3[data-qa='bloko-header-3']");
    }

    public SelenideElement getWorkInCompanyTitle() {
        return $("a[data-qa='index__work-in-company-header']");
    }
}
