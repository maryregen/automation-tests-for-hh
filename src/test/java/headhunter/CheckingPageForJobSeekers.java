package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class CheckingPageForJobSeekers extends TestBase {
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

}
