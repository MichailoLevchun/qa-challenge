package com.up42.testautomation.models.response.workflow;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class UpdatedBy{

	@JsonProperty("id")
	private String id;

	@JsonProperty("type")
	private String type;
}