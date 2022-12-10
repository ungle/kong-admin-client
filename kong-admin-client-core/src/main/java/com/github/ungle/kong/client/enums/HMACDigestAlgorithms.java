package com.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum HMACDigestAlgorithms {
	
	@JsonProperty("hmac-sha1")
	SHA1,
	
	@JsonProperty("hmac-sha256")
	SHA256,
	
	@JsonProperty("hmac-sha384")
	SHA384,
	
	@JsonProperty("hmac-sha512")
	SHA512;

}
