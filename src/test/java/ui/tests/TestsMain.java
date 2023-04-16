package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.ApplicantMainPage;
import ui.pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class TestsMain extends TestBase {
    @Test
    @Tag("UI")
    @DisplayName("Проверка смены языка на английский")
    public void checkLanguageSwitcher() {
        String locale = "EN";
        String indexTitle = "There's a job for everyone";

        MainPage mainPage = MainPage.openPage();
        mainPage.changeLocale(locale);

        ApplicantMainPage applicantPage = mainPage.clickApplicantLink();

        step("Страница должна содержать текст для соискателя на английском языке", () -> {
            applicantPage.getIndexTitle().shouldHave(text(indexTitle));
        });
    }

    @Test
    @Tag("UI")
    @DisplayName("Проверка смены региона")
    public void checkRegionSwitcher() {
        String search = "Казань";
        String match = "Работа в компаниях Казани";

        MainPage mainPage = MainPage.openPage();
        mainPage.changeRegion(search);
        ApplicantMainPage applicantPage = mainPage.clickApplicantLink();

        step("Проверить, что вакансии показываются именно для города Казань", () -> {
            applicantPage.getWorkInCompanyTitle().shouldHave(text(match));
        });
    }
}
