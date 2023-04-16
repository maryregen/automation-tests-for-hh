package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsForSiteHeadhunter extends TestBase {
    @Test
    @Tag("UI")
    @DisplayName("Проверка текста для работодателя")
    public void checkTextForEmployers() {
        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Найти раздел 'Работодателям' и кликнуть", () -> {
            searchThingsOnSite.clickButtonForEmployers();
        });
        step("Страница должна содержать текст для работодателя", () -> {
            searchThingsOnSite.findTextForEmployers();
        });
    }
    @Test
    @Tag("UI")
    @DisplayName("Проверка текста для работодателя")
    public void checkTextForJobSeekers() {
        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Найти раздел 'Соискателям' и кликнуть", () -> {
            searchThingsOnSite.clickButtonForJobSeekers();
        });
        step("Страница должна содержать текст для соискателя", () -> {
            searchThingsOnSite.findTextForJobSeekers();
        });
    }
    @Test
    @Tag("UI")
    @DisplayName("Изменение языка на английский")
    public void switchLanguageToEnglish() {
        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Нажать на кнопку смены языка", () -> {
            searchThingsOnSite.clickButtonForChangeLanguage();
        });
        step("Убедиться, что текст сменился на английский", () -> {
            searchThingsOnSite.findTextInAnotherLanguage();

        });
    }
    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий по профессии")
    public void searchJobForProfession() {
        String text = "QA инженер автоматизация";

        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Ввести текст в область поиска", () -> {
            searchThingsOnSite.inputTextToSearchArea(text);
        });
        step("Убедиться, что найдены вакансии именно для QA", () -> {
            searchThingsOnSite.findVacanciesResults(text);
        });
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск должности в каталоге")
    public void searchJobForPosition() {
        String position = "Старший системный администратор";
        String header = "Работа старшим системным администратором";

        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Ввести текст в область поиска", () -> {
            searchThingsOnSite.inputTextToSearchArea(position);
        });
        step("Убедиться, что найдены вакансии по позиции старшего системного администратора", () -> {
            searchThingsOnSite.findCatalogResults(header);
        });
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий по имени компании")
    public void searchJobForCompany() {
        String text = "Яндекс";
        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Ввести текст в область поиска", () -> {
            searchThingsOnSite.inputTextToSearchArea(text);
        });
        step("Убедиться, что найдены вакансии именно от компании Яндекс", () -> {
            searchThingsOnSite.findVacanciesResults(text);
        });
    }

    @Test
    @Tag("UI")
    @DisplayName("Проверка вакансий для определенного города")
    public void chooseAnotherCity() {
        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Нажать на кнопку города", () -> {
            searchThingsOnSite.clickButtonForCity();
        });
        step("Выбрать город Казань", () -> {
            searchThingsOnSite.clickButtonForChoosingCity();
        });
        step("Проверить, что вакансии показываются именно для города Казань", () -> {
            searchThingsOnSite.findTextForCity();
        });
    }
}
