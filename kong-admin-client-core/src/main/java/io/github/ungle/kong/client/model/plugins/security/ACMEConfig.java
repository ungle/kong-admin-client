package io.github.ungle.kong.client.model.plugins.security;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.BackendStorage;
import io.github.ungle.kong.client.enums.CertType;
import io.github.ungle.kong.client.enums.VaultAuthMethod;
import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;


public class ACMEConfig extends PluginConfig {

	private static final Set<Integer> RSA_KEY_SIZE = new HashSet<>(Arrays.asList(2048, 3072, 4096));

	@JsonProperty("account_email")
	private String accountEmail;
	@JsonProperty("api_uri")
	private String apiURI;
	@JsonProperty("cert_type")
	private CertType certType;
	private Set<String> domains;
	@JsonProperty("allow_any_domain")
	private Boolean allowAnyDomain;
	@JsonProperty("fail_backoff_minutes")
	private Integer failBackOffMinutes;
	@JsonProperty("renew_threshold_days")
	private Integer renewThresholdDays;
	@JsonProperty("storage")
	private BackendStorage backendStorage;
	@JsonProperty("storage_config")
	private StorageConfig storageConfig;
	@JsonProperty("tos_accepted")
	private Boolean tosAccepted;
	@JsonProperty("eab_kid")
	private String eabKid;
	@JsonProperty("eab_hmac_key")
	private String eabHMACKey;
	@JsonProperty("rsa_key_size")
	private Integer rsaKeySize;

	private ACMEConfig(Builder builder) {
		super();
		this.accountEmail = builder.accountEmail;
		this.apiURI = builder.apiURI;
		this.certType = builder.certType;
		this.domains = builder.domains;
		this.allowAnyDomain = builder.allowAnyDomain;
		this.failBackOffMinutes = builder.failBackOffMinutes;
		this.renewThresholdDays = builder.renewThresholdDays;
		this.backendStorage = builder.backendStorage;
		this.storageConfig = builder.storageConfig;
		this.tosAccepted = builder.tosAccepted;
		this.eabKid = builder.eabKid;
		this.eabHMACKey = builder.eabHMACKey;
		this.rsaKeySize = builder.rsaKeySize;
	}

	public String getAccountEmail() {
		return accountEmail;
	}

	public String getApiURI() {
		return apiURI;
	}

	public CertType getCertType() {
		return certType;
	}

	public Set<String> getDomains() {
		return domains;
	}

	public Boolean getAllowAnyDomain() {
		return allowAnyDomain;
	}

	public Integer getFailBackOffMinutes() {
		return failBackOffMinutes;
	}

	public Integer getRenewThresholdDays() {
		return renewThresholdDays;
	}

	public BackendStorage getBackendStorage() {
		return backendStorage;
	}

	public StorageConfig getStorageConfig() {
		return storageConfig;
	}

	public Boolean getTosAccepted() {
		return tosAccepted;
	}

	public String getEabKid() {
		return eabKid;
	}

	public String getEabHMACKey() {
		return eabHMACKey;
	}

	public Integer getRsaKeySize() {
		return rsaKeySize;
	}

	private static void verifyRSAKeySize(Integer rsaKeySize) {
		if (rsaKeySize == null) {
			rsaKeySize = 4096;
			return;
		}
		if (!RSA_KEY_SIZE.contains(rsaKeySize)) {
			throw new IllegalArgumentException("rsa key size must be  2048, 3072, or 4096");
		}
	}

	public class StorageConfig {

		private SHMStorageConfig shm;
		private KongStorageConfig kong;
		private RedisStorageConfig redis;
		private ConsulStorageConfig consul;
		private VaultStorageConfig vault;

		public StorageConfig() {
			shm = new SHMStorageConfig();
			kong = new KongStorageConfig();
			redis = new RedisStorageConfig();
			consul = new ConsulStorageConfig();
			vault = new VaultStorageConfig();
		}

		public SHMStorageConfig getShm() {
			return shm;
		}

		public void setShm(SHMStorageConfig shm) {
			this.shm = shm;
		}

		public KongStorageConfig getKong() {
			return kong;
		}

		public void setKong(KongStorageConfig kong) {
			this.kong = kong;
		}

		public RedisStorageConfig getRedis() {
			return redis;
		}

		public void setRedis(RedisStorageConfig redis) {
			this.redis = redis;
		}

		public ConsulStorageConfig getConsul() {
			return consul;
		}

		public void setConsul(ConsulStorageConfig consul) {
			this.consul = consul;
		}

		public VaultStorageConfig getVault() {
			return vault;
		}

		public void setVault(VaultStorageConfig vault) {
			this.vault = vault;
		}

		public class KongStorageConfig {

		}

		public class SHMStorageConfig {
			@JsonProperty("shm_name")
			private String shmName;

			public SHMStorageConfig() {
				this.shmName = "kong";
			}

			public SHMStorageConfig(String shmName) {
				super();
				this.shmName = shmName;
			}

			public String getShmName() {
				return shmName;
			}

			public void setShmName(String shmName) {
				this.shmName = shmName;
			}

		}

		public class RedisStorageConfig {
			private String host;
			private Integer port;
			private Integer database;
			private String auth;
			private Boolean ssl;
			@JsonProperty("ssl_verify")
			private Boolean sslVerify;
			private String sni;

			public RedisStorageConfig() {
				this.host = "127.0.0.1";
				this.port = 6379;
				this.database = 0;
				this.ssl = Boolean.FALSE;
				this.sslVerify = Boolean.FALSE;
			}

			public String getHost() {
				return host;
			}

			public void setHost(String host) {
				this.host = host;
			}

			public Integer getPort() {
				return port;
			}

			public void setPort(Integer port) {
				this.port = port;
			}

			public Integer getDatabase() {
				return database;
			}

			public void setDatabase(Integer database) {
				this.database = database;
			}

			public String getAuth() {
				return auth;
			}

			public void setAuth(String auth) {
				this.auth = auth;
			}

			public Boolean getSsl() {
				return ssl;
			}

			public void setSsl(Boolean ssl) {
				this.ssl = ssl;
			}

			public Boolean getSslVerify() {
				return sslVerify;
			}

			public void setSslVerify(Boolean sslVerify) {
				this.sslVerify = sslVerify;
			}

			public String getSni() {
				return sni;
			}

			public void setSni(String sni) {
				this.sni = sni;
			}

		}

		public class ConsulStorageConfig {
			private Boolean https;
			private String host;
			private Integer port;
			@JsonProperty("kv_path")
			private String kvPath;
			private Integer timeout;
			private String token;

			public ConsulStorageConfig() {
				this.https = Boolean.FALSE;
				this.host = "127.0.0.1";
				this.port = 8500;
				this.kvPath = "acme";
				this.timeout = 2000;
			}

			public Boolean getHttps() {
				return https;
			}

			public void setHttps(Boolean https) {
				this.https = https;
			}

			public String getHost() {
				return host;
			}

			public void setHost(String host) {
				this.host = host;
			}

			public Integer getPort() {
				return port;
			}

			public void setPort(Integer port) {
				this.port = port;
			}

			public String getKvPath() {
				return kvPath;
			}

			public void setKvPath(String kvPath) {
				this.kvPath = kvPath;
			}

			public Integer getTimeout() {
				return timeout;
			}

			public void setTimeout(Integer timeout) {
				this.timeout = timeout;
			}

			public String getToken() {
				return token;
			}

			public void setToken(String token) {
				this.token = token;
			}

		}

		public class VaultStorageConfig {
			private Boolean https;
			private String host;
			private Integer port;
			@JsonProperty("kv_path")
			private String kvPath;
			private Integer timeout;
			private String token;
			@JsonProperty("tls_verify")
			private Boolean tlsVerify;
			@JsonProperty("tls_server_name")
			private String tlsServerName;
			@JsonProperty("auth_method")
			private VaultAuthMethod authMethod;
			@JsonProperty("auth_path")
			private String authPath;
			@JsonProperty("auth_role")
			private String authRole;
			@JsonProperty("jwt_path")
			private String jwtPath;

			public VaultStorageConfig() {
				this.https = Boolean.FALSE;
				this.host = "127.0.0.1";
				this.port = 8200;
				this.kvPath = "acme";
				this.timeout = 2000;
				this.tlsVerify = Boolean.TRUE;
				this.authMethod = VaultAuthMethod.TOKEN;

			}

			public Boolean getHttps() {
				return https;
			}

			public void setHttps(Boolean https) {
				this.https = https;
			}

			public String getHost() {
				return host;
			}

			public void setHost(String host) {
				this.host = host;
			}

			public Integer getPort() {
				return port;
			}

			public void setPort(Integer port) {
				this.port = port;
			}

			public String getKvPath() {
				return kvPath;
			}

			public void setKvPath(String kvPath) {
				this.kvPath = kvPath;
			}

			public Integer getTimeout() {
				return timeout;
			}

			public void setTimeout(Integer timeout) {
				this.timeout = timeout;
			}

			public String getToken() {
				return token;
			}

			public void setToken(String token) {
				this.token = token;
			}

			public Boolean getTlsVerify() {
				return tlsVerify;
			}

			public void setTlsVerify(Boolean tlsVerify) {
				this.tlsVerify = tlsVerify;
			}

			public String getTlsServerName() {
				return tlsServerName;
			}

			public void setTlsServerName(String tlsServerName) {
				this.tlsServerName = tlsServerName;
			}

			public VaultAuthMethod getAuthMethod() {
				return authMethod;
			}

			public void setAuthMethod(VaultAuthMethod authMethod) {
				this.authMethod = authMethod;
			}

			public String getAuthPath() {
				return authPath;
			}

			public void setAuthPath(String authPath) {
				this.authPath = authPath;
			}

			public String getAuthRole() {
				return authRole;
			}

			public void setAuthRole(String authRole) {
				this.authRole = authRole;
			}

			public String getJwtPath() {
				return jwtPath;
			}

			public void setJwtPath(String jwtPath) {
				this.jwtPath = jwtPath;
			}

		}

	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String accountEmail;
		private String apiURI;
		private CertType certType;
		private Set<String> domains;
		private Boolean allowAnyDomain;
		private Integer failBackOffMinutes;
		private Integer renewThresholdDays;
		private BackendStorage backendStorage;
		private StorageConfig storageConfig;
		private Boolean tosAccepted;
		private String eabKid;
		private String eabHMACKey;
		private Integer rsaKeySize;

		private Builder() {
		}

		public Builder withAccountEmail(String accountEmail) {
			this.accountEmail = accountEmail;
			return this;
		}

		public Builder withApiURI(String apiURI) {
			this.apiURI = apiURI;
			return this;
		}

		public Builder withCertType(CertType certType) {
			this.certType = certType;
			return this;
		}

		public Builder withDomains(Set<String> domains) {
			this.domains = domains;
			return this;
		}

		public Builder withAllowAnyDomain(Boolean allowAnyDomain) {
			this.allowAnyDomain = allowAnyDomain;
			return this;
		}

		public Builder withFailBackOffMinutes(Integer failBackOffMinutes) {
			this.failBackOffMinutes = failBackOffMinutes;
			return this;
		}

		public Builder withRenewThresholdDays(Integer renewThresholdDays) {
			this.renewThresholdDays = renewThresholdDays;
			return this;
		}

		public Builder withBackendStorage(BackendStorage backendStorage) {
			this.backendStorage = backendStorage;
			return this;
		}

		public Builder withStorageConfig(StorageConfig storageConfig) {
			this.storageConfig = storageConfig;
			return this;
		}

		public Builder withTosAccepted(Boolean tosAccepted) {
			this.tosAccepted = tosAccepted;
			return this;
		}

		public Builder withEabKid(String eabKid) {
			this.eabKid = eabKid;
			return this;
		}

		public Builder withEabHMACKey(String eabHMACKey) {
			this.eabHMACKey = eabHMACKey;
			return this;
		}

		public Builder withRsaKeySize(Integer rsaKeySize) {
			this.rsaKeySize = rsaKeySize;
			return this;
		}

		public ACMEConfig build() {
			apiURI = ValidateUtils.defaultIfEmpty(apiURI, "https://acme-v02.api.letsencrypt.org/directory");
			certType = ValidateUtils.defaultIfNull(certType, CertType.RSA);
			domains = ValidateUtils.defaultIfNull(domains, new HashSet<>(1));
			allowAnyDomain = ValidateUtils.defaultIfNull(allowAnyDomain, Boolean.FALSE);
			failBackOffMinutes = ValidateUtils.defaultIfNull(failBackOffMinutes, 5);
			renewThresholdDays = ValidateUtils.defaultIfNull(renewThresholdDays, 14);
			backendStorage = ValidateUtils.defaultIfNull(backendStorage, BackendStorage.SHM);
			tosAccepted = ValidateUtils.defaultIfNull(tosAccepted, Boolean.FALSE);
			rsaKeySize = ValidateUtils.defaultIfNull(rsaKeySize, 4096);
			ValidateUtils.isBlank(accountEmail, "accountEmail should not be null");
			verifyRSAKeySize(rsaKeySize);
			return new ACMEConfig(this);
		}
	}

}
