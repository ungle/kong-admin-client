package com.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RateLimitingAggregation {
	@JsonProperty("consumer")
	CONSUMER,
	@JsonProperty("credential")
	CREDENTIAL,
	@JsonProperty("ip")
	IP,
	@JsonProperty("service")
	SERVICE,
	@JsonProperty("header")
	HEADER,
	@JsonProperty("path")
	PATH;

}
