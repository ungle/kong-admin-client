package com.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RateLimitingPolicy {
	@JsonProperty("local")
	LOCAL,
	@JsonProperty("cluster")
	CLUSTER,
	@JsonProperty("redis")
	REDIS;

}
