package org.kastin.kong.client.model.plugins.authentication;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.kastin.kong.client.enums.HttpMethod.SessionAllowedMethod;
import org.kastin.kong.client.service.ValidateUtils;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author ungle
 * @see <a href=https://docs.konghq.com/hub/kong-inc/session/ >
 *      https://docs.konghq.com/hub/kong-inc/session/ </a>
 *
 */
public class SessionAuthentication extends BaseAuthenticationConfig {

	private String secret;

	@JsonProperty("cookie_name")
	private String cookieName;

	@JsonProperty("cookie_lifetime")
	private Integer cookieLifeTime;

	@JsonProperty("cookie_idletime")
	private Integer cookieIdleTime;

	@JsonProperty("cookie_renew")
	private Integer cookieRenew;

	@JsonProperty("cookie_path")
	private String cookiePath;

	@JsonProperty("cookie_path")
	private String cookieDomain;

	@JsonProperty("cookie_samesite")
	private String cookieSemestie;

	@JsonProperty("cookie_httponly")
	private Boolean cookieHttpOnly;

	@JsonProperty("cookie_secure")
	private Boolean cookieSecure;

	@JsonProperty("cookie_discard")
	private Integer cookieDiscard;

	@JsonProperty("storage")
	private String cookieStorage;

	@JsonProperty("logout_methods")
	private Set<SessionAllowedMethod> logoutMethods;

	@JsonProperty("logout_query_arg")
	private String logoutQueryArg;

	@JsonProperty("logout_post_arg")
	private String logoutPostArg;

	private SessionAuthentication(Builder builder) {
		super(builder.hideCredentials, builder.anoymousDefaultUserId);
		this.secret = builder.secret;
		this.cookieName = builder.cookieName;
		this.cookieLifeTime = builder.cookieLifeTime;
		this.cookieIdleTime = builder.cookieIdleTime;
		this.cookieRenew = builder.cookieRenew;
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
	}

	public static Builder builder() {
		return new Builder();
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

	public Integer getCookieRenew() {
		return cookieRenew;
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

	public String getLogoutPostArg() {
		return logoutPostArg;
	}

	public static final class Builder {
		private String secret;
		private String cookieName;
		private Integer cookieLifeTime;
		private Integer cookieIdleTime;
		private Integer cookieRenew;
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
		private Boolean hideCredentials;
		private String anoymousDefaultUserId;

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

		public Builder withCookieRenew(Integer cookieRenew) {
			this.cookieRenew = cookieRenew;
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

		public Builder withHideCredentials(Boolean hideCredentials) {
			this.hideCredentials = hideCredentials;
			return this;
		}

		public Builder withAnoymousDefaultUserId(String anoymousDefaultUserId) {
			this.anoymousDefaultUserId = anoymousDefaultUserId;
			return this;
		}

		public SessionAuthentication build() {
			this.cookieName = ValidateUtils.defaultIfEmpty(cookieName, "session");
			this.cookieLifeTime =ValidateUtils.defaultIfNull(cookieLifeTime, 3600);
			this.cookieRenew =ValidateUtils.defaultIfNull(cookieRenew , 600);
			this.cookiePath =ValidateUtils.defaultIfNull(cookiePath , "/");
			this.cookieSemestie = ValidateUtils.defaultIfNull(cookieSemestie ,"Strict");
			this.cookieHttpOnly =ValidateUtils.defaultIfNull( cookieHttpOnly, Boolean.TRUE);
			this.cookieSecure =ValidateUtils.defaultIfNull(cookieSecure , Boolean.TRUE);
			this.cookieDiscard =ValidateUtils.defaultIfNull(cookieDiscard , 10);
			this.cookieStorage =ValidateUtils.defaultIfNull(cookieStorage , "cookie");
			this.logoutMethods = ValidateUtils.defaultIfNull(logoutMethods ,new HashSet<>(Arrays.asList(SessionAllowedMethod.POST, 
					SessionAllowedMethod.DELETE)));
			this.logoutQueryArg = ValidateUtils.defaultIfEmpty(logoutQueryArg, "session_logout");
			this.logoutPostArg = ValidateUtils.defaultIfEmpty(logoutPostArg, "session_logout");
			this.hideCredentials = ValidateUtils.defaultIfNull(hideCredentials, Boolean.FALSE);
			return new SessionAuthentication(this);
		}
	}

}
