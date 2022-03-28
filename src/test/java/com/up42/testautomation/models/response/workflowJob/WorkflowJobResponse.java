package com.up42.testautomation.models.response.workflowJob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class WorkflowJobResponse{

	@JsonProperty("data")
	private Data data;

	@JsonProperty("error")
	private Object error;
}