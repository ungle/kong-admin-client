package io.github.ungle.kong.client.model.plugins.serverless;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

public class AzureFunctionConfig extends PluginConfig {
	@JsonProperty("functionname")
	private String functionName;
	@JsonProperty("appname")
	private String appName;
	@JsonProperty("hostdomain")
	private String hostDomain;
	@JsonProperty("routeprefix")
	private String routePrefix;
	@JsonProperty("apikey")
	private String apiKey;
	@JsonProperty("clientid")
	private String clientId;
	@JsonProperty("https_verify")
	private Boolean httpsVerify;
	private Boolean https;
	private Long timeout;
	private Long keepalive;

	private AzureFunctionConfig(Builder builder) {
		this.functionName = builder.functionName;
		this.appName = builder.appName;
		this.hostDomain = builder.hostDomain;
		this.routePrefix = builder.routePrefix;
		this.apiKey = builder.apiKey;
		this.clientId = builder.clientId;
		this.httpsVerify = builder.httpsVerify;
		this.https = builder.https;
		this.timeout = builder.timeout;
		this.keepalive = builder.keepalive;
	}

	public String getFunctionName() {
		return functionName;
	}

	public String getAppName() {
		return appName;
	}

	public String getHostDomain() {
		return hostDomain;
	}

	public String getRoutePrefix() {
		return routePrefix;
	}

	public String getApiKey() {
		return apiKey;
	}

	public String getClientId() {
		return clientId;
	}

	public Boolean getHttpsVerify() {
		return httpsVerify;
	}

	public Boolean getHttps() {
		return https;
	}

	public Long getTimeout() {
		return timeout;
	}

	public Long getKeepalive() {
		return keepalive;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String functionName;
		private String appName;
		private String hostDomain;
		private String routePrefix;
		private String apiKey;
		private String clientId;
		private Boolean httpsVerify;
		private Boolean https;
		private Long timeout;
		private Long keepalive;

		private Builder() {
		}

		public Builder withFunctionName(String functionName) {
			this.functionName = functionName;
			return this;
		}

		public Builder withAppName(String appName) {
			this.appName = appName;
			return this;
		}

		public Builder withHostDomain(String hostDomain) {
			this.hostDomain = hostDomain;
			return this;
		}

		public Builder withRoutePrefix(String routePrefix) {
			this.routePrefix = routePrefix;
			return this;
		}

		public Builder withApiKey(String apiKey) {
			this.apiKey = apiKey;
			return this;
		}

		public Builder withClientId(String clientId) {
			this.clientId = clientId;
			return this;
		}

		public Builder withHttpsVerify(Boolean httpsVerify) {
			this.httpsVerify = httpsVerify;
			return this;
		}

		public Builder withHttps(Boolean https) {
			this.https = https;
			return this;
		}

		public Builder withTimeout(Long timeout) {
			this.timeout = timeout;
			return this;
		}

		public Builder withKeepalive(Long keepalive) {
			this.keepalive = keepalive;
			return this;
		}

		public AzureFunctionConfig build() {
			ValidateUtils.isBlank(appName, "appname is required");
			ValidateUtils.isBlank(functionName, "functionname is required");
			hostDomain = ValidateUtils.defaultIfEmpty(hostDomain, "azurewebsites.net");
			routePrefix = ValidateUtils.defaultIfEmpty(routePrefix, "/api");
			httpsVerify = ValidateUtils.defaultIfNull(httpsVerify, Boolean.FALSE);
			https = ValidateUtils.defaultIfNull(https, Boolean.TRUE);
			timeout = ValidateUtils.defaultIfNull(timeout, 60000L);
			keepalive = ValidateUtils.defaultIfNull(keepalive, 60000L);
			return new AzureFunctionConfig(this);
		}
	}
	
	

}
