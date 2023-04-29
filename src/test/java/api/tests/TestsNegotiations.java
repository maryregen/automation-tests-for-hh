package api.tests;

import api.models.*;
import org.junit.jupiter.api.*;

import static api.specs.RequestApiSpecs.*;
import static api.specs.ResponseApiSpecs.*;
import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class TestsNegotiations {
    private void checkErrorsContainKeyword(ForbiddenErrorResponseModel[] errors, String keyword) {
        for (ForbiddenErrorResponseModel error : errors) {
            assertThat(error.getType()).containsIgnoringCase(keyword);
        }
    }

    private TestData testData = new TestData();

    @Tag("API")
    @DisplayName("Отклик на определенную вакансию без авторизации")
    @Test
    public void checkNegotiationStatus() {
        NegotiationBodyRequestModel body = new NegotiationBodyRequestModel();
        body.setVacancyId(testData.vacancyId);
        body.setResumeId(testData.resumeId);
        body.setMessage(testData.message);

        step("Проверить статус ответа при отклике без авторизации", () -> {
            ForbiddenResponseModel response = given(requestSpec)
                    .body(body)
                    .when()
                    .post("/negotiations")
                    .then()
                    .statusCode(403)
                    .spec(responseSpec)
                    .extract()
                    .as(ForbiddenResponseModel.class);

            checkErrorsContainKeyword(response.getErrors(), "forbidden");
        });
    }
}
