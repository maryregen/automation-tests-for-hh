package api.tests;

import api.models.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static api.specs.HeadHunterApiSpec.*;
import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class HeadHunterApiTests extends TestData {

    TestData testData = new TestData();

    @Tag("API")
    @DisplayName("Проверка статуса ответа метода vacancies")
    @Test
    void checkPageStatus() {
        step("Проверить статус ответа метода vacancies", () -> {
            given(requestSpecForVacancy)
                    .when()
                    .get()
                    .then()
                    .spec(responseSpecCode200);
        });
    }

    @Tag("API")
    @DisplayName("Поиск вакансии по определенным словам")
    @ParameterizedTest(name = "Поиск вакансии по слову {0}")
    @ValueSource(strings = {"Продавец", "Консультант"})
    void checkParticularVacancy(String particularVacancy) {
        step("Искать вакансии по определенным словам", () -> {
            GetResponseLombokModel response = given(requestSpecForVacancy)
                    .queryParam("text", particularVacancy)
                    .when()
                    .get()
                    .then()
                    .spec(responseSpecCode200)
                    .extract().as(GetResponseLombokModel.class); // десериализация ответа

            CreateResponseItemsModel[] items = response.getItems();
            assertThat(items.length).isNotEqualTo(0);

            if (items.length > 0) {
                for (int i = 0; i < items.length - 1; i++) {
                    assertThat(items[i].getName()).containsIgnoringCase(particularVacancy);
                }
            }
        });
    }

    @Tag("API")
    @DisplayName("Отклик на определенную вакансию без авторизации")
    @Test
    public void negotiationOnVacancy() {

        RequestBodyNegotiationLombokModel requestBodyNegotiationLombokModel = new RequestBodyNegotiationLombokModel();
        requestBodyNegotiationLombokModel.setVacancyId(testData.vacancyId);
        requestBodyNegotiationLombokModel.setResumeId(testData.resumeId);
        requestBodyNegotiationLombokModel.setMessage(testData.message);

         step("Проверить статус ответа при отклике без авторизации", () -> {
            given(requestSpecForNegotiation)
                    .body(requestBodyNegotiationLombokModel) // формирование body в post-запросе
                    .when()
                    .post()
                    .then()
                    //.spec(responseSpecCode201); Для успешного ответа post-запроса api.headhunter.ru необходима сложная многоступенчатая авторизация
                    .spec(responseSpecCode403); //403 Forbidden - если на указанную вакансию не возможно откликнуться, по причине отсутствия доступа к ней
        });
    }
}

