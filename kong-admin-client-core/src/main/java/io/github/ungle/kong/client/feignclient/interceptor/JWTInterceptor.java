package io.github.ungle.kong.client.feignclient.interceptor;

import java.lang.reflect.Method;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.interfaces.ECKey;
import java.security.interfaces.RSAKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.Util;
import io.github.ungle.kong.client.enums.JWTAlgorithm;

public class JWTInterceptor implements RequestInterceptor {

	private final String key;
	private final Algorithm algorithm;
	private final String keyClaimName;
	private final String authorizationName;
	private final AllowedJWTRetrievePositions authorizationPosition;

	public JWTInterceptor(String key, JWTAlgorithm algorithm, String secret, String rsaPrivateKey, String keyClaimName,
			String authorizationName, AllowedJWTRetrievePositions authorizationPosition) {

		this.key = key;
		Algorithm algor = null;
		Class<Algorithm> claz = Algorithm.class;
		Method m = null;
		String name = JWTAlgorithm.getAliasName(algorithm);
		if (JWTAlgorithm.needSecret(algorithm)) {
			if (Util.isBlank(secret)) {
				throw new IllegalArgumentException("algorithm " + name + " needs secret");
			}

			try {
				m = claz.getDeclaredMethod(name, String.class);
				algor = (Algorithm) m.invoke(null, secret);
			} catch (Exception e) {
				throw new RuntimeException(e);
			}

		} else {
			if (Util.isBlank(rsaPrivateKey)) {
				throw new IllegalArgumentException("algorithm " + name + " needs private key");
			}
			if (name.startsWith("ECDSA")) {

				try {
					m = claz.getDeclaredMethod(name, ECKey.class);
					algor = (Algorithm) m.invoke(null, (ECKey) getPrivateKey(key, "EC"));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			} else {

				try {
					m = claz.getDeclaredMethod(name, RSAKey.class);
					algor = (Algorithm) m.invoke(null, (RSAKey) getPrivateKey(key, "RSA"));
				} catch (Exception e) {
					throw new RuntimeException(e);
				}
			}

		}
		this.algorithm = algor;
		this.keyClaimName = keyClaimName;
		this.authorizationName = authorizationName;
		this.authorizationPosition = authorizationPosition;
	}

	private static PrivateKey getPrivateKey(String key, String algorithm) {
		PrivateKey privateKey = null;
		try {
			KeyFactory kf = KeyFactory.getInstance(algorithm);
			EncodedKeySpec keySpec;
			keySpec = new PKCS8EncodedKeySpec(key.getBytes("utf-8"));
			privateKey = kf.generatePrivate(keySpec);
			return privateKey;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void apply(RequestTemplate template) {
		String jwtToken = JWT.create().withIssuer(key).withIssuedAt(new Date()).withClaim(keyClaimName, key).sign(algorithm);
		if (AllowedJWTRetrievePositions.HEADER.equals(authorizationPosition)) {
			template.header(authorizationName, "Bearer "+ jwtToken);
		} else if (AllowedJWTRetrievePositions.COOKIE.equals(authorizationPosition)) {
			template.header("cookie", authorizationName + "=" + jwtToken);
		} else {
			template.query(authorizationName, jwtToken);
		}
	}

}
