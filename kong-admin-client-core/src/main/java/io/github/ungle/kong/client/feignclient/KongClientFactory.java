package io.github.ungle.kong.client.feignclient;

import feign.*;
import feign.auth.BasicAuthRequestInterceptor;
import feign.codec.Decoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import feign.slf4j.Slf4jLogger;
import io.github.ungle.kong.client.enums.JWTAlgorithm;
import io.github.ungle.kong.client.feignclient.interceptor.AllowedJWTRetrievePositions;
import io.github.ungle.kong.client.feignclient.interceptor.JWTInterceptor;
import io.github.ungle.kong.client.feignclient.interceptor.KeyAuthInterceptor;
import io.github.ungle.kong.client.feignclient.interceptor.RoundRobinBalancerInterceptor;
import io.github.ungle.kong.client.service.ValidateUtils;
import okhttp3.OkHttpClient;

import java.util.ArrayList;
import java.util.List;

import static java.util.concurrent.TimeUnit.SECONDS;

public class KongClientFactory {

	private Feign feign;

	private KongClientFactory(Feign feign) {
		this.feign = feign;
	}

	public static Builder builder() {
		return new Builder();
	}

	public <T> T getApiInstance(Class<T> targetClass) {
		return feign.newInstance(new Target.HardCodedTarget<T>(targetClass, "http://api:8001"));
	}

	public static class Builder {
		private OkHttpClient okHttpClient;
		private List<String> targets = new ArrayList<>();
		private Retryer retryer;
		private RequestInterceptor authInterceptor;
		private Logger.Level level;
		private Decoder decoder;

		public Builder client(OkHttpClient okHttpClient) {
			this.okHttpClient = okHttpClient;
			return this;
		}

		public Builder targets(List<String> targets) {
			this.targets = targets;
			return this;
		}

		public Builder addTarget(String target) {
			this.targets.add(target);
			return this;
		}

		public Builder retryer(Retryer retryer) {
			this.retryer = retryer;
			return this;
		}

		public Builder logLevel(Logger.Level level) {
				this.level = level;
			return this;
		}
		
		public Builder decoder(Decoder decoder) {
			this.decoder = decoder;
			return this;
		}

		
		public Builder basicAuth(String username, String password) {
			if (Util.isBlank(username) || Util.isBlank(password)) {
				throw new IllegalArgumentException("username and password must be non-blank");
			}
			this.authInterceptor = new BasicAuthRequestInterceptor(username, password);
			return this;
		}
		
		public Builder jwtAuth(String key, JWTAlgorithm algorithm, String secret, String rsaPrivateKey, String keyClaimName,
				String authorizationName, AllowedJWTRetrievePositions authorizationPosition) {
			this.authInterceptor = new JWTInterceptor(key, algorithm, secret, rsaPrivateKey,
					keyClaimName, authorizationName, authorizationPosition);
			return this;
		}

		public Builder keyAuth(String headerName, String apiKey) {
			if (Util.isBlank(headerName) || Util.isBlank(apiKey)) {
				throw new IllegalArgumentException("headerName and apiKey must be non-blank");
			}
			this.authInterceptor = new KeyAuthInterceptor(headerName, apiKey);
			return this;
		}

		public KongClientFactory build() {

			okHttpClient = ValidateUtils.defaultIfNull(okHttpClient, new OkHttpClient());
			retryer = ValidateUtils.defaultIfNull(retryer, new Retryer.Default(100, SECONDS.toMillis(1), 3));
			level = ValidateUtils.defaultIfNull(level, Logger.Level.BASIC);
			decoder = ValidateUtils.defaultIfNull(decoder, new JacksonDecoder());
			ValidateUtils.isEmpty(targets,"target kong server must be defined");

			Feign.Builder feignBuilder = Feign.builder().client(new feign.okhttp.OkHttpClient(okHttpClient)).decoder(decoder)
					.encoder(new JacksonEncoder()).errorDecoder(new KongErrorDecoder())
					.logLevel(level).logger(new Slf4jLogger()).retryer(retryer)
					.requestInterceptor(RoundRobinBalancerInterceptor.build(targets));
			if (authInterceptor != null) {
				feignBuilder.requestInterceptor(authInterceptor);
			}

			return new KongClientFactory(feignBuilder.build());
		}
	}

}
