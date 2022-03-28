package com.up42.testautomation.services.core;

import com.up42.testautomation.client.RestHttpClient;
import lombok.Getter;

@Getter
public class BaseService {
    protected RestHttpClient client;

    public BaseService(RestHttpClient client) {
        this.client = client;
    }


    public <T> T getResponseAs(Class<T> aClass) {
        return client.getResponse().as(aClass);
    }

}
