package com.github.ungle.kong.client.model.plugins.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ungle.kong.client.model.plugins.PluginConfig;
import com.github.ungle.kong.client.service.ValidateUtils;

public abstract class BaseAuthenticationConfig extends PluginConfig {
	@JsonProperty("hide_credentials")
	private Boolean hideCredentials;

	@JsonProperty("anonymous")
	private String anoymousDefaultUserId;

	public BaseAuthenticationConfig() {
	}

	public BaseAuthenticationConfig(Boolean hideCredentials, String anoymousDefaultUserId) {
		this.hideCredentials = ValidateUtils.defaultIfNull(hideCredentials, Boolean.FALSE);
		this.anoymousDefaultUserId = anoymousDefaultUserId;
	}

	public Boolean getHideCredentials() {
		return hideCredentials;
	}

	public String getAnoymousDefaultUserId() {
		return anoymousDefaultUserId;
	}

}
