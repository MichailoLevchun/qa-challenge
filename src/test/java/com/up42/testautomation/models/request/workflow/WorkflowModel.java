package com.up42.testautomation.models.request.workflow;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WorkflowModel {

    private String name;
    private String description;

    public static final WorkflowModel DEFAULT_WORKFLOW_MODEL = WorkflowModel.builder()
            .name("QA coding challenge workflow")
            .description("Workflow description")
            .build();
}
