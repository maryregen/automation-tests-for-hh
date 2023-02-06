package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;

public class LookingForAJobInAnotherCity extends TestBase {

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
