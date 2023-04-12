package mobile.tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class AndroidTests extends TestBase {

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

        step("Текст заголовка страницы с вакансиями 'Вакансии для вас", () -> {
            mainPage.checkHeader();
        });
    }

    @Tag("MOBILE")
    @DisplayName("Поиск вакансий по заданному параметру")
    @Test
    void getParticularVacanciesBasedOnParameter() {

        step("Добавить фильтр", () -> {
            searchVacancyPage.addParameter();
        });

        step("Проверить, что результаты найдены по должности", () -> {
            searchVacancyPage.checkFirstFoundResult();
        });


    }


}
