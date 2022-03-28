package com.up42.testautomation.models.response.workflowJob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Data{

	@JsonProperty("updatedBy")
	private UpdatedBy updatedBy;

	@JsonProperty("inputs")
	private Inputs inputs;

	@JsonProperty("startedAt")
	private Object startedAt;

	@JsonProperty("workflowName")
	private String workflowName;

	@JsonProperty("finishedAt")
	private Object finishedAt;

	@JsonProperty("mode")
	private String mode;

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("createdBy")
	private CreatedBy createdBy;

	@JsonProperty("name")
	private Object name;

	@JsonProperty("id")
	private String id;

	@JsonProperty("displayId")
	private String displayId;

	@JsonProperty("workflowId")
	private String workflowId;

	@JsonProperty("updatedAt")
	private String updatedAt;

	@JsonProperty("status")
	private String status;
}