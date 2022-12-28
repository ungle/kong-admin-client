package io.github.ungle.kong.client.model.plugins.traffic;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.SizeUnit;
import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

public class RequestSizeLimitingConfig extends PluginConfig {

	@JsonProperty("allowed_payload_size")
	private Integer allowedPayloadSize;
	@JsonProperty("size_unit")
	private SizeUnit sizeUnit;
	@JsonProperty("require_content_length")
	private Boolean requireContentLength;

	private RequestSizeLimitingConfig(Builder builder) {
		super();
		this.allowedPayloadSize = builder.allowedPayloadSize;
		this.sizeUnit = builder.sizeUnit;
		this.requireContentLength = builder.requireContentLength;
	}

	public Integer getAllowedPayloadSize() {
		return allowedPayloadSize;
	}

	public SizeUnit getSizeUnit() {
		return sizeUnit;
	}

	public Boolean getRequireContentLength() {
		return requireContentLength;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer allowedPayloadSize;
		private SizeUnit sizeUnit;
		private Boolean requireContentLength;

		private Builder() {
		}

		public Builder withAllowedPayloadSize(Integer allowedPayloadSize) {
			this.allowedPayloadSize = allowedPayloadSize;
			return this;
		}

		public Builder withSizeUnit(SizeUnit sizeUnit) {
			this.sizeUnit = sizeUnit;
			return this;
		}

		public Builder withRequireContentLength(Boolean requireContentLength) {
			this.requireContentLength = requireContentLength;
			return this;
		}

		public RequestSizeLimitingConfig build() {
			this.allowedPayloadSize = ValidateUtils.defaultIfNull(this.allowedPayloadSize, 128);
			this.sizeUnit = ValidateUtils.defaultIfNull(this.sizeUnit, SizeUnit.MEGABYTES);
			this.requireContentLength = ValidateUtils.defaultIfNull(requireContentLength, Boolean.FALSE);
			return new RequestSizeLimitingConfig(this);
		}
	}

}
