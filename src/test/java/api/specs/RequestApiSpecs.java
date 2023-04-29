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

    public static RequestSpecification requestSpec = with()
            .log()
            .all()
            .contentType(ContentType.JSON)
            .baseUri(baseUri)
            .filter(withCustomTemplates());
}


