package io.github.ungle.kong.client.model.plugins.authentication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.HttpMethod.SessionAllowedMethod;
import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

/**
 * 
 * @author ungle
 * @see <a href=https://docs.konghq.com/hub/kong-inc/session/ >
 *      https://docs.konghq.com/hub/kong-inc/session/ </a>
 *
 */
public class SessionAuthenticationConfig extends PluginConfig {

	private String secret;

	@JsonProperty("cookie_name")
	private String cookieName;

	@JsonProperty("rolling_timeout")
	private Integer cookieLifeTime;

	@JsonProperty("idling_timeout")
	private Integer cookieIdleTime;

	@JsonProperty("cookie_path")
	private String cookiePath;

	@JsonProperty("cookie_domain")
	private String cookieDomain;

	@JsonProperty("cookie_same_site")
	private String cookieSemestie;

	@JsonProperty("cookie_http_only")
	private Boolean cookieHttpOnly;

	@JsonProperty("cookie_secure")
	private Boolean cookieSecure;

	@JsonProperty("stale_ttl")
	private Integer cookieDiscard;

	@JsonProperty("storage")
	private String cookieStorage;

	@JsonProperty("logout_methods")
	private Set<SessionAllowedMethod> logoutMethods;

	@JsonProperty("logout_query_arg")
	private String logoutQueryArg;

	@JsonProperty("logout_post_arg")
	private String logoutPostArg;

	@JsonProperty("audience")
	private String audience;

	@JsonProperty("absolute_timeout")
	private Integer absoluteTimeout;

	private Boolean remember;

	@JsonProperty("remember_cookie_name")
	private String rememberCookieName;

	@JsonProperty("remember_rolling_timeout")
	private Integer rememberRollingTimeout;

	@JsonProperty("remember_absolute_timeout")
	private Integer rememberAbsouluteTimeout;

	@JsonProperty("request_headers")
	private Set<String> requestHeaders;

	@JsonProperty("response_headers")
	private Set<String> responseHeaders;

	private SessionAuthenticationConfig(Builder builder) {
		this.secret = builder.secret;
		this.cookieName = builder.cookieName;
		this.cookieLifeTime = builder.cookieLifeTime;
		this.cookieIdleTime = builder.cookieIdleTime;
		this.cookiePath = builder.cookiePath;
		this.cookieDomain = builder.cookieDomain;
		this.cookieSemestie = builder.cookieSemestie;
		this.cookieHttpOnly = builder.cookieHttpOnly;
		this.cookieSecure = builder.cookieSecure;
		this.cookieDiscard = builder.cookieDiscard;
		this.cookieStorage = builder.cookieStorage;
		this.logoutMethods = builder.logoutMethods;
		this.logoutQueryArg = builder.logoutQueryArg;
		this.logoutPostArg = builder.logoutPostArg;
		this.audience = builder.audience;
		this.absoluteTimeout = builder.absoluteTimeout;
		this.remember = builder.remember;
		this.rememberCookieName = builder.rememberCookieName;
		this.rememberRollingTimeout = builder.rememberRollingTimeout;
		this.rememberAbsouluteTimeout = builder.rememberAbsouluteTimeout;
		this.requestHeaders = builder.requestHeaders;
		this.responseHeaders = builder.responseHeaders;
	}

	public String getSecret() {
		return secret;
	}

	public String getCookieName() {
		return cookieName;
	}

	public Integer getCookieLifeTime() {
		return cookieLifeTime;
	}

	public Integer getCookieIdleTime() {
		return cookieIdleTime;
	}

	public String getLogoutPostArg() {
		return logoutPostArg;
	}

	public String getAudience() {
		return audience;
	}

	public Integer getAbsoluteTimeout() {
		return absoluteTimeout;
	}

	public Boolean getRemember() {
		return remember;
	}

	public String getRememberCookieName() {
		return rememberCookieName;
	}

	public Integer getRememberRollingTimeout() {
		return rememberRollingTimeout;
	}

	public Integer getRememberAbsouluteTimeout() {
		return rememberAbsouluteTimeout;
	}

	public Set<String> getRequestHeaders() {
		return requestHeaders;
	}

	public Set<String> getResponseHeaders() {
		return responseHeaders;
	}

	public String getCookiePath() {
		return cookiePath;
	}

	public String getCookieDomain() {
		return cookieDomain;
	}

	public String getCookieSemestie() {
		return cookieSemestie;
	}

	public Boolean getCookieHttpOnly() {
		return cookieHttpOnly;
	}

	public Boolean getCookieSecure() {
		return cookieSecure;
	}

	public Integer getCookieDiscard() {
		return cookieDiscard;
	}

	public String getCookieStorage() {
		return cookieStorage;
	}

	public Set<SessionAllowedMethod> getLogoutMethods() {
		return logoutMethods;
	}

	public String getLogoutQueryArg() {
		return logoutQueryArg;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String secret;
		private String cookieName;
		private Integer cookieLifeTime;
		private Integer cookieIdleTime;
		private String cookiePath;
		private String cookieDomain;
		private String cookieSemestie;
		private Boolean cookieHttpOnly;
		private Boolean cookieSecure;
		private Integer cookieDiscard;
		private String cookieStorage;
		private Set<SessionAllowedMethod> logoutMethods;
		private String logoutQueryArg;
		private String logoutPostArg;
		private String audience;
		private Integer absoluteTimeout;
		private Boolean remember;
		private String rememberCookieName;
		private Integer rememberRollingTimeout;
		private Integer rememberAbsouluteTimeout;
		private Set<String> requestHeaders;
		private Set<String> responseHeaders;

		private Builder() {
		}

		public Builder withSecret(String secret) {
			this.secret = secret;
			return this;
		}

		public Builder withCookieName(String cookieName) {
			this.cookieName = cookieName;
			return this;
		}

		public Builder withCookieLifeTime(Integer cookieLifeTime) {
			this.cookieLifeTime = cookieLifeTime;
			return this;
		}

		public Builder withCookieIdleTime(Integer cookieIdleTime) {
			this.cookieIdleTime = cookieIdleTime;
			return this;
		}

		public Builder withCookiePath(String cookiePath) {
			this.cookiePath = cookiePath;
			return this;
		}

		public Builder withCookieDomain(String cookieDomain) {
			this.cookieDomain = cookieDomain;
			return this;
		}

		public Builder withCookieSemestie(String cookieSemestie) {
			this.cookieSemestie = cookieSemestie;
			return this;
		}

		public Builder withCookieHttpOnly(Boolean cookieHttpOnly) {
			this.cookieHttpOnly = cookieHttpOnly;
			return this;
		}

		public Builder withCookieSecure(Boolean cookieSecure) {
			this.cookieSecure = cookieSecure;
			return this;
		}

		public Builder withCookieDiscard(Integer cookieDiscard) {
			this.cookieDiscard = cookieDiscard;
			return this;
		}

		public Builder withCookieStorage(String cookieStorage) {
			this.cookieStorage = cookieStorage;
			return this;
		}

		public Builder withLogoutMethods(Set<SessionAllowedMethod> logoutMethods) {
			this.logoutMethods = logoutMethods;
			return this;
		}

		public Builder withLogoutQueryArg(String logoutQueryArg) {
			this.logoutQueryArg = logoutQueryArg;
			return this;
		}

		public Builder withLogoutPostArg(String logoutPostArg) {
			this.logoutPostArg = logoutPostArg;
			return this;
		}

		public Builder withAudience(String audience) {
			this.audience = audience;
			return this;
		}

		public Builder withAbsoluteTimeout(Integer absoluteTimeout) {
			this.absoluteTimeout = absoluteTimeout;
			return this;
		}

		public Builder withRemember(Boolean remember) {
			this.remember = remember;
			return this;
		}

		public Builder withRememberCookieName(String rememberCookieName) {
			this.rememberCookieName = rememberCookieName;
			return this;
		}

		public Builder withRememberRollingTimeout(Integer rememberRollingTimeout) {
			this.rememberRollingTimeout = rememberRollingTimeout;
			return this;
		}

		public Builder withRememberAbsouluteTimeout(Integer rememberAbsouluteTimeout) {
			this.rememberAbsouluteTimeout = rememberAbsouluteTimeout;
			return this;
		}

		public Builder withRequestHeaders(Set<String> requestHeaders) {
			this.requestHeaders = requestHeaders;
			return this;
		}

		public Builder withResponseHeaders(Set<String> responseHeaders) {
			this.responseHeaders = responseHeaders;
			return this;
		}

		public SessionAuthenticationConfig build() {
			this.cookieName = ValidateUtils.defaultIfEmpty(cookieName, "session");
			this.cookieLifeTime = ValidateUtils.defaultIfNull(cookieLifeTime, 3600);
			this.cookiePath = ValidateUtils.defaultIfNull(cookiePath, "/");
			this.cookieSemestie = ValidateUtils.defaultIfNull(cookieSemestie, "Strict");
			this.cookieHttpOnly = ValidateUtils.defaultIfNull(cookieHttpOnly, Boolean.TRUE);
			this.cookieSecure = ValidateUtils.defaultIfNull(cookieSecure, Boolean.TRUE);
			this.cookieDiscard = ValidateUtils.defaultIfNull(cookieDiscard, 10);
			this.cookieStorage = ValidateUtils.defaultIfNull(cookieStorage, "cookie");
			this.logoutMethods = ValidateUtils.defaultIfNull(logoutMethods,
					new HashSet<>(Arrays.asList(SessionAllowedMethod.POST, SessionAllowedMethod.DELETE)));
			this.logoutQueryArg = ValidateUtils.defaultIfEmpty(logoutQueryArg, "session_logout");
			this.logoutPostArg = ValidateUtils.defaultIfEmpty(logoutPostArg, "session_logout");
			return new SessionAuthenticationConfig(this);
		}
	}

}
