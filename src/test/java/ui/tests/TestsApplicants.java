package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.ApplicantMainPage;
import ui.pages.ApplicantSearchPage;
import ui.pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class TestsApplicants extends TestBase {
    @Test
    @Tag("UI")
    @DisplayName("Проверка текста для соискателя")
    public void checkTitleForApplicants() {
        String indexTitle = "Работа найдётся для каждого";

        MainPage mainPage = MainPage.openPage();
        ApplicantMainPage applicantPage = mainPage.clickApplicantLink();

        step("Страница должна содержать текст для соискателя", () -> {
            applicantPage.getIndexTitle().shouldHave(text(indexTitle));
        });
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий по профессии для соискателя")
    public void searchVacanciesByProfession() {
        String search = "QA инженер автоматизация";

        MainPage mainPage = MainPage.openPage();
        ApplicantMainPage applicantPage = mainPage.clickApplicantLink();
        ApplicantSearchPage applicantSearchPage = applicantPage.search(search);

        step("Убедиться, что найдены вакансии именно для QA", () -> {
            applicantSearchPage.getSearchHeader().shouldHave(text(search));
        });
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий по компании для соискателя")
    public void searchVacanciesByCompany() {
        String search = "Яндекс";

        MainPage mainPage = MainPage.openPage();
        ApplicantMainPage applicantPage = mainPage.clickApplicantLink();
        ApplicantSearchPage applicantSearchPage = applicantPage.search(search);

        step("Убедиться, что найдены вакансии компании Яндекс", () -> {
            applicantSearchPage.getSearchHeader().shouldHave(text(search));
        });
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий по должности в каталоге для соискателя")
    public void searchVacanciesByPosition() {
        String search = "Старший системный администратор";
        String match = "Работа старшим системным администратором";

        MainPage mainPage = MainPage.openPage();
        ApplicantMainPage applicantPage = mainPage.clickApplicantLink();
        ApplicantSearchPage applicantSearchPage = applicantPage.search(search);

        step("Убедиться, что найдены вакансии для должности", () -> {
            applicantSearchPage.getSearchHeader().shouldHave(text(match));
        });
    }
}