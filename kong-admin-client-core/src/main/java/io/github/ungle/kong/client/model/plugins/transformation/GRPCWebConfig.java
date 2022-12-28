package io.github.ungle.kong.client.model.plugins.transformation;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

public class GRPCWebConfig extends PluginConfig {
	
	private String proto;
	@JsonProperty("pass_stripped_path")
	private Boolean passStrippedPath;
	@JsonProperty("allow_origin_header")
	private String allowOriginHeader;

	private GRPCWebConfig(Builder builder) {
		this.proto = builder.proto;
		this.passStrippedPath = builder.passStrippedPath;
		this.allowOriginHeader = builder.allowOriginHeader;
	}

	public String getProto() {
		return proto;
	}

	public Boolean getPassStrippedPath() {
		return passStrippedPath;
	}

	public String getAllowOriginHeader() {
		return allowOriginHeader;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String proto;
		private Boolean passStrippedPath;
		private String allowOriginHeader;

		private Builder() {
		}

		public Builder withProto(String proto) {
			this.proto = proto;
			return this;
		}

		public Builder withPassStrippedPath(Boolean passStrippedPath) {
			this.passStrippedPath = passStrippedPath;
			return this;
		}

		public Builder withAllowOriginHeader(String allowOriginHeader) {
			this.allowOriginHeader = allowOriginHeader;
			return this;
		}

		public GRPCWebConfig build() {
			allowOriginHeader = ValidateUtils.defaultIfEmpty(allowOriginHeader, "*");
			return new GRPCWebConfig(this);
		}
	}

}
