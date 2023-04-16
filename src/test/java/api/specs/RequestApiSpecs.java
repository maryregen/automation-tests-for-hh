package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.with;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api.helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;

public class RequestApiSpecs {
    public static final String baseUri = "https://api.hh.ru";

    // Request specifications
    public static RequestSpecification getVacanciesListRequestSpec = with()
            .log()
            .all()
            .contentType(ContentType.JSON)
            .baseUri(baseUri)
            .basePath("/vacancies")
            .filter(withCustomTemplates());

    public static RequestSpecification getEmployersListRequestSpec = with()
            .log()
            .all()
            .contentType(ContentType.JSON)
            .baseUri(baseUri)
            .basePath("/employers")
            .filter(withCustomTemplates());

    public static RequestSpecification deleteApplicantCommentRequestSpec = with()
            .log()
            .all()
            .contentType(ContentType.JSON)
            .baseUri(baseUri)
            .basePath("/applicant_comments")
            .filter(withCustomTemplates());

    public static RequestSpecification postNegotiationRequestSpec = with()
            .log()
            .all()
            .header("Content-Type","multipart/form-data")
            .contentType(ContentType.JSON)
            .baseUri(baseUri)
            .basePath("/negotiations")
            .filter(withCustomTemplates());
}


