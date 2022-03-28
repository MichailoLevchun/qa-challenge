package com.up42.testautomation.models.response.workflowJob;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class NasaModis1{

	@JsonProperty("zoomLevel")
	private int zoomLevel;

	@JsonProperty("bbox")
	private List<Double> bbox;

	@JsonProperty("limit")
	private int limit;

	@JsonProperty("imageryLayers")
	private List<String> imageryLayers;

	@JsonProperty("time")
	private String time;
}