package io.github.ungle.kong.client.model.plugins.serverless;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

/**
 * 
 * @author ungle
 *
 */
public class OpenWhiskConfig extends PluginConfig {
	private String host;
	private Integer port;
	private String path;
	private String action;
	@JsonProperty("service_token")
	private String serviceToken;
	@JsonProperty("https_verify")
	private Boolean httpsVerify;
	private Boolean https;
	private Boolean result;
	private Long timeout;
	private Long keepalive;

	private OpenWhiskConfig(Builder builder) {
		this.host = builder.host;
		this.port = builder.port;
		this.path = builder.path;
		this.action = builder.action;
		this.serviceToken = builder.serviceToken;
		this.httpsVerify = builder.httpsVerify;
		this.https = builder.https;
		this.result = builder.result;
		this.timeout = builder.timeout;
		this.keepalive = builder.keepalive;
	}

	public String getHost() {
		return host;
	}

	public Integer getPort() {
		return port;
	}

	public String getPath() {
		return path;
	}

	public String getAction() {
		return action;
	}

	public String getServiceToken() {
		return serviceToken;
	}

	public Boolean getHttpsVerify() {
		return httpsVerify;
	}

	public Boolean getHttps() {
		return https;
	}

	public Boolean getResult() {
		return result;
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
		private String host;
		private Integer port;
		private String path;
		private String action;
		private String serviceToken;
		private Boolean httpsVerify;
		private Boolean https;
		private Boolean result;
		private Long timeout;
		private Long keepalive;

		private Builder() {
		}

		public Builder withHost(String host) {
			this.host = host;
			return this;
		}

		public Builder withPort(Integer port) {
			this.port = port;
			return this;
		}

		public Builder withPath(String path) {
			this.path = path;
			return this;
		}

		public Builder withAction(String action) {
			this.action = action;
			return this;
		}

		public Builder withServiceToken(String serviceToken) {
			this.serviceToken = serviceToken;
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

		public Builder withResult(Boolean result) {
			this.result = result;
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

		public OpenWhiskConfig build() {
			ValidateUtils.isBlank(host, "host is required");
			ValidateUtils.isBlank(path, "path is required");
			ValidateUtils.isBlank(action, "action is required");
			port = ValidateUtils.defaultIfNull(port, 443);
			result = ValidateUtils.defaultIfNull(result, Boolean.TRUE);
			httpsVerify = ValidateUtils.defaultIfNull(httpsVerify, Boolean.FALSE);
			https = ValidateUtils.defaultIfNull(https, Boolean.TRUE);
			timeout = ValidateUtils.defaultIfNull(timeout, 60000L);
			keepalive = ValidateUtils.defaultIfNull(keepalive, 60000L);
			return new OpenWhiskConfig(this);
		}
	}
	
	

}
