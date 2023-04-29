package mobile.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
