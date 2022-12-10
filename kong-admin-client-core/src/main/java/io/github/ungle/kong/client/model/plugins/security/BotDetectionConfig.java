package io.github.ungle.kong.client.model.plugins.security;

import java.util.List;

import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

import java.util.Arrays;
public class BotDetectionConfig extends PluginConfig {
	private List<String> allow;
	private List<String> deny;

	private BotDetectionConfig(Builder builder) {
		super();
		this.allow = builder.allow;
		this.deny = builder.deny;
	}

	public List<String> getAllow() {
		return allow;
	}

	public List<String> getDeny() {
		return deny;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private List<String> allow;
		private List<String> deny;

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

		public BotDetectionConfig build() {
			ValidateUtils.isAllEmpty("one of allow or deny must be specified", Arrays.asList(allow, deny));
			return new BotDetectionConfig(this);
		}
	}

}
