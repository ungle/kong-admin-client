package io.github.ungle.kong.springboot.configuration;

import feign.Retryer;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.ungle.kong.client.api.*;
import io.github.ungle.kong.client.api.plugins.*;
import io.github.ungle.kong.client.feignclient.KongClientFactory;
import io.github.ungle.kong.client.feignclient.KongLegacyDecoder;

@EnableConfigurationProperties(KongProperties.class)
@ConditionalOnProperty(value = "kong.client.enabled", matchIfMissing = true)
@Configuration
public class KongAutoConfiguration {

	private static final Logger log = LoggerFactory.getLogger(KongAutoConfiguration.class);

	@Autowired
	private KongProperties kongProperties;

	@Bean("kongOkHttp")
	public OkHttpClient okHttpClient() {
		return new OkHttpClient.Builder().connectTimeout(kongProperties.getOkhttp().getConnectTimeout())
				.callTimeout(kongProperties.getOkhttp().getCallTimeout())
				.readTimeout(kongProperties.getOkhttp().getReadTimeout())
				.writeTimeout(kongProperties.getOkhttp().getWriteTimeout())
				.connectionPool(new ConnectionPool(kongProperties.getOkhttp().getPool().getMaxIdleConnections(),
						kongProperties.getOkhttp().getPool().getKeepAliveDuration(),
						kongProperties.getOkhttp().getPool().getTimeUnit()))
				.build();
	}

	@Bean("kongClientFactory")
	@ConditionalOnMissingBean({ KongClientFactory.class })
	public KongClientFactory kongClientFactory(@Qualifier("kongOkHttp") OkHttpClient okHttpClient) {
		if (log.isDebugEnabled()) {
			log.debug("kong config properties info: {}", kongProperties.toString());
		}
		KongClientFactory.Builder builder = KongClientFactory.builder().client(okHttpClient)
				.retryer(new Retryer.Default(kongProperties.getRetry().getPeriod(),
						kongProperties.getRetry().getMaxPeriod(), kongProperties.getRetry().getMaxAttempts()))
				.logLevel(kongProperties.getLogLevel()).targets(kongProperties.getTargets());
		if (kongProperties.getAuth() != null) {
			KongAuthProperties authProperties = kongProperties.getAuth();

			if (authProperties.getBasicAuth() != null) {
				builder.basicAuth(authProperties.getBasicAuth().getUsername(),
						authProperties.getBasicAuth().getPassword());
			} else if (authProperties.getKeyAuth() != null) {
				builder.keyAuth(authProperties.getKeyAuth().getHeaderName(), authProperties.getKeyAuth().getApiKey());
			}
		}
		if (kongProperties.getUseLegacyDecoder()) {
			builder.decoder(new KongLegacyDecoder());
		}

		return builder.build();
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(TagApi.class)
	public TagApi tagApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(TagApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(ConsumerApi.class)
	public ConsumerApi consumerApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(ConsumerApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(PluginApi.class)
	public PluginApi pluginApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(PluginApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(RouteApi.class)
	public RouteApi routeApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(RouteApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(ServiceApi.class)
	public ServiceApi serviceApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(ServiceApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(TargetApi.class)
	public TargetApi targetApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(TargetApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(UpstreamApi.class)
	public UpstreamApi upstreamApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(UpstreamApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(AclApi.class)
	public AclApi aclApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(AclApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(Oauth2Api.class)
	public Oauth2Api oauth2Api(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(Oauth2Api.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(BasicAuthCredentialsApi.class)
	public BasicAuthCredentialsApi basicAuthCredentials(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(BasicAuthCredentialsApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(HMACAuthCredentialsApi.class)
	public HMACAuthCredentialsApi hmacAuthCredentials(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(HMACAuthCredentialsApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(KeyAuthCredentialsApi.class)
	public KeyAuthCredentialsApi keyAuthCredentials(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(KeyAuthCredentialsApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(JWTCredentialsApi.class)
	public JWTCredentialsApi jwtCredentials(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(JWTCredentialsApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(InformationApi.class)
	public InformationApi informationApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(InformationApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(CACertificateApi.class)
	public CACertificateApi caCertificateApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(CACertificateApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(CertificateApi.class)
	public CertificateApi certificateApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(CertificateApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(KeyApi.class)
	public KeyApi keyApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(KeyApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(KeySetApi.class)
	public KeySetApi keySetApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(KeySetApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(SchemaApi.class)
	public SchemaApi schemaApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(SchemaApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(SNIApi.class)
	public SNIApi sniApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(SNIApi.class);
	}

	@Bean
	@ConditionalOnBean(name = { "kongClientFactory" })
	@ConditionalOnMissingBean(VaultApi.class)
	public VaultApi vaultApi(KongClientFactory kongClientFactory) {
		return kongClientFactory.getApiInstance(VaultApi.class);
	}

}
