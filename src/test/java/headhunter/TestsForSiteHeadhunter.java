package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class TestsForSiteHeadhunter extends TestBase {
    @Test
    @Tag("Jenkins")
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
    @Tag("Jenkins")
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
    @Tag("Jenkins")
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
    @Tag("Jenkins")
    public void searchJobForQAAuto() {
        step("Открыть страницу", () -> {
            searchThingsOnSite.openPage();
        });
        step("Ввести текст в область поиска", () -> {
            searchThingsOnSite.inputTextToSearchArea();
        });
        step("Убедиться, что найдены вакансии именно для QA", () -> {
            searchThingsOnSite.findResults();
        });
    }
    @Test
    @Tag("Jenkins")
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
