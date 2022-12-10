package io.github.ungle.kong.client.model.plugins.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.service.ValidateUtils;

import java.util.List;

/**
 * @author ungle
 */
public class Oauth2Config extends BaseAuthenticationConfig {

	private List<String> scopes;

	@JsonProperty("mandatory_scope")
	private Boolean mandatoryScope;

	private String provisionKey;

	@JsonProperty("token_expiration")
	private Integer tokenExpiration;

	@JsonProperty("enable_authorization_code")
	private Boolean enableAuthorizationCode;

	@JsonProperty("enable_client_credentials")
	private Boolean enableClientCredentials;

	@JsonProperty("enable_implicit_grant")
	private Boolean enableImplicitGrant;

	@JsonProperty("enable_password_grant")
	private Boolean enablePasswordGrant;

	@JsonProperty("auth_header_name")
	private String authHeaderName;

	@JsonProperty("accept_http_if_already_terminated")
	private Boolean acceptHttpIfAlreadyTerminated;

	@JsonProperty("global_credentials")
	private Boolean globalCredentials;

	@JsonProperty("refresh_token_ttl")
	private Integer refreshTokenTtl;

	@JsonProperty("reuse_refresh_token")
	private Boolean reuseRefreshToken;

	@JsonProperty("persistent_refresh_token")
	private Boolean persistentRefreshToken;

	private String pkce;

	private Oauth2Config(Builder builder) {
		super(builder.hideCredentials, builder.anoymousDefaultUserId);
		this.scopes = builder.scopes;
		this.mandatoryScope = builder.mandatoryScope;
		this.provisionKey = builder.provisionKey;
		this.tokenExpiration = builder.tokenExpiration;
		this.enableAuthorizationCode = builder.enableAuthorizationCode;
		this.enableClientCredentials = builder.enableClientCredentials;
		this.enableImplicitGrant = builder.enableImplicitGrant;
		this.enablePasswordGrant = builder.enablePasswordGrant;
		this.authHeaderName = builder.authHeaderName;
		this.acceptHttpIfAlreadyTerminated = builder.acceptHttpIfAlreadyTerminated;
		this.globalCredentials = builder.globalCredentials;
		this.refreshTokenTtl = builder.refreshTokenTtl;
		this.reuseRefreshToken = builder.reuseRefreshToken;
		this.persistentRefreshToken = builder.persistentRefreshToken;
		this.pkce = builder.pkce;
	}

	public List<String> getScopes() {
		return scopes;
	}

	public Boolean getMandatoryScope() {
		return mandatoryScope;
	}

	public String getProvisionKey() {
		return provisionKey;
	}

	public Integer getTokenExpiration() {
		return tokenExpiration;
	}

	public Boolean getEnableAuthorizationCode() {
		return enableAuthorizationCode;
	}

	public Boolean getEnableClientCredentials() {
		return enableClientCredentials;
	}

	public Boolean getEnableImplicitGrant() {
		return enableImplicitGrant;
	}

	public Boolean getEnablePasswordGrant() {
		return enablePasswordGrant;
	}

	public String getAuthHeaderName() {
		return authHeaderName;
	}

	public Boolean getAcceptHttpIfAlreadyTerminated() {
		return acceptHttpIfAlreadyTerminated;
	}

	public Boolean getGlobalCredentials() {
		return globalCredentials;
	}

	public Integer getRefreshTokenTtl() {
		return refreshTokenTtl;
	}

	public Boolean getReuseRefreshToken() {
		return reuseRefreshToken;
	}

	public Boolean getPersistentRefreshToken() {
		return persistentRefreshToken;
	}

	public String getPkce() {
		return pkce;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private List<String> scopes;
		private Boolean mandatoryScope;
		private String provisionKey;
		private Integer tokenExpiration;
		private Boolean enableAuthorizationCode;
		private Boolean enableClientCredentials;
		private Boolean enableImplicitGrant;
		private Boolean enablePasswordGrant;
		private String authHeaderName;
		private Boolean acceptHttpIfAlreadyTerminated;
		private Boolean globalCredentials;
		private Integer refreshTokenTtl;
		private Boolean reuseRefreshToken;
		private Boolean persistentRefreshToken;
		private String pkce;
		private Boolean hideCredentials;
		private String anoymousDefaultUserId;

		private Builder() {
		}

		public Builder withScopes(List<String> scopes) {
			this.scopes = scopes;
			return this;
		}

		public Builder withMandatoryScope(Boolean mandatoryScope) {
			this.mandatoryScope = mandatoryScope;
			return this;
		}

		public Builder withProvisionKey(String provisionKey) {
			this.provisionKey = provisionKey;
			return this;
		}

		public Builder withTokenExpiration(Integer tokenExpiration) {
			this.tokenExpiration = tokenExpiration;
			return this;
		}

		public Builder withEnableAuthorizationCode(Boolean enableAuthorizationCode) {
			this.enableAuthorizationCode = enableAuthorizationCode;
			return this;
		}

		public Builder withEnableClientCredentials(Boolean enableClientCredentials) {
			this.enableClientCredentials = enableClientCredentials;
			return this;
		}

		public Builder withEnableImplicitGrant(Boolean enableImplicitGrant) {
			this.enableImplicitGrant = enableImplicitGrant;
			return this;
		}

		public Builder withEnablePasswordGrant(Boolean enablePasswordGrant) {
			this.enablePasswordGrant = enablePasswordGrant;
			return this;
		}

		public Builder withAuthHeaderName(String authHeaderName) {
			this.authHeaderName = authHeaderName;
			return this;
		}

		public Builder withAcceptHttpIfAlreadyTerminated(Boolean acceptHttpIfAlreadyTerminated) {
			this.acceptHttpIfAlreadyTerminated = acceptHttpIfAlreadyTerminated;
			return this;
		}

		public Builder withGlobalCredentials(Boolean globalCredentials) {
			this.globalCredentials = globalCredentials;
			return this;
		}

		public Builder withRefreshTokenTtl(Integer refreshTokenTtl) {
			this.refreshTokenTtl = refreshTokenTtl;
			return this;
		}

		public Builder withReuseRefreshToken(Boolean reuseRefreshToken) {
			this.reuseRefreshToken = reuseRefreshToken;
			return this;
		}

		public Builder withPersistentRefreshToken(Boolean persistentRefreshToken) {
			this.persistentRefreshToken = persistentRefreshToken;
			return this;
		}

		public Builder withPkce(String pkce) {
			this.pkce = pkce;
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

		public Oauth2Config build() {
			this.hideCredentials = ValidateUtils.defaultIfNull(hideCredentials, Boolean.FALSE);
			return new Oauth2Config(this);
		}
	}

}
