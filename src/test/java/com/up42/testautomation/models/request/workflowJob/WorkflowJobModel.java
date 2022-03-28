package com.up42.testautomation.models.request.workflowJob;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;

import static java.util.Arrays.asList;

@Builder
public class WorkflowJobModel{
	@SerializedName(value = "nasa-modis:1")
	private NasaModis1 nasaModis1;

	@SerializedName(value = "sharpening:1")
	private Sharpening1 sharpening1;

	public static final WorkflowJobModel DEFAULT_WORKFLOW_JOB_MODEL =
			WorkflowJobModel.builder()
					.nasaModis1(NasaModis1.builder()
							.time("2018-12-01T00:00:00+00:00/2020-12-31T23:59:59+00:00")
							.limit(1)
							.zoomLevel(9)
							.imageryLayers(asList("MODIS_Terra_CorrectedReflectance_TrueColor"))
							.bbox(asList(
									13.365373,
									52.49582,
									13.385796,
									52.510455))
							.build())
					.sharpening1(Sharpening1.builder()
							.strength("medium")
							.build())
					.build();
}
