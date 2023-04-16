package api.tests;

import api.models.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static api.specs.ApiSpecs.*;
import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;

public class TestsEmployers {
    @Tag("API")
    @DisplayName("Поиск работодателя по определенным словам")
    @ParameterizedTest(name = "Поиск работодателя по слову {0}")
    @ValueSource(strings = {"Вкусвилл", "СберМаркет"})
    void checkEmployersByGivenKeywords(String keyword) {
        step("Искать вакансии по определенным словам", () -> {
            EmployersListResponseModel response = given(getEmployersListRequestSpec)
                    .queryParam("text", keyword)
                    .when()
                    .get()
                    .then()
                    .spec(OKResponseSpec)
                    .extract().as(EmployersListResponseModel.class);

            VacancyResponseModel[] items = response.getItems();
            assertThat(items.length).isNotEqualTo(0);

            if (items.length > 0) {
                for (int i = 0; i < items.length - 1; i++) {
                    assertThat(items[i].getName()).containsIgnoringCase(keyword);
                }
            }
        });
    }
}
