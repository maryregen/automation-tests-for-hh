package ui.tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.EmployerMainPage;
import ui.pages.MainPage;

import static com.codeborne.selenide.Condition.text;
import static io.qameta.allure.Allure.step;

public class TestsEmployers extends TestBase {
    @Test
    @Tag("UI")
    @DisplayName("Проверка текста для работодателя")
    public void checkTitleForEmployers() {
        String indexTitle = "Разместите вакансию на hh.ru";

        MainPage mainPage = MainPage.openPage();
        EmployerMainPage employerPage = mainPage.clickEmployerLink();

        step("Страница должна сожержать текст для работодателя", () -> {
            employerPage.getIndexTitle().shouldHave(text(indexTitle));
        });
    }
}
