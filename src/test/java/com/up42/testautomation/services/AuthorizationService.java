package com.up42.testautomation.services;

import com.up42.testautomation.client.RestHttpClient;
import com.up42.testautomation.services.core.BaseService;
import io.restassured.response.Response;

import static com.up42.testautomation.application.endpoints.Endpoints.RETRIEVE_TOKEN_URL;
import static io.restassured.http.ContentType.URLENC;

public class AuthorizationService extends BaseService {

    public AuthorizationService(RestHttpClient client) {
        super(client);
    }

    public Response retrieveAccessToken() {
        return client.post(RETRIEVE_TOKEN_URL, URLENC, "grant_type=client_credentials");
    }

}
