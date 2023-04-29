package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestsApplicants extends TestBase {
    @Test
    @Tag("UI")
    @DisplayName("Проверка текста для соискателя")
    public void checkTitleForApplicants() {
        String indexTitle = "Работа найдётся для каждого";

        mainPage.openPage();
        mainPage.clickApplicantLink();
        applicantMainPage.checkIndexTitle(indexTitle);
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий по профессии для соискателя")
    public void searchVacanciesByProfession() {
        String search = "QA инженер автоматизация";

        mainPage.openPage();
        mainPage.clickApplicantLink();
        applicantMainPage.searchVacanciesByText(search);
        applicantSearchPage.checkSearchHeader(search);
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий по компании для соискателя")
    public void searchVacanciesByCompany() {
        String search = "Яндекс";

        mainPage.openPage();
        mainPage.clickApplicantLink();
        applicantMainPage.searchVacanciesByText(search);
        applicantSearchPage.checkSearchHeader(search);
    }

    @Test
    @Tag("UI")
    @DisplayName("Поиск вакансий по должности в каталоге для соискателя")
    public void searchVacanciesByPosition() {
        String search = "Старший системный администратор";
        String match = "Работа старшим системным администратором";

        mainPage.openPage();
        mainPage.clickApplicantLink();
        applicantMainPage.searchVacanciesByText(search);
        applicantSearchPage.checkSearchHeader(match);
    }
}
