package mobile.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class HeadHunterAndroidTests extends TestBase {
    String header = "Вакансии для вас";
    String profession = "Продавец";
    String responseButtonText = "Откликнуться";

    @BeforeEach
    public void setUp() {

        step("Нажать кнопку выбора пользователя", () -> {
            chooseUserPage.pressButton();
        });
        step("Запретить нотификации", () -> {
            chooseUserPage.denyNotification();
        });
    }

    @Tag("MOBILE")
    @DisplayName("Проверка заголовка главной страницы с вакансиями")
    @Test
    void getMainPageWithVacanciesTest() {
        step("Текст заголовка страницы с вакансиями 'Вакансии для вас'", () -> {
            mainPage.checkHeader(header);
        });
    }

    @Tag("MOBILE")
    @DisplayName("Поиск вакансий по профессии")
    @Test
    void getParticularVacanciesBasedOnProfession() {
        step("Нажать на кнопку отображения фильтров", () -> {
            searchVacancyPage.clickMainSearchFilterButton();
        });
        step("Добавить фильтр по профессии", () -> {
            searchVacancyPage.searchProfession(profession);
        });
        step("Нажать на кнопку 'Сохранить' на странице фильтров", () -> {
            searchVacancyPage.clickApplyFilterButton();
        });
        step("Проверить по первой выдаче, что нашлась та профессия", () -> {
            resultVacancyPage.checkFirstFoundProfessionResult(profession);
        });
    }

    @Tag("MOBILE")
    @DisplayName("Вакансия содержит кнопку 'Откликнуться'")
    @Test
    void vacancyHasResponseButton() {
        step("Нажать на кнопку отображения фильтров", () -> {
            searchVacancyPage.clickMainSearchFilterButton();
        });
        step("Добавить фильтр по профессии", () -> {
            searchVacancyPage.searchProfession(profession);
        });
        step("Нажать на кнопку 'Сохранить' на странице фильтров", () -> {
            searchVacancyPage.clickApplyFilterButton();
        });
        step("Проверить по первой выдаче, что у вакансии есть кнопка 'Откликнуться'", () -> {
            resultVacancyPage.checkResponseButtonText(responseButtonText);
        });
    }
}
