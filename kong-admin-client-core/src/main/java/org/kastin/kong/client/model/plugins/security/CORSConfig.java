package org.kastin.kong.client.model.plugins.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.kastin.kong.client.enums.HttpMethod.CORSAllowedMethod;
import org.kastin.kong.client.model.plugins.PluginConfig;
import org.kastin.kong.client.service.ValidateUtils;

import com.fasterxml.jackson.annotation.JsonProperty;


public class CORSConfig extends PluginConfig {
	private Set<String> origins;
	private Set<CORSAllowedMethod> methods;
	private Set<String> headers;
	@JsonProperty("exposed_headers")
	private Set<String> exposedHeaders;
	private Boolean credentials;
	@JsonProperty("max_age")
	private Integer maxAge;
	@JsonProperty("preflight_continue")
	private Boolean preflightContinue;

	private CORSConfig(Builder builder) {
		super();
		this.origins = builder.origins;
		this.methods = builder.methods;
		this.headers = builder.headers;
		this.exposedHeaders = builder.exposedHeaders;
		this.credentials = builder.credentials;
		this.maxAge = builder.maxAge;
		this.preflightContinue = builder.preflightContinue;
	}


	public Set<String> getOrigins() {
		return origins;
	}

	public Set<CORSAllowedMethod> getMethods() {
		return methods;
	}

	public Set<String> getHeaders() {
		return headers;
	}

	public Set<String> getExposedHeaders() {
		return exposedHeaders;
	}

	public Boolean getCredentials() {
		return credentials;
	}

	public Integer getMaxAge() {
		return maxAge;
	}

	public Boolean getPreflightContinue() {
		return preflightContinue;
	}


	public static Builder builder() {
		return new Builder();
	}


	public static final class Builder {
		private Set<String> origins;
		private Set<CORSAllowedMethod> methods;
		private Set<String> headers;
		private Set<String> exposedHeaders;
		private Boolean credentials;
		private Integer maxAge;
		private Boolean preflightContinue;

		private Builder() {
		}

		public Builder withOrigins(Set<String> origins) {
			this.origins = origins;
			return this;
		}

		public Builder withMethods(Set<CORSAllowedMethod> methods) {
			this.methods = methods;
			return this;
		}

		public Builder withHeaders(Set<String> headers) {
			this.headers = headers;
			return this;
		}

		public Builder withExposedHeaders(Set<String> exposedHeaders) {
			this.exposedHeaders = exposedHeaders;
			return this;
		}

		public Builder withCredentials(Boolean credentials) {
			this.credentials = credentials;
			return this;
		}

		public Builder withMaxAge(Integer maxAge) {
			this.maxAge = maxAge;
			return this;
		}

		public Builder withPreflightContinue(Boolean preflightContinue) {
			this.preflightContinue = preflightContinue;
			return this;
		}

		public CORSConfig build() {
			methods = ValidateUtils.defaultIfNull(methods,new HashSet<>(Arrays.asList(CORSAllowedMethod.values())));
			credentials = ValidateUtils.defaultIfNull(credentials,Boolean.FALSE);
			preflightContinue = ValidateUtils.defaultIfNull(preflightContinue,Boolean.FALSE);
			return new CORSConfig(this);
		}
	}
	
	



}
