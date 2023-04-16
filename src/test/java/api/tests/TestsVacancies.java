package api.tests;

import api.models.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static api.specs.ApiSpecs.*;
import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;

public class TestsVacancies {
    @Tag("API")
    @DisplayName("Проверка статуса ответа метода vacancies")
    @Test
    void checkVacanciesList() {
        step("Проверить статус ответа метода vacancies", () -> {
            given(getVacanciesListRequestSpec)
                    .when()
                    .get()
                    .then()
                    .spec(OKResponseSpec);
        });
    }

    @Tag("API")
    @DisplayName("Поиск вакансии по определенным словам")
    @ParameterizedTest(name = "Поиск вакансии по слову {0}")
    @ValueSource(strings = {"Продавец", "Консультант"})
    void checkVacanciesByGivenKeywords(String keyword) {
        step("Искать вакансии по определенным словам", () -> {
            EmployersListResponseModel response = given(getVacanciesListRequestSpec)
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

