package org.kastin.kong.client.model.plugins.authentication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.kastin.kong.client.enums.JWTClaimsVerify;
import org.kastin.kong.client.service.ValidateUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author ungle
 * @see <a href=
 *      "https://docs.konghq.com/hub/kong-inc/jwt">https://docs.konghq.com/hub/kong-inc/jwt/</a>
 *
 */

public class JWTAuthenticationConfig extends BaseAuthenticationConfig {

	@JsonProperty("uri_param_names")
	private Set<String> uriParamNames;

	@JsonProperty("cookie_names")
	private Set<String> cookieNames;

	@JsonProperty("header_names")
	private Set<String> headerNames;

	@JsonProperty("claims_to_verify")
	private Set<JWTClaimsVerify> claimsToVerify;
	@JsonProperty("key_claim_name")
	private String keyClaimName;

	@JsonProperty("secret_is_base64")
	private Boolean secretIsBase64;

	@JsonProperty("run_on_preflight")
	private Boolean runOnPreflight;

	@JsonProperty("maximum_expiration")
	private Integer maxinumExpiration;

	private JWTAuthenticationConfig(Builder builder) {
		super(builder.hideCredentials,builder.anoymousDefaultUserId);
		this.uriParamNames = builder.uriParamNames;
		this.cookieNames = builder.cookieNames;
		this.headerNames = builder.headerNames;
		this.claimsToVerify = builder.claimsToVerify;
		this.keyClaimName = builder.keyClaimName;
		this.secretIsBase64 = builder.secretIsBase64;
		this.runOnPreflight = builder.runOnPreflight;
		this.maxinumExpiration = builder.maxinumExpiration;
	}

	public Set<String> getUriParamNames() {
		return uriParamNames;
	}

	public Set<String> getCookieNames() {
		return cookieNames;
	}

	public Set<String> getHeaderNames() {
		return headerNames;
	}

	public Set<JWTClaimsVerify> getClaimsToVerify() {
		return claimsToVerify;
	}

	public String getKeyClaimName() {
		return keyClaimName;
	}

	public Boolean getSecretIsBase64() {
		return secretIsBase64;
	}

	public Boolean getRunOnPreflight() {
		return runOnPreflight;
	}

	public Integer getMaxinumExpiration() {
		return maxinumExpiration;
	}

	private static void verifyMaxinumExpiration(Integer maxinumExpiration,Set<JWTClaimsVerify> claimsToVerify) {
		if (maxinumExpiration < 0 || maxinumExpiration > 31536000) {
			throw new IllegalArgumentException("maximum_expiration must between 0 and 31536000");
		} else if (maxinumExpiration > 0) {
			if (claimsToVerify == null || !claimsToVerify.contains(JWTClaimsVerify.EXP)) {
				throw new IllegalArgumentException(
						"claims_to_verify must contains exp when maximum_expiration greater than 0");
			}
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Set<String> uriParamNames;
		private Set<String> cookieNames;
		private Set<String> headerNames;
		private Set<JWTClaimsVerify> claimsToVerify;
		private String keyClaimName;
		private Boolean secretIsBase64;
		private Boolean runOnPreflight;
		private Integer maxinumExpiration;
		private Boolean hideCredentials;
		private String anoymousDefaultUserId;

		private Builder() {
		}

		public Builder withUriParamNames(Set<String> uriParamNames) {
			this.uriParamNames = uriParamNames;
			return this;
		}

		public Builder withCookieNames(Set<String> cookieNames) {
			this.cookieNames = cookieNames;
			return this;
		}

		public Builder withHeaderNames(Set<String> headerNames) {
			this.headerNames = headerNames;
			return this;
		}

		public Builder withClaimsToVerify(Set<JWTClaimsVerify> claimsToVerify) {
			this.claimsToVerify = claimsToVerify;
			return this;
		}

		public Builder withKeyClaimName(String keyClaimName) {
			this.keyClaimName = keyClaimName;
			return this;
		}

		public Builder withSecretIsBase64(Boolean secretIsBase64) {
			this.secretIsBase64 = secretIsBase64;
			return this;
		}

		public Builder withRunOnPreflight(Boolean runOnPreflight) {
			this.runOnPreflight = runOnPreflight;
			return this;
		}

		public Builder withMaxinumExpiration(Integer maxinumExpiration) {
			this.maxinumExpiration = maxinumExpiration;
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

		public JWTAuthenticationConfig build() {
			headerNames = ValidateUtils.defaultIfNull(headerNames,new HashSet<>(Arrays.asList("authorization")));
			keyClaimName =ValidateUtils.defaultIfNull(keyClaimName ,"iss");
			secretIsBase64 =ValidateUtils.defaultIfNull(secretIsBase64, Boolean.FALSE);
			runOnPreflight = ValidateUtils.defaultIfNull(runOnPreflight,Boolean.TRUE);
			maxinumExpiration =ValidateUtils.defaultIfNull(maxinumExpiration, 0);
			verifyMaxinumExpiration(maxinumExpiration,claimsToVerify);
			this.hideCredentials = ValidateUtils.defaultIfNull(hideCredentials, Boolean.FALSE);
			return new JWTAuthenticationConfig(this);
		}
	}

}
