package com.up42.testautomation.services;

import com.up42.testautomation.client.RestHttpClient;
import com.up42.testautomation.models.request.workflow.WorkflowModel;
import com.up42.testautomation.models.request.workflowJob.WorkflowJobModel;
import com.up42.testautomation.models.request.workflowTask.WorkflowTaskModel;
import com.up42.testautomation.services.core.BaseService;
import io.restassured.http.Header;
import io.restassured.response.Response;

import java.util.List;

import static com.up42.testautomation.application.endpoints.Endpoints.PROJECT_URI;
import static com.up42.testautomation.application.endpoints.Endpoints.WORKFLOW_URI;
import static com.up42.testautomation.utils.AwaitUtil.retryReceiveJobStatus;
import static io.restassured.http.ContentType.JSON;

public class WorkflowService extends BaseService {

    public WorkflowService(RestHttpClient client) {
        super(client);
    }

    public Response createWorkflow(String accessToken, WorkflowModel model) {
        return client.post(WORKFLOW_URI, JSON, model,
                new Header("Authorization", "Bearer " + accessToken));
    }

    public Response createWorkflowTask(String workflowId, String accessToken, List<WorkflowTaskModel> model) {
        return client.post(WORKFLOW_URI.concat("/" + workflowId + "/tasks"), JSON, model,
                new Header("Authorization", "Bearer " + accessToken));
    }

    public Response createWorkflowJob(String workflowId, String accessToken, WorkflowJobModel model) {
        return client.post(WORKFLOW_URI.concat("/" + workflowId + "/jobs"), JSON, model,
                new Header("Authorization", "Bearer " + accessToken));
    }

    public Response getWorkflowJobWithAsyncWait(String jobId, String accessToken) {
        return retryReceiveJobStatus(() -> client.get(PROJECT_URI.concat("/jobs/" + jobId), JSON,
                new Header("Authorization", "Bearer " + accessToken)));
    }

    public Response deleteWorkflow(String workflowId, String accessToken) {
        return client.delete(WORKFLOW_URI.concat("/" + workflowId), JSON, new Object(),
                new Header("Authorization", "Bearer " + accessToken));
    }

}
