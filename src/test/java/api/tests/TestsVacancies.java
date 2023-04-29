package api.tests;

import api.models.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static api.specs.RequestApiSpecs.*;
import static api.specs.ResponseApiSpecs.*;
import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.*;

public class TestsVacancies {
    private void checkVacanciesContainKeyword(VacancyResponseModel[] vacancies, String keyword) {
        for (VacancyResponseModel vacancy : vacancies) {
            assertThat(vacancy.getName()).containsIgnoringCase(keyword);
        }
    }

    @Tag("API")
    @DisplayName("Проверка статуса ответа метода vacancies")
    @Test
    void checkVacanciesList() {
        step("Проверить статус ответа метода vacancies", () -> {
            given(requestSpec)
                    .when()
                    .get("/vacancies")
                    .then()
                    .statusCode(200)
                    .spec(responseSpec);
        });
    }

    @Tag("API")
    @DisplayName("Поиск вакансии по определенным словам")
    @ParameterizedTest(name = "Поиск вакансии по слову {0}")
    @ValueSource(strings = {"Продавец", "Консультант"})
    void checkVacanciesByGivenKeywords(String keyword) {
        step("Искать вакансии по определенным словам", () -> {
            EmployersListResponseModel response = given(requestSpec)
                    .queryParam("text", keyword)
                    .when()
                    .get("/vacancies")
                    .then()
                    .statusCode(200)
                    .spec(responseSpec)
                    .extract()
                    .as(EmployersListResponseModel.class);

            VacancyResponseModel[] vacancies = response.getItems();
            checkVacanciesContainKeyword(vacancies, keyword);
            assertThat(vacancies.length).isNotEqualTo(0);
        });
    }
}
