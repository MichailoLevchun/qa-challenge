package com.up42.testautomation.services.core;

import com.up42.testautomation.client.RestHttpClient;
import com.up42.testautomation.services.AuthorizationService;
import com.up42.testautomation.services.WorkflowService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ServiceRepository {
    private RestHttpClient client;

    public WorkflowService getWorkflowService() {
        return new WorkflowService(client);
    }

    public AuthorizationService getAuthorizationService() {
        return new AuthorizationService(client);
    }
}