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
                    .spec(responseSpecCode200)
                    .extract()
                    .as(EmployersListResponseModel.class);

            VacancyResponseModel[] vacancies = response.getItems();

            for (VacancyResponseModel vacancy : vacancies) {
                assertThat(vacancy.getName()).containsIgnoringCase(keyword);
            }
            assertThat(vacancies.length).isNotEqualTo(0);
        });
    }
}
