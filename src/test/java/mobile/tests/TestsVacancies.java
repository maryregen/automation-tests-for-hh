package mobile.tests;

import mobile.pages.ResultVacancyPage;
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
        mainPage.pressFilterButton()
                .setProfession(profession)
                .applyFilter()
                .checkFirstResult(profession);
    }

    @Tag("MOBILE")
    @DisplayName("Вакансия содержит кнопку 'Откликнуться'")
    @Test
    void checkVacancyHasResponseButton() {
        mainPage.pressFilterButton()
                .setProfession(profession)
                .applyFilter()
                .checkVacancyCardResponseButton(responseButtonText);
    }
}
