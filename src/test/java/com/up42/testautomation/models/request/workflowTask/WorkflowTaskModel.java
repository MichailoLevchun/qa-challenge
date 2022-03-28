package com.up42.testautomation.models.request.workflowTask;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class WorkflowTaskModel {
    private String blockId;
    private String parentName;
    private String name;

    public static final WorkflowTaskModel NASA_DEFAULT_MODEL = WorkflowTaskModel.builder()
            .name("nasa-modis:1")
            .blockId("ef6faaf5-8182-4986-bce4-4f811d2745e5")
            .parentName(null)
            .build();
    public static final WorkflowTaskModel SHARPENING_DEFAULT_MODEL = WorkflowTaskModel.builder()
            .name("sharpening:1")
            .blockId("e374ea64-dc3b-4500-bb4b-974260fb203e")
            .parentName("nasa-modis:1")
            .build();
}
