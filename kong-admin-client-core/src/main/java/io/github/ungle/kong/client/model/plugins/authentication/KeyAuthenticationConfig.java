package io.github.ungle.kong.client.model.plugins.authentication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.service.ValidateUtils;

public class KeyAuthenticationConfig extends BaseAuthenticationConfig {

	private static final Pattern KEY_NAME_PATTERN = Pattern.compile("([a-z]|[A-Z]|[0-9]|-|_)+");

	@JsonProperty("key_names")
	private Set<String> keyNames;

	@JsonProperty("key_in_body")
	private Boolean keyInBody;

	@JsonProperty("key_in_header")
	private Boolean keyInHeader;

	@JsonProperty("key_in_query")
	private Boolean keyInQuery;

	@JsonProperty("run_on_preflight")
	private Boolean runOnPreflight;

	private KeyAuthenticationConfig(Builder builder) {
		super(builder.hideCredentials, builder.anoymousDefaultUserId);
		this.keyNames = builder.keyNames;
		this.keyInBody = builder.keyInBody;
		this.keyInHeader = builder.keyInHeader;
		this.keyInQuery = builder.keyInQuery;
		this.runOnPreflight = builder.runOnPreflight;
	}

	public Set<String> getKeyNames() {
		return keyNames;
	}

	public Boolean getKeyInBody() {
		return keyInBody;
	}

	public Boolean getKeyInHeader() {
		return keyInHeader;
	}

	public Boolean getKeyInQuery() {
		return keyInQuery;
	}

	public Boolean getRunOnPreflight() {
		return runOnPreflight;
	}

	private static void verifyKeyNames(Set<String> keyNames) {
		ValidateUtils.isEmpty(keyNames, "key_names should not be empty");

		for (String keyName : keyNames) {
			Matcher matcher = KEY_NAME_PATTERN.matcher(keyName);
			if (!matcher.matches()) {
				throw new IllegalArgumentException(
						"key names may only contain [a-z], [A-Z], [0-9], [_] underscore, and [-] hyphen");
			}
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Set<String> keyNames;
		private Boolean keyInBody;
		private Boolean keyInHeader;
		private Boolean keyInQuery;
		private Boolean runOnPreflight;
		private Boolean hideCredentials;
		private String anoymousDefaultUserId;

		private Builder() {
		}

		public Builder withKeyNames(Set<String> keyNames) {
			this.keyNames = keyNames;
			return this;
		}

		public Builder withKeyInBody(Boolean keyInBody) {
			this.keyInBody = keyInBody;
			return this;
		}

		public Builder withKeyInHeader(Boolean keyInHeader) {
			this.keyInHeader = keyInHeader;
			return this;
		}

		public Builder withKeyInQuery(Boolean keyInQuery) {
			this.keyInQuery = keyInQuery;
			return this;
		}

		public Builder withRunOnPreflight(Boolean runOnPreflight) {
			this.runOnPreflight = runOnPreflight;
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

		public KeyAuthenticationConfig build() {
			keyNames = ValidateUtils.defaultIfNull(keyNames, new HashSet<>(Arrays.asList("apikey")));
			keyInBody = ValidateUtils.defaultIfNull(keyInBody, Boolean.FALSE);
			keyInHeader = ValidateUtils.defaultIfNull(keyInHeader, Boolean.TRUE);
			keyInQuery = ValidateUtils.defaultIfNull(keyInQuery, Boolean.TRUE);
			runOnPreflight = ValidateUtils.defaultIfNull(runOnPreflight, Boolean.TRUE);
			this.hideCredentials = ValidateUtils.defaultIfNull(hideCredentials, Boolean.FALSE);
			verifyKeyNames(keyNames);
			return new KeyAuthenticationConfig(this);
		}
	}

}
