package io.github.ungle.kong.client.requests.plugins;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.JWTAlgorithm;
import io.github.ungle.kong.client.requests.Request;

public class JWTCredentialsRequest extends Request {


	private String key;

	private JWTAlgorithm algorithm;

	@JsonProperty("rsa_public_key")
	private String rsaPublicKey;

	private String secret;
	

	public JWTCredentialsRequest() {
		super();
		algorithm = JWTAlgorithm.HS256;
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

	public String getRsaPublicKey() {
		return rsaPublicKey;
	}

	public void setRsaPublicKey(String rsaPublicKey) {
		this.rsaPublicKey = rsaPublicKey;
	}

	public String getSecret() {
		return secret;
	}

	public void setSecret(String secret) {
		this.secret = secret;
	}

}
