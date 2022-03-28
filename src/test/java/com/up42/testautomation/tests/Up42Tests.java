package com.up42.testautomation.tests;

import com.up42.testautomation.client.RestHttpClient;
import com.up42.testautomation.models.response.retrieveToken.RetrieveTokenResponse;
import com.up42.testautomation.models.response.workflow.WorkflowResponse;
import com.up42.testautomation.models.response.workflowJob.WorkflowJobResponse;
import com.up42.testautomation.services.core.ServiceRepository;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.up42.testautomation.models.request.workflow.WorkflowModel.DEFAULT_WORKFLOW_MODEL;
import static com.up42.testautomation.models.request.workflowJob.WorkflowJobModel.DEFAULT_WORKFLOW_JOB_MODEL;
import static com.up42.testautomation.models.request.workflowTask.WorkflowTaskModel.NASA_DEFAULT_MODEL;
import static com.up42.testautomation.models.request.workflowTask.WorkflowTaskModel.SHARPENING_DEFAULT_MODEL;
import static java.util.Arrays.asList;

public class Up42Tests {
    private ServiceRepository serviceRepo;

    private String workflowId;
    private String accessToken;

    @BeforeMethod
    public void init() {
        RestHttpClient client = new RestHttpClient();
        serviceRepo = new ServiceRepository(client);
    }

    @Test(description = "Test Workflow Creation")
    public void testCreateWorkflow() {
        serviceRepo.getAuthorizationService().retrieveAccessToken();
        accessToken = serviceRepo.getWorkflowService().getResponseAs(RetrieveTokenResponse.class).getAccessToken();

        serviceRepo.getWorkflowService().createWorkflow(accessToken, DEFAULT_WORKFLOW_MODEL);
        workflowId = serviceRepo.getWorkflowService().getResponseAs(WorkflowResponse.class).getData().getId();

        serviceRepo.getWorkflowService().createWorkflowTask(workflowId, accessToken, asList(
                NASA_DEFAULT_MODEL,
                SHARPENING_DEFAULT_MODEL
        ));

        serviceRepo.getWorkflowService().createWorkflowJob(workflowId, accessToken, DEFAULT_WORKFLOW_JOB_MODEL);
        String jobId = serviceRepo.getWorkflowService().getResponseAs(WorkflowJobResponse.class).getData().getId();

        serviceRepo.getWorkflowService().getWorkflowJobWithAsyncWait(jobId, accessToken);
        Assert.assertEquals(serviceRepo.getWorkflowService().getResponseAs(WorkflowJobResponse.class).getData().getStatus(), "SUCCEEDED",
                "Job " + jobId  + " isn't succeeded" );
    }

    @AfterMethod
    public void cleanUp() {
        serviceRepo.getWorkflowService().deleteWorkflow(workflowId, accessToken);
    }
}
