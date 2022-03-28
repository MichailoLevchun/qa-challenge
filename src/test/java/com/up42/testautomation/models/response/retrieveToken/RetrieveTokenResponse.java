package com.up42.testautomation.models.response.retrieveToken;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
public class RetrieveTokenResponse {

	@JsonProperty("access_token")
	private String accessToken;

	@JsonProperty("data")
	private Data data;

	@JsonProperty("token_type")
	private String tokenType;
}