package io.github.ungle.kong.client.model.plugins.authentication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.HMACDigestAlgorithms;
import io.github.ungle.kong.client.service.ValidateUtils;

public class HMACAuthenticationConfig extends BaseAuthenticationConfig {

	@JsonProperty("clock_skew")
	private Integer clockSkew;
	@JsonProperty("validate_request_body")
	private Boolean validateRequestBody;
	@JsonProperty("enforce_headers")
	private Set<String> enforceHeaders;
	private Set<HMACDigestAlgorithms> algorithms;

	private HMACAuthenticationConfig(Builder builder) {
		super(builder.hideCredentials,builder.anoymousDefaultUserId);
		this.clockSkew = builder.clockSkew;
		this.validateRequestBody = builder.validateRequestBody;
		this.enforceHeaders = builder.enforceHeaders;
		this.algorithms = builder.algorithms;
	}

	public Integer getClockSkew() {
		return clockSkew;
	}

	public Boolean getValidateRequestBody() {
		return validateRequestBody;
	}

	public Set<String> getEnforceHeaders() {
		return enforceHeaders;
	}

	public Set<HMACDigestAlgorithms> getAlgorithms() {
		return algorithms;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer clockSkew;
		private Boolean validateRequestBody;
		private Set<String> enforceHeaders;
		private Set<HMACDigestAlgorithms> algorithms;
		private Boolean hideCredentials;
		private String anoymousDefaultUserId;

		private Builder() {
		}

		public Builder withClockSkew(Integer clockSkew) {
			this.clockSkew = clockSkew;
			return this;
		}

		public Builder withValidateRequestBody(Boolean validateRequestBody) {
			this.validateRequestBody = validateRequestBody;
			return this;
		}

		public Builder withEnforceHeaders(Set<String> enforceHeaders) {
			this.enforceHeaders = enforceHeaders;
			return this;
		}

		public Builder withAlgorithms(Set<HMACDigestAlgorithms> algorithms) {
			this.algorithms = algorithms;
			return this;
		}

		public Builder withHideCredentials(Boolean hideCredentials) {
			this.hideCredentials = hideCredentials;
			return this;
		}

		public Builder withAnoymousDefaultUserId(String anoymousDefaultUserId) {
			this.anoymousDefaultUserId = anoymousDefaultUserId;
			return this;
		}

		public HMACAuthenticationConfig build() {
			this.clockSkew =ValidateUtils.defaultIfNull(clockSkew, 300);
			this.validateRequestBody =ValidateUtils.defaultIfNull(validateRequestBody, Boolean.FALSE);
			this.algorithms =ValidateUtils.defaultIfNull(algorithms, new HashSet<>(Arrays.asList(HMACDigestAlgorithms.SHA1, HMACDigestAlgorithms.SHA256,
					HMACDigestAlgorithms.SHA384, HMACDigestAlgorithms.SHA512)));
			this.hideCredentials = ValidateUtils.defaultIfNull(hideCredentials, Boolean.FALSE);
			return new HMACAuthenticationConfig(this);
		}
	}
	

}
