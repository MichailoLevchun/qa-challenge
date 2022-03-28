package com.up42.testautomation.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.up42.testautomation.utils.gson.utils.FieldExclusion;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.given;
import static io.restassured.config.EncoderConfig.encoderConfig;
import static java.util.Arrays.stream;

@Getter
public abstract class BaseClient {
    protected Response response;
    public static Map<String, String> cookies = new HashMap<>();
    private static RestAssuredConfig encoderConfig = config.encoderConfig(
            encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)
    );

    protected BaseClient() {
        config = RestAssuredConfig.config().objectMapperConfig(
                new ObjectMapperConfig().jackson2ObjectMapperFactory(
                        (aClass, s) -> {
                            ObjectMapper objectMapper = new ObjectMapper();
                            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
                            return objectMapper;
                        }));
    }

    protected static Object serialize(Object body) {
        Object payload = body;
        if (!(body instanceof String)) payload = getGsonConfig().toJson(body, body.getClass());
        return payload;
    }

    private static Gson getGsonConfig() {
        return new GsonBuilder().addSerializationExclusionStrategy(
                new FieldExclusion()
        ).create();
    }

    protected RequestSpecification getSpecification(ContentType contentType, Header... headers) {
        RequestSpecification requestSpecification = given()
                .cookies(cookies)
                .contentType(contentType)
                .config(encoderConfig);
        stream(headers).forEach(requestSpecification::header);
        return requestSpecification;
    }
}
