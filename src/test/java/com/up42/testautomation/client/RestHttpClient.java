package com.up42.testautomation.client;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RestHttpClient extends BaseClient {
    Logger logger = LoggerFactory.getLogger(RestHttpClient.class);

    public Response post(String url, ContentType contentType, Object body, Header... headers) {
        response = getSpecification(contentType, headers)
                .body(serialize(body))
                .log().all()
                .when().post(url)
                .then().log().all()
                .extract().response();
        cookies.putAll(response.getCookies());
        return response;
    }

    public Response get(String url, ContentType contentType, Header... headers) {
        response = getSpecification(contentType, headers)
                .log().all()
                .when().get(url)
                .then().log().all()
                .extract().response();
        cookies.putAll(response.getCookies());
        return response;
    }

    public Response delete(String url, ContentType contentType, Object body, Header... headers) {
        response = getSpecification(contentType, headers)
                .body(serialize(body))
                .log().all()
                .when().delete(url)
                .then().log().all()
                .extract().response();
        cookies.putAll(response.getCookies());
        return response;
    }
}
