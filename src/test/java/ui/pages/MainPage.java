package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    @Step("Открываем главную страницу")
    public MainPage openPage() {
        open("/");
        return this;
    }

    @Step("Нажимаем по ссылке 'Работодателям'")
    public MainPage clickEmployerLink() {
        SelenideElement link = $("a[data-qa='mainmenu_employer']");
        if (link.exists()) {
            link.click();
        }
        return this;
    }

    @Step("Нажимаем по ссылке 'Соискателям'")
    public MainPage clickApplicantLink() {
        SelenideElement link = $("a[data-qa='mainmenu_applicant']");
        if (link.exists()) {
            link.click();
        }
        return this;
    }

    @Step("Выбираем язык {0}")
    public MainPage changeLocale(String locale) {
        $("[data-qa='change-locale-" + locale + "']").click();
        return this;
    }

    @Step("Выбираем город {0}")
    public MainPage changeRegion(String city) {
        $("[data-page-analytics-event='vacancy_search_region']").click();
        $(byText(city)).click();
        return this;
    }
}
