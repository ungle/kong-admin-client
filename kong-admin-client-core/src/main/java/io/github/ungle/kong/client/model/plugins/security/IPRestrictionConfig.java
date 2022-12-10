package io.github.ungle.kong.client.model.plugins.security;

import java.util.List;

import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

import java.util.Arrays;

public class IPRestrictionConfig extends PluginConfig {
	private List<String> allow;
	private List<String> deny;
	private Integer status;
	private String message;

	private IPRestrictionConfig(Builder builder) {
		super();
		this.allow = builder.allow;
		this.deny = builder.deny;
		this.status = builder.status;
		this.message = builder.message;
	}

	public List<String> getAllow() {
		return allow;
	}

	public List<String> getDeny() {
		return deny;
	}

	public Integer getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private List<String> allow;
		private List<String> deny;
		private Integer status;
		private String message;

		private Builder() {
		}

		public Builder withAllow(List<String> allow) {
			this.allow = allow;
			return this;
		}

		public Builder withDeny(List<String> deny) {
			this.deny = deny;
			return this;
		}

		public Builder withStatus(Integer status) {
			this.status = status;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		public IPRestrictionConfig build() {
			status = ValidateUtils.defaultIfNull(status, 403);
			message = ValidateUtils.defaultIfNull(message, "Your IP address is not allowed");
			ValidateUtils.isAllEmpty("one of allow or deny must be specified", Arrays.asList(allow, deny));
			return new IPRestrictionConfig(this);
		}
	}

}
