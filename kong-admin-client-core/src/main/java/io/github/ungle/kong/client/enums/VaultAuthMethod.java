package io.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum VaultAuthMethod {
	@JsonProperty("token")
	TOKEN,
	@JsonProperty("kubernetes")
	KUBERNETES;

}
