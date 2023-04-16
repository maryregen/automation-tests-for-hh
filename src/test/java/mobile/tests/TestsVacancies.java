package mobile.tests;

import mobile.pages.ResultVacancyPage;
import mobile.pages.SearchVacancyPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class TestsVacancies extends TestBase {
    private String profession = "Продавец";
    private String responseButtonText = "Откликнуться";

    @Tag("MOBILE")
    @DisplayName("Поиск вакансий по профессии")
    @Test
    void checkVacanciesSearchByGivenProfession() {
        SearchVacancyPage searchPage = mainPage.pressFilterButton();
        searchPage.setProfession(profession);
        ResultVacancyPage resultPage = searchPage.applyFilter();

        step("Проверить по первой выдаче, что нашлась та профессия", () -> {
            resultPage.getFirstResult().shouldHave(text(profession));
        });
    }

    @Tag("MOBILE")
    @DisplayName("Вакансия содержит кнопку 'Откликнуться'")
    @Test
    void checkVacancyHasResponseButton() {
        SearchVacancyPage searchPage = mainPage.pressFilterButton();
        searchPage.setProfession(profession);
        ResultVacancyPage resultPage = searchPage.applyFilter();

        step("Проверить по первой выдаче, что у вакансии есть кнопка 'Откликнуться'", () -> {
            resultPage.getVacancyCardResponseButton().shouldHave(text(responseButtonText));
        });
    }
}
