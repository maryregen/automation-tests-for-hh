package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestsMain extends TestBase {
    @Test
    @Tag("UI")
    @DisplayName("Проверка смены языка на английский")
    public void checkLanguageSwitcher() {
        String locale = "EN";
        String indexTitle = "There's a job for everyone";

        mainPage.openPage();
        mainPage.changeLocale(locale);
        mainPage.clickApplicantLink();
        applicantMainPage.checkIndexTitle(indexTitle);
    }

    @Test
    @Tag("UI")
    @DisplayName("Проверка смены региона")
    public void checkRegionSwitcher() {
        String city = "Казань";
        String title = "Работа в компаниях Казани";

        mainPage.openPage();
        mainPage.clickApplicantLink();
        mainPage.changeRegion(city);
        mainPage.clickApplicantLink();
        applicantMainPage.checkWorkInCompanyTitle(title);
    }
}
