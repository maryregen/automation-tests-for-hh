package api.tests;

import api.models.ForbiddenErrorResponseModel;
import api.models.ForbiddenResponseModel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static api.specs.RequestApiSpecs.*;
import static api.specs.ResponseApiSpecs.*;
import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class TestsApplicantComments {
    private void checkErrorsContainKeyword(ForbiddenErrorResponseModel[] errors, String keyword) {
        for (ForbiddenErrorResponseModel error : errors) {
            assertThat(error.getType()).containsIgnoringCase(keyword);
        }
    }

    @Tag("API")
    @DisplayName("Удаление комментариев соискателей")
    @ParameterizedTest(name = "Удаление комментария (ID={1}) от соискателя (ID={0})")
    @CsvSource({"1,1", "2,2"})
    void checkApplicantsCommentRemoval(Integer applicantId, Integer commentId) {
        step("Искать вакансии по определенным словам", () -> {
            ForbiddenResponseModel response = given(requestSpec)
                    .when()
                    .delete("/applicant_comments/" + applicantId.toString() + "/" + commentId.toString())
                    .then()
                    .statusCode(403)
                    .spec(responseSpec)
                    .extract()
                    .as(ForbiddenResponseModel.class);

            checkErrorsContainKeyword(response.getErrors(), "forbidden");
        });
    }
}
