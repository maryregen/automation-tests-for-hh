package headhunter.pages;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchThingsOnSite {
    //String url = "https://hh.ru";
    String text = "QA инженер автоматизация";
    String textForEmployers = "Разместите вакансию на hh.ru";
    String textForJobSeekers = "Работа найдется для каждого";
    String textForJobSeekersEng = "There's a job for everyone";
    String buttonText = "Соискателям";
    String cityText = "Казань";
    String textForCity = "Работа в компаниях Казани";

    public SearchThingsOnSite openPage() {
        open("/");
        return this;
    }
    public SearchThingsOnSite inputTextToSearchArea() {

        $("[data-qa='search-input']").setValue(text).pressEnter();
        return this;
    }
    public SearchThingsOnSite findResults() {

        $("h1[data-qa='bloko-header-3']").shouldHave(text(text));
        return this;
    }
    public SearchThingsOnSite clickButtonForEmployers() {

        $("a[data-qa='mainmenu_employer']").click();
        return this;
    }
    public SearchThingsOnSite clickButtonForJobSeekers() {

        $(byText(buttonText)).click();
        return this;
    }
    public SearchThingsOnSite clickButtonForChangeLanguage() {

        $("[data-qa='change-locale-EN']").click();
        return this;
    }
    public SearchThingsOnSite clickButtonForCity() {

        $("[data-page-analytics-event='vacancy_search_region']").click();
        return this;
    }
    public SearchThingsOnSite clickButtonForChoosingCity() {

        $(byText(cityText)).click();
        return this;
    }
    public SearchThingsOnSite findTextForEmployers() {

        $("div[data-qa='employer-index-title']").shouldHave(text(textForEmployers));
        return this;
    }
    public SearchThingsOnSite findTextForJobSeekers() {

        $("h3[data-qa='bloko-header-3']").shouldHave(text(textForJobSeekers));
        return this;
    }
    public SearchThingsOnSite findTextInAnotherLanguage() {

        $("h3[data-qa='bloko-header-3']").shouldHave(text(textForJobSeekersEng));
        return this;
    }
    public SearchThingsOnSite findTextForCity () {
        $("a[data-qa='index__work-in-company-header']").shouldHave(text(textForCity));
        return this;
    }

}
