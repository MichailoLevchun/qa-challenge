package com.up42.testautomation.application.endpoints;

import com.up42.testautomation.utils.Config;

import static io.restassured.RestAssured.baseURI;

public class Endpoints {
    public static String PROJECT_ID = Config.get().value("PROJECT_ID");

    static {
        baseURI  = Config.get().value("envUrl");
    }

    public static final String RETRIEVE_TOKEN_URL = "https://"
            .concat(PROJECT_ID)
            .concat(":")
            .concat(Config.get().value("PROJECT_API_KEY"))
            .concat("@api.up42.com/oauth/token");

    public static final String PROJECT_URI = baseURI
            .concat("/projects/")
            .concat(PROJECT_ID);

    public static final String WORKFLOW_URI = baseURI
            .concat("/projects/")
            .concat(PROJECT_ID)
            .concat("/workflows");
}

