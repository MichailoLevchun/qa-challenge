package com.up42.testautomation.models.response.workflowJob;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class Inputs{

	@JsonProperty("nasa-modis:1")
	private NasaModis1 nasaModis1;

	@JsonProperty("sharpening:1")
	private Sharpening1 sharpening1;
}