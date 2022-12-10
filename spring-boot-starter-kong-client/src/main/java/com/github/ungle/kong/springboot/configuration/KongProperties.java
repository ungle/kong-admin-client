package com.github.ungle.kong.springboot.configuration;

import feign.Logger;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * @author ungle
 */
@ConfigurationProperties(prefix = "kong.client")
public class KongProperties {
    /**
     * target info
     */
    private List<String> targets = new LinkedList<>();

    /**
     * okhttp configuration
     */
    private OkHttpProperties okhttp = new OkHttpProperties();

    private RetryerProperties retry = new RetryerProperties();

    private KongAuthProperties auth;

    private Logger.Level logLevel = Logger.Level.BASIC;
    
    private Boolean useLegencyDecoder = Boolean.FALSE;

    public KongProperties() {
    }

    public Logger.Level getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(Logger.Level logLevel) {
        this.logLevel = logLevel;
    }

    public KongAuthProperties getAuth() {
        return auth;
    }

    public void setAuth(KongAuthProperties auth) {
        this.auth = auth;
    }

    public void setOkhttp(OkHttpProperties okhttp) {
        this.okhttp = okhttp;
    }

    public RetryerProperties getRetry() {
        return retry;
    }

    public void setRetry(RetryerProperties retry) {
        this.retry = retry;
    }

    public OkHttpProperties getOkhttp() {
        return okhttp;
    }


    public List<String> getTargets() {
        return targets;
    }

    public void setTargets(List<String> targets) {
        this.targets = targets;
    }

    

    @Override
	public String toString() {
		return "KongProperties [targets=" + targets + ", okhttp=" + okhttp + ", retry=" + retry + ", auth=" + auth
				+ ", logLevel=" + logLevel + ", useLegencyDecoder=" + useLegencyDecoder + "]";
	}

	public Boolean getUseLegencyDecoder() {
		return useLegencyDecoder;
	}

	public void setUseLegencyDecoder(Boolean useLegencyDecoder) {
		this.useLegencyDecoder = useLegencyDecoder;
	}

	public static class RetryerProperties {
        private int maxAttempts = 3;
        private long period = 100;
        private long maxPeriod = SECONDS.toMillis(1);

        @Override
        public String toString() {
            return "RetryerProperties{" +
                    "maxAttempts=" + maxAttempts +
                    ", period=" + period +
                    ", maxPeriod=" + maxPeriod +
                    '}';
        }

        public int getMaxAttempts() {
            return maxAttempts;
        }

        public void setMaxAttempts(int maxAttempts) {
            this.maxAttempts = maxAttempts;
        }

        public long getPeriod() {
            return period;
        }

        public void setPeriod(long period) {
            this.period = period;
        }

        public long getMaxPeriod() {
            return maxPeriod;
        }

        public void setMaxPeriod(long maxPeriod) {
            this.maxPeriod = maxPeriod;
        }
    }

    public static class OkHttpProperties {
        private Duration connectTimeout = Duration.ofMillis(5000);
        private Duration callTimeout = Duration.ofMillis(5000);
        private Duration readTimeout = Duration.ofMillis(5000);
        private Duration writeTimeout = Duration.ofMillis(5000);
        /**
         * OKhttp pool configuration
         */
        private Pool pool = new Pool();

        public Duration getConnectTimeout() {
            return connectTimeout;
        }

        public void setConnectTimeout(Duration connectTimeout) {
            this.connectTimeout = connectTimeout;
        }

        public Duration getCallTimeout() {
            return callTimeout;
        }

        public void setCallTimeout(Duration callTimeout) {
            this.callTimeout = callTimeout;
        }

        public Duration getReadTimeout() {
            return readTimeout;
        }

        public void setReadTimeout(Duration readTimeout) {
            this.readTimeout = readTimeout;
        }

        public Duration getWriteTimeout() {
            return writeTimeout;
        }

        public void setWriteTimeout(Duration writeTimeout) {
            this.writeTimeout = writeTimeout;
        }

        public Pool getPool() {
            return pool;
        }

        public void setPool(Pool pool) {
            this.pool = pool;
        }

        @Override
        public String toString() {
            return "OkHttpProperties{" +
                    "connectTimeout=" + connectTimeout +
                    ", callTimeout=" + callTimeout +
                    ", readTimeout=" + readTimeout +
                    ", writeTimeout=" + writeTimeout +
                    ", pool=" + pool +
                    '}';
        }
    }

    public static class Pool {
        private int maxIdleConnections = 5;
        private int keepAliveDuration = 5;
        private TimeUnit timeUnit = TimeUnit.MINUTES;

        public int getMaxIdleConnections() {
            return maxIdleConnections;
        }

        public void setMaxIdleConnections(int maxIdleConnections) {
            this.maxIdleConnections = maxIdleConnections;
        }

        public int getKeepAliveDuration() {
            return keepAliveDuration;
        }

        public void setKeepAliveDuration(int keepAliveDuration) {
            this.keepAliveDuration = keepAliveDuration;
        }

        public TimeUnit getTimeUnit() {
            return timeUnit;
        }

        public void setTimeUnit(TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
        }

        @Override
        public String toString() {
            return "Pool{" +
                    "maxIdleConnections=" + maxIdleConnections +
                    ", keepAliveDuration=" + keepAliveDuration +
                    ", timeUnit=" + timeUnit +
                    '}';
        }
    }
}