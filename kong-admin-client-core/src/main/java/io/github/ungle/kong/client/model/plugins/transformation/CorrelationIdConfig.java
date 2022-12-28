package io.github.ungle.kong.client.model.plugins.transformation;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.IdGeneratorType;
import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

public class CorrelationIdConfig extends PluginConfig {

	@JsonProperty("header_name")
	private String headerName;
	private IdGeneratorType generator;
	@JsonProperty("echo_downstream")
	private Boolean echoDownstream;

	private CorrelationIdConfig(Builder builder) {
		this.headerName = builder.headerName;
		this.generator = builder.generator;
		this.echoDownstream = builder.echoDownstream;
	}

	public String getHeaderName() {
		return headerName;
	}

	public IdGeneratorType getGenerator() {
		return generator;
	}

	public Boolean getEchoDownstream() {
		return echoDownstream;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String headerName;
		private IdGeneratorType generator;
		private Boolean echoDownstream;

		private Builder() {
		}

		public Builder withHeaderName(String headerName) {
			this.headerName = headerName;
			return this;
		}

		public Builder withGenerator(IdGeneratorType generator) {
			this.generator = generator;
			return this;
		}

		public Builder withEchoDownstream(Boolean echoDownstream) {
			this.echoDownstream = echoDownstream;
			return this;
		}

		public CorrelationIdConfig build() {
			headerName = ValidateUtils.defaultIfEmpty(headerName, "Kong-Request-ID");
			generator = ValidateUtils.defaultIfNull(generator, IdGeneratorType.UUID_COUNTER);
			echoDownstream = ValidateUtils.defaultIfNull(echoDownstream, Boolean.FALSE);
			return new CorrelationIdConfig(this);
		}
	}

}
