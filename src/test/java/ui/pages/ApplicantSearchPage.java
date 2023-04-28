package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class ApplicantSearchPage extends MainPage {

    @Step("Получаем элемент заголовка страницы поиска")
    public ApplicantSearchPage checkSearchHeader(String title) {
        SelenideElement vacanciesHeader = $("div[data-qa='vacancies-search-header'] h1[data-qa='bloko-header-3']");
        SelenideElement catalogHeader = $("h1[data-qa='vacancies-catalog-header']");

        if (vacanciesHeader.exists()) {
            vacanciesHeader.shouldHave(text(title));
            return this;
        }
        catalogHeader.shouldHave(text(title));
        return this;
    }
}
