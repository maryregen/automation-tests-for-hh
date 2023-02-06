package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CheckingPageForEmployers extends TestBase {

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
}
