package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    @Step("Открываем главную страницу")
    public static MainPage openPage() {
        open("/");
        return page(MainPage.class);
    }

    @Step("Нажимаем по ссылке 'Работодателям'")
    public EmployerMainPage clickEmployerLink() {
        SelenideElement link = $("a[data-qa='mainmenu_employer']");
        if (link.exists()) {
            link.click();
        }
        return page(EmployerMainPage.class);
    }

    @Step("Нажимаем по ссылке 'Соискателям'")
    public ApplicantMainPage clickApplicantLink() {
        SelenideElement link = $("a[data-qa='mainmenu_applicant']");
        if (link.exists()) {
            link.click();
        }
        return page(ApplicantMainPage.class);
    }

    @Step("Выбираем город {0}")
    public MainPage changeRegion(String city) {
        $("[data-page-analytics-event='vacancy_search_region']").click();
        $(byText(city)).click();
        return this;
    }

    @Step("Выбираем язык {0}")
    public MainPage changeLocale(String locale) {
        $("[data-qa='change-locale-" + locale + "']").click();
        return this;
    }
}
