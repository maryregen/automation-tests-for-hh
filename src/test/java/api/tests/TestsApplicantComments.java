package api.tests;

import api.models.ForbiddenErrorResponseModel;
import api.models.ForbiddenResponseModel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static api.specs.ApiSpecs.*;
import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class TestsApplicantComments {
    // FIXME: для успешного ответа DELETE-запроса к api.hh.ru необходима авторизация. К сожалению, авторизация
    // требует подтверждения со стороны команды разработки и для учебного проекта получить учётные данные
    // невозможно. В комментариях указан пример того, как это могло бы выглядеть при наличии соответствующих
    // доступов.
    //
    // Сейчас мы обрабатываем только 403: удалить комментарий соискателя невозможно из-за отсутствия доступа
    @Tag("API")
    @DisplayName("Удаление комментариев соискателей")
    @ParameterizedTest(name = "Удаление комментария (ID={1}) от соискателя (ID={0})")
    @CsvSource({"1,1", "2,2"})
    void checkApplicantsCommentRemoval(Integer applicantId, Integer commentId) {
        step("Искать вакансии по определенным словам", () -> {
            ForbiddenResponseModel response = given(deleteApplicantCommentRequestSpec)
                    .when()
                    .delete(applicantId.toString() + "/" + commentId.toString())
                    .then()
                    // .spec(responseSpecCode204)
                    .spec(responseSpecCode403)
                    .extract()
                    .as(ForbiddenResponseModel.class);

            for (ForbiddenErrorResponseModel error : response.getErrors()) {
                assertThat(error.getType()).containsIgnoringCase("forbidden");
            }

            /*
            given(deleteApplicantCommentRequestSpec)
                    .when()
                    .delete(applicantId.toString() + "/" + commentId.toString())
                    .then()
                    .spec(responseSpecCode204);
             */
        });
    }
}
