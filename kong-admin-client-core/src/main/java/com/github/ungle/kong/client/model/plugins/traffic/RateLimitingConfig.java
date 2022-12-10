package com.github.ungle.kong.client.model.plugins.traffic;

import java.util.Objects;
import java.util.stream.Stream;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ungle.kong.client.enums.RateLimitingAggregation;
import com.github.ungle.kong.client.enums.RateLimitingPolicy;
import com.github.ungle.kong.client.model.plugins.PluginConfig;
import com.github.ungle.kong.client.service.ValidateUtils;

public class RateLimitingConfig extends PluginConfig {
	private Long second;
	private Long minute;
	private Long hour;
	private Long day;
	private Long month;
	private Long year;
	@JsonProperty("limit_by")
	private RateLimitingAggregation limitBy;
	@JsonProperty("header_name")
	private String headerName;
	private String path;
	private RateLimitingPolicy policy;
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

	private RateLimitingConfig(Builder builder) {
		super();
		this.second = builder.second;
		this.minute = builder.minute;
		this.hour = builder.hour;
		this.day = builder.day;
		this.month = builder.month;
		this.year = builder.year;
		this.limitBy = builder.limitBy;
		this.headerName = builder.headerName;
		this.path = builder.path;
		this.policy = builder.policy;
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
	}

	public RateLimitingConfig(Long second, Long minute, Long hour, Long day, Long month, Long year) {
		super();
		this.second = second;
		this.minute = minute;
		this.hour = hour;
		this.day = day;
		this.month = month;
		this.year = year;
		this.limitBy = RateLimitingAggregation.CONSUMER;
		this.policy = RateLimitingPolicy.LOCAL;
		this.redisSSL = Boolean.FALSE;
	}

	public Long getSecond() {
		return second;
	}

	public Long getMinute() {
		return minute;
	}

	public Long getHour() {
		return hour;
	}

	public Long getDay() {
		return day;
	}

	public Long getMonth() {
		return month;
	}

	public Long getYear() {
		return year;
	}

	public RateLimitingAggregation getLimitBy() {
		return limitBy;
	}

	public String getHeaderName() {
		return headerName;
	}

	public String getPath() {
		return path;
	}

	public RateLimitingPolicy getPolicy() {
		return policy;
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

	private static void verifyPolicy(RateLimitingPolicy policy, String redisHost, Integer redisPort,
			Integer redisTimeout) {
		if (RateLimitingPolicy.REDIS.equals(policy)
				&& (redisHost == null || redisPort == null || redisTimeout == null)) {
			throw new IllegalArgumentException("redis param must be specified when policy is redis");
		}
	}

	private static void verifyRate(Long... rates) {
		Stream<Long> stream = Stream.of(rates);
		if (stream.allMatch(Objects::isNull)) {
			throw new IllegalArgumentException(
					"the rate limit params second,minute,hour,day,month,year must have at least one non-null");
		}
		stream = Stream.of(rates);
		if (stream.filter(Objects::nonNull).anyMatch(t -> t <= 0)) {
			throw new IllegalArgumentException("the rate limit must greater than 0");
		}

	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Long second;
		private Long minute;
		private Long hour;
		private Long day;
		private Long month;
		private Long year;
		private RateLimitingAggregation limitBy;
		private String headerName;
		private String path;
		private RateLimitingPolicy policy;
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

		private Builder() {
		}

		public Builder withSecond(Long second) {
			this.second = second;
			return this;
		}

		public Builder withMinute(Long minute) {
			this.minute = minute;
			return this;
		}

		public Builder withHour(Long hour) {
			this.hour = hour;
			return this;
		}

		public Builder withDay(Long day) {
			this.day = day;
			return this;
		}

		public Builder withMonth(Long month) {
			this.month = month;
			return this;
		}

		public Builder withYear(Long year) {
			this.year = year;
			return this;
		}

		public Builder withLimitBy(RateLimitingAggregation limitBy) {
			this.limitBy = limitBy;
			return this;
		}

		public Builder withHeaderName(String headerName) {
			this.headerName = headerName;
			return this;
		}

		public Builder withPath(String path) {
			this.path = path;
			return this;
		}

		public Builder withPolicy(RateLimitingPolicy policy) {
			this.policy = policy;
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

		public RateLimitingConfig build() {
			limitBy = ValidateUtils.defaultIfNull(limitBy, RateLimitingAggregation.CONSUMER);
			policy = ValidateUtils.defaultIfNull(policy, RateLimitingPolicy.LOCAL);
			redisSSL = ValidateUtils.defaultIfNull(redisSSL, Boolean.FALSE);
			verifyPolicy(policy, redisHost, redisPort, redisTimeout);
			verifyRate(second, minute, hour, day, month, year);
			return new RateLimitingConfig(this);
		}
	}

}
