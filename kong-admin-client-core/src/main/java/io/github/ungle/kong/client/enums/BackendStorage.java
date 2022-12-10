package io.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum BackendStorage {
	@JsonProperty("kong")
	KONG,
	@JsonProperty("shm")
	SHM,
	@JsonProperty("redis")
	REDIS,
	@JsonProperty("consul")
	CONSUL,
	@JsonProperty("vault")
	VAULT;

}
