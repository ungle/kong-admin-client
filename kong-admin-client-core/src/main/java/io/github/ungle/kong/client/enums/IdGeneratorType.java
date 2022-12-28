package io.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IdGeneratorType {
	@JsonProperty("uuid")
	UUID,
	@JsonProperty("uuid#counter")
	UUID_COUNTER,
	@JsonProperty("tracker")
	TRACKER;

}
