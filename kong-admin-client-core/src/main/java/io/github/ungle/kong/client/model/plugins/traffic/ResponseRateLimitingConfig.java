package io.github.ungle.kong.client.model.plugins.traffic;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.RateLimitingPolicy;
import io.github.ungle.kong.client.enums.RateLimitingAggregation.ResponseRateLimitingAggregation;
import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

public class ResponseRateLimitingConfig extends PluginConfig {
	@JsonProperty("limit_by")
	private ResponseRateLimitingAggregation limitBy;
	@JsonProperty("header_name")
	private String headerName;
	private RateLimitingPolicy policy;
	@JsonProperty("block_on_first_violation")
	private Boolean blockOnFirstViolation;
	@JsonProperty("fault_tolerant")
	private Boolean faultTolerent;
	@JsonProperty("hide_client_headers")
	private Boolean hideClientHeaders;
	@JsonProperty("redis_host")
	private String redisHost;
	@JsonProperty("redis_port")
	private Integer redisPort;
	@JsonProperty("redis_username")
	private String redisUsername;
	@JsonProperty("redis_password")
	private String redisPassword;
	@JsonProperty("redis_ssl")
	private Boolean redisSSL;
	@JsonProperty("redis_ssl_verify")
	private Boolean redisSSLVerify;
	@JsonProperty("redis_server_name")
	private String redisServerName;
	@JsonProperty("redis_timeout")
	private Integer redisTimeout;
	@JsonProperty("redis_database")
	private Integer redisDatabase;
	private Map<String, RateLimitData> limits;

	private ResponseRateLimitingConfig(Builder builder) {
		this.limitBy = builder.limitBy;
		this.headerName = builder.headerName;
		this.policy = builder.policy;
		this.blockOnFirstViolation = builder.blockOnFirstViolation;
		this.faultTolerent = builder.faultTolerent;
		this.hideClientHeaders = builder.hideClientHeaders;
		this.redisHost = builder.redisHost;
		this.redisPort = builder.redisPort;
		this.redisUsername = builder.redisUsername;
		this.redisPassword = builder.redisPassword;
		this.redisSSL = builder.redisSSL;
		this.redisSSLVerify = builder.redisSSLVerify;
		this.redisServerName = builder.redisServerName;
		this.redisTimeout = builder.redisTimeout;
		this.redisDatabase = builder.redisDatabase;
		this.limits = builder.limits;
	}

	public ResponseRateLimitingAggregation getLimitBy() {
		return limitBy;
	}

	public String getHeaderName() {
		return headerName;
	}

	public RateLimitingPolicy getPolicy() {
		return policy;
	}

	public Boolean getBlockOnFirstViolation() {
		return blockOnFirstViolation;
	}

	public Boolean getFaultTolerent() {
		return faultTolerent;
	}

	public Boolean getHideClientHeaders() {
		return hideClientHeaders;
	}

	public String getRedisHost() {
		return redisHost;
	}

	public Integer getRedisPort() {
		return redisPort;
	}

	public String getRedisUsername() {
		return redisUsername;
	}

	public String getRedisPassword() {
		return redisPassword;
	}

	public Boolean getRedisSSL() {
		return redisSSL;
	}

	public Boolean getRedisSSLVerify() {
		return redisSSLVerify;
	}

	public String getRedisServerName() {
		return redisServerName;
	}

	public Integer getRedisTimeout() {
		return redisTimeout;
	}

	public Integer getRedisDatabase() {
		return redisDatabase;
	}

	public Map<String, RateLimitData> getLimits() {
		return limits;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private ResponseRateLimitingAggregation limitBy;
		private String headerName;
		private RateLimitingPolicy policy;
		private Boolean blockOnFirstViolation;
		private Boolean faultTolerent;
		private Boolean hideClientHeaders;
		private String redisHost;
		private Integer redisPort;
		private String redisUsername;
		private String redisPassword;
		private Boolean redisSSL;
		private Boolean redisSSLVerify;
		private String redisServerName;
		private Integer redisTimeout;
		private Integer redisDatabase;
		private Map<String, RateLimitData> limits;

		private Builder() {
		}

		public Builder withLimitBy(ResponseRateLimitingAggregation limitBy) {
			this.limitBy = limitBy;
			return this;
		}

		public Builder withHeaderName(String headerName) {
			this.headerName = headerName;
			return this;
		}

		public Builder withPolicy(RateLimitingPolicy policy) {
			this.policy = policy;
			return this;
		}

		public Builder withBlockOnFirstViolation(Boolean blockOnFirstViolation) {
			this.blockOnFirstViolation = blockOnFirstViolation;
			return this;
		}

		public Builder withFaultTolerent(Boolean faultTolerent) {
			this.faultTolerent = faultTolerent;
			return this;
		}

		public Builder withHideClientHeaders(Boolean hideClientHeaders) {
			this.hideClientHeaders = hideClientHeaders;
			return this;
		}

		public Builder withRedisHost(String redisHost) {
			this.redisHost = redisHost;
			return this;
		}

		public Builder withRedisPort(Integer redisPort) {
			this.redisPort = redisPort;
			return this;
		}

		public Builder withRedisUsername(String redisUsername) {
			this.redisUsername = redisUsername;
			return this;
		}

		public Builder withRedisPassword(String redisPassword) {
			this.redisPassword = redisPassword;
			return this;
		}

		public Builder withRedisSSL(Boolean redisSSL) {
			this.redisSSL = redisSSL;
			return this;
		}

		public Builder withRedisSSLVerify(Boolean redisSSLVerify) {
			this.redisSSLVerify = redisSSLVerify;
			return this;
		}

		public Builder withRedisServerName(String redisServerName) {
			this.redisServerName = redisServerName;
			return this;
		}

		public Builder withRedisTimeout(Integer redisTimeout) {
			this.redisTimeout = redisTimeout;
			return this;
		}

		public Builder withRedisDatabase(Integer redisDatabase) {
			this.redisDatabase = redisDatabase;
			return this;
		}

		public Builder addLimit(String limitName, RateLimitData limit) {
			if (limits == null) {
				limits = new HashMap<>();
			}
			limits.put(limitName, limit);
			return this;
		}

		public Builder addAllLimits(Map<String, RateLimitData> limits) {
			if (limits == null) {
				return this;
			}
			if (this.limits == null) {
				this.limits = new HashMap<>(limits.size());
			}
			this.limits.putAll(limits);
			return this;
		}

		public Builder withLimits(Map<String, RateLimitData> limits) {
			this.limits = limits;
			return this;
		}

		private void verifyPolicy() {
			if (RateLimitingPolicy.REDIS.equals(policy)
					&& (redisHost == null || redisPort == null || redisTimeout == null)) {
				throw new IllegalArgumentException("redis param must be specified when policy is redis");
			}
		}

		public ResponseRateLimitingConfig build() {
			limitBy = ValidateUtils.defaultIfNull(limitBy, ResponseRateLimitingAggregation.CONSUMER);
			policy = ValidateUtils.defaultIfNull(policy, RateLimitingPolicy.LOCAL);
			redisSSL = ValidateUtils.defaultIfNull(redisSSL, Boolean.FALSE);
			blockOnFirstViolation = ValidateUtils.defaultIfNull(blockOnFirstViolation, Boolean.FALSE);
			verifyPolicy();
			return new ResponseRateLimitingConfig(this);
		}
	}

}
