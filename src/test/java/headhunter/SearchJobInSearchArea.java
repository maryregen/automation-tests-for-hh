package headhunter;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import static io.qameta.allure.Allure.step;

public class SearchJobInSearchArea extends TestBase {

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
}
