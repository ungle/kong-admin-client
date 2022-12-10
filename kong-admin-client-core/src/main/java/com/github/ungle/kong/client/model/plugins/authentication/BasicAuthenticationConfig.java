package com.github.ungle.kong.client.model.plugins.authentication;

import com.github.ungle.kong.client.service.ValidateUtils;

public class BasicAuthenticationConfig extends BaseAuthenticationConfig {
	
	private BasicAuthenticationConfig(Builder builder) {
		super(builder.hideCredentials,builder.anoymousDefaultUserId);
	}


	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Boolean hideCredentials;
		private String anoymousDefaultUserId;

		private Builder() {
		}

		public Builder withHideCredentials(Boolean hideCredentials) {
			this.hideCredentials = hideCredentials;
			return this;
		}

		public Builder withAnoymousDefaultUserId(String anoymousDefaultUserId) {
			this.anoymousDefaultUserId = anoymousDefaultUserId;
			return this;
		}

		public BasicAuthenticationConfig build() {
			this.hideCredentials = ValidateUtils.defaultIfNull(hideCredentials, Boolean.FALSE);
			return new BasicAuthenticationConfig(this);
		}
	}
	
	

	
}
