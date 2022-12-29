package io.github.ungle.kong.client.model.plugins.authentication;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.service.ValidateUtils;

public class LDAPAuthenticationConfig extends BaseAuthenticationConfig {

	private static final Integer LDAPS_PORT = 636;

	private static final Integer LDAP_DEFAULT_PORT = 389;

	@JsonProperty("ldap_host")
	private String ldapHost;

	@JsonProperty("ldap_port")
	private Integer ldapPort;

	@JsonProperty("start_tls")
	private Boolean startTLS;

	private Boolean ldaps;

	@JsonProperty("base_dn")
	private String baseDn;

	@JsonProperty("verify_ldap_host")
	private Boolean verifyLDAPHost;

	private String attribute;

	@JsonProperty("cache_ttl")
	private Integer cacheTTL;

	private Integer timeout;

	@JsonProperty("keepalive")
	private Integer keepAlive;

	@JsonProperty("header_type")
	private String headerType;

	private LDAPAuthenticationConfig(Builder builder) {
		super(builder.hideCredentials, builder.anoymousDefaultUserId);
		this.ldapHost = builder.ldapHost;
		this.ldapPort = builder.ldapPort;
		this.startTLS = builder.startTLS;
		this.ldaps = builder.ldaps;
		this.baseDn = builder.baseDn;
		this.verifyLDAPHost = builder.verifyLDAPHost;
		this.attribute = builder.attribute;
		this.cacheTTL = builder.cacheTTL;
		this.timeout = builder.timeout;
		this.keepAlive = builder.keepAlive;
		this.headerType = builder.headerType;
	}

	public String getLdapHost() {
		return ldapHost;
	}

	public Integer getLdapPort() {
		return ldapPort;
	}

	public Boolean getStartTLS() {
		return startTLS;
	}

	public Boolean getLdaps() {
		return ldaps;
	}

	public String getBaseDn() {
		return baseDn;
	}

	public Boolean getVerifyLDAPHost() {
		return verifyLDAPHost;
	}

	public String getAttribute() {
		return attribute;
	}

	public Integer getCacheTTL() {
		return cacheTTL;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public Integer getKeepAlive() {
		return keepAlive;
	}

	public String getHeaderType() {
		return headerType;
	}

	private static void verifyPort(Integer ldapPort, Boolean ldaps) {
		if (ldapPort < 0 || ldapPort > 65535) {
			throw new IllegalArgumentException("the port range must between 0-65535");
		}
		if (Boolean.TRUE.equals(ldaps) && !LDAPS_PORT.equals(ldapPort)) {
			throw new IllegalArgumentException("When ldaps is configured, port 636 must be used");
		}
	}

	private static void verifyLDAPS(Boolean ldaps, Boolean startTLS) {
		if (ldaps == null || startTLS == null) {
			return;
		}
		if (Boolean.logicalAnd(ldaps, startTLS)) {
			throw new IllegalArgumentException("only one of start_tls and ldaps can be true");
		}
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String ldapHost;
		private Integer ldapPort;
		private Boolean startTLS;
		private Boolean ldaps;
		private String baseDn;
		private Boolean verifyLDAPHost;
		private String attribute;
		private Integer cacheTTL;
		private Integer timeout;
		private Integer keepAlive;
		private String headerType;
		private Boolean hideCredentials;
		private String anoymousDefaultUserId;

		private Builder() {
		}

		public Builder withLdapHost(String ldapHost) {
			this.ldapHost = ldapHost;
			return this;
		}

		public Builder withLdapPort(Integer ldapPort) {
			this.ldapPort = ldapPort;
			return this;
		}

		public Builder withStartTLS(Boolean startTLS) {
			this.startTLS = startTLS;
			return this;
		}

		public Builder withLdaps(Boolean ldaps) {
			this.ldaps = ldaps;
			return this;
		}

		public Builder withBaseDn(String baseDn) {
			this.baseDn = baseDn;
			return this;
		}

		public Builder withVerifyLDAPHost(Boolean verifyLDAPHost) {
			this.verifyLDAPHost = verifyLDAPHost;
			return this;
		}

		public Builder withAttribute(String attribute) {
			this.attribute = attribute;
			return this;
		}

		public Builder withCacheTTL(Integer cacheTTL) {
			this.cacheTTL = cacheTTL;
			return this;
		}

		public Builder withTimeout(Integer timeout) {
			this.timeout = timeout;
			return this;
		}

		public Builder withKeepAlive(Integer keepAlive) {
			this.keepAlive = keepAlive;
			return this;
		}

		public Builder withHeaderType(String headerType) {
			this.headerType = headerType;
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

		public LDAPAuthenticationConfig build() {
			this.ldapPort =ValidateUtils.defaultIfNull(ldapPort, LDAP_DEFAULT_PORT);
			this.startTLS =ValidateUtils.defaultIfNull(startTLS, Boolean.FALSE);
			this.ldaps =ValidateUtils.defaultIfNull(ldaps, Boolean.FALSE);
			this.verifyLDAPHost =ValidateUtils.defaultIfNull(verifyLDAPHost, Boolean.FALSE);
			this.cacheTTL =ValidateUtils.defaultIfNull(cacheTTL, 60);
			this.timeout =ValidateUtils.defaultIfNull(timeout, 10000);
			this.keepAlive =ValidateUtils.defaultIfNull(keepAlive, 60000);
			this.headerType =ValidateUtils.defaultIfEmpty(headerType,"ldap");
			this.hideCredentials = ValidateUtils.defaultIfNull(hideCredentials, Boolean.FALSE);
			verifyLDAPS(ldaps, startTLS);
			verifyPort(ldapPort, ldaps);
			return new LDAPAuthenticationConfig(this);
		}
	}

}
