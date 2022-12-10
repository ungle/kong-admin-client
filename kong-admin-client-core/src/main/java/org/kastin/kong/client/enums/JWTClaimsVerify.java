package org.kastin.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum JWTClaimsVerify {
	
	@JsonProperty("nbf")
	NBF,
	@JsonProperty("exp")
	EXP;

}
