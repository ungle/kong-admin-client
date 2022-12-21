package io.github.ungle.kong.client.response.plugins;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.enums.JWTAlgorithm;
import io.github.ungle.kong.client.model.IdNameRelation;

public class JWTCredentialsResponse {

	private String id;

	@JsonProperty("created_at")
	private Long createdAt;

	private Set<String> tags;

	private IdNameRelation consumer;

	private String key;

	private JWTAlgorithm algorithm;

	@JsonProperty("rsa_public_key")
	private String rsaPublicKey;

	private String secret;

	public JWTCredentialsResponse() {
		super();
		algorithm = JWTAlgorithm.HS256;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public IdNameRelation getConsumer() {
		return consumer;
	}

	public void setConsumer(IdNameRelation consumer) {
		this.consumer = consumer;
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
