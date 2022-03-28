package com.up42.testautomation.models.response.workflow;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Data{

	@JsonProperty("createdAt")
	private String createdAt;

	@JsonProperty("updatedBy")
	private UpdatedBy updatedBy;

	@JsonProperty("createdBy")
	private CreatedBy createdBy;

	@JsonProperty("name")
	private String name;

	@JsonProperty("description")
	private String description;

	@JsonProperty("id")
	private String id;

	@JsonProperty("totalProcessingTime")
	private int totalProcessingTime;

	@JsonProperty("updatedAt")
	private String updatedAt;
}