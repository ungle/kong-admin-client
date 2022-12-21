package io.github.ungle.kong.springboot.configuration;

import io.github.ungle.kong.client.enums.JWTAlgorithm;
import io.github.ungle.kong.client.feignclient.interceptor.AllowedJWTRetrievePositions;

/**
 * @author ungle
 */

public class KongAuthProperties {

	private BasicAuthProperties basicAuth;
	private KeyAuthProperties keyAuth;
	private JWTAuthProperties jwtAuth;

	@Override
	public String toString() {
		return "KongAuthProperties [basicAuth=" + basicAuth + ", keyAuth=" + keyAuth + ", jwtAuth=" + jwtAuth + "]";
	}

	public BasicAuthProperties getBasicAuth() {
		return basicAuth;
	}

	public void setBasicAuth(BasicAuthProperties basicAuth) {
		this.basicAuth = basicAuth;
	}

	public KeyAuthProperties getKeyAuth() {
		return keyAuth;
	}

	public void setKeyAuth(KeyAuthProperties keyAuth) {
		this.keyAuth = keyAuth;
	}

	public JWTAuthProperties getJwtAuth() {
		return jwtAuth;
	}

	public void setJwtAuth(JWTAuthProperties jwtAuth) {
		this.jwtAuth = jwtAuth;
	}

	public static class BasicAuthProperties {
		private String username;
		private String password;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "BasicAuthProperties{" + "username='" + username + '\'' + ", password='" + password + '\'' + '}';
		}
	}

	public static class KeyAuthProperties {
		private String headerName;
		private String apiKey;

		public String getHeaderName() {
			return headerName;
		}

		public void setHeaderName(String headerName) {
			this.headerName = headerName;
		}

		public String getApiKey() {
			return apiKey;
		}

		public void setApiKey(String apiKey) {
			this.apiKey = apiKey;
		}

		@Override
		public String toString() {
			return "KeyAuthProperties{" + "headerName='" + headerName + '\'' + ", apiKey='" + apiKey + '\'' + '}';
		}
	}

	public static class JWTAuthProperties {
		private String key;
		private JWTAlgorithm algorithm;
		private String secret;
		private String rsaPrivateKey;
		private String keyClaimName;
		private String authorizationName;
		private AllowedJWTRetrievePositions authorizationPosition;

		public JWTAuthProperties(String key, JWTAlgorithm algorithm, String secret, String rsaPrivateKey,
				String keyClaimName, String authorizationName, AllowedJWTRetrievePositions authorizationPosition) {
			super();
			this.key = key;
			this.algorithm = algorithm;
			this.secret = secret;
			this.rsaPrivateKey = rsaPrivateKey;
			this.keyClaimName = keyClaimName;
			this.authorizationName = authorizationName;
			this.authorizationPosition = authorizationPosition;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public JWTAlgorithm getAlgorithm() {
			return algorithm;
		}

		public void setAlgorithm(JWTAlgorithm algorithm) {
			this.algorithm = algorithm;
		}

		public String getSecret() {
			return secret;
		}

		public void setSecret(String secret) {
			this.secret = secret;
		}

		public String getRsaPrivateKey() {
			return rsaPrivateKey;
		}

		public void setRsaPrivateKey(String rsaPrivateKey) {
			this.rsaPrivateKey = rsaPrivateKey;
		}

		public String getKeyClaimName() {
			return keyClaimName;
		}

		public void setKeyClaimName(String keyClaimName) {
			this.keyClaimName = keyClaimName;
		}

		public String getAuthorizationName() {
			return authorizationName;
		}

		public void setAuthorizationName(String authorizationName) {
			this.authorizationName = authorizationName;
		}

		public AllowedJWTRetrievePositions getAuthorizationPosition() {
			return authorizationPosition;
		}

		public void setAuthorizationPosition(AllowedJWTRetrievePositions authorizationPosition) {
			this.authorizationPosition = authorizationPosition;
		}

		@Override
		public String toString() {
			return "JWTAuthProperties [key=" + key + ", algorithm=" + algorithm + ", secret=" + secret
					+ ", rsaPrivateKey=" + rsaPrivateKey + ", keyClaimName=" + keyClaimName + ", authorizationName="
					+ authorizationName + ", authorizationPosition=" + authorizationPosition + "]";
		}

	}
}
