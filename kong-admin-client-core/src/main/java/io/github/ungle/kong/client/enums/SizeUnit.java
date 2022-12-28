package io.github.ungle.kong.client.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum SizeUnit {
	@JsonProperty("bytes")
	BYTES,
	@JsonProperty("kilobytes")
	KILOBYTES,
	@JsonProperty("megabytes")
	MEGABYTES;
	

}
