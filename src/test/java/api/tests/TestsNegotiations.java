package api.tests;

import api.models.*;
import org.junit.jupiter.api.*;

import static api.specs.ApiSpecs.*;
import static io.restassured.RestAssured.given;
import static io.qameta.allure.Allure.step;

public class TestsNegotiations {

    TestData testData = new TestData();

    @Tag("API")
    @DisplayName("Отклик на определенную вакансию без авторизации")
    @Test
    public void checkNegotiationStatus() {
        NegotiationBodyRequestModel body = new NegotiationBodyRequestModel();
        body.setVacancyId(testData.vacancyId);
        body.setResumeId(testData.resumeId);
        body.setMessage(testData.message);

        // FIXME: для успешного POST-запроса к api.hh.ru необходима авторизация. К сожалению, авторизация
        // требует подтверждения со стороны команды разработки и для учебного проекта получить учётные данные
        // невозможно. В комментариях указан пример того, как это могло бы выглядеть при наличии соответствующих
        // доступов.
        //
        // Сейчас мы обрабатываем только 403: на указанную вакансию невозможно откликнуться по причине
        // отсутствия доступа к ней.
        step("Проверить статус ответа при отклике без авторизации", () -> {
            given(postNegotiationRequestSpec)
                .body(body)
                .when()
                .post()
                .then()
                // .spec(responseSpecCode201);
                .spec(responseSpecCode403);
        });
    }
}
