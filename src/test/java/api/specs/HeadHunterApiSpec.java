package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.with;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class HeadHunterApiSpec {
    public static RequestSpecification requestSpecForVacancy = with()
            .log().all()
            .contentType(ContentType.JSON)
            .baseUri("https://api.hh.ru")
            .basePath("/vacancies")
            .filter(withCustomTemplates());

    public static RequestSpecification requestSpecForNegotiation = with()
            .log().all()
            .header("Content-Type","multipart/form-data")
            .contentType(ContentType.JSON)
            .baseUri("https://api.hh.ru")
            .basePath("/negotiations")
            .filter(withCustomTemplates());

    public static ResponseSpecification responseSpecCode200 = new ResponseSpecBuilder()
        .log(STATUS)
        .log(BODY)
        .expectStatusCode(200)
        .build();

    public static ResponseSpecification responseSpecCode201 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .build();

    public static ResponseSpecification responseSpecCode403 = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(403)
            .build();
}


