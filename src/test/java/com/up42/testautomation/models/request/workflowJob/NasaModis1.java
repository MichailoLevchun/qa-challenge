package com.up42.testautomation.models.request.workflowJob;

import lombok.Builder;

import java.util.List;

@Builder
public class NasaModis1{
	private List<Double> bbox;
	private int limit;
	private String time;
	private int zoomLevel;
	private List<String> imageryLayers;
}