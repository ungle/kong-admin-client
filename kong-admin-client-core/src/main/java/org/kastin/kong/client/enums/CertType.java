package org.kastin.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum CertType {
	@JsonProperty("rsa")
	RSA,
	
	@JsonProperty("ecc")
	ECC;

}
