package com.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CertType {
	@JsonProperty("rsa")
	RSA,
	
	@JsonProperty("ecc")
	ECC;

}
