package io.github.ungle.kong.client.response.plugins;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.IdNameRelation;

import java.util.List;
import java.util.Set;

/**
 * 
 * @author ungle
 *
 */
public class OAuth2CredentialsResponse {
	@JsonProperty("created_at")
	private Long createdAt;

	private String id;

	private Set<String> tags;

	private String name;

	@JsonProperty("client_secret")
	private String clientSecret;

	@JsonProperty("client_id")
	private String clientId;

	@JsonProperty("redirect_uris")
	private List<String> redirectUris;

	@JsonProperty("hash_secret")
	private Boolean hashSecret;

	@JsonProperty("client_type")
	private String clientType;

	@JsonProperty("consumer")
	private IdNameRelation consumer;

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientSecret() {
		return clientSecret;
	}

	public void setClientSecret(String clientSecret) {
		this.clientSecret = clientSecret;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public List<String> getRedirectUris() {
		return redirectUris;
	}

	public void setRedirectUris(List<String> redirectUris) {
		this.redirectUris = redirectUris;
	}

	public Boolean getHashSecret() {
		return hashSecret;
	}

	public void setHashSecret(Boolean hashSecret) {
		this.hashSecret = hashSecret;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public IdNameRelation getConsumer() {
		return consumer;
	}

	public void setConsumer(IdNameRelation consumer) {
		this.consumer = consumer;
	}
}
