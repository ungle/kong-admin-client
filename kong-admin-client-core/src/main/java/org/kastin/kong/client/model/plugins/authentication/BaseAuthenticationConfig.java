package org.kastin.kong.client.model.plugins.authentication;

import org.kastin.kong.client.model.plugins.PluginConfig;
import org.kastin.kong.client.service.ValidateUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

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
