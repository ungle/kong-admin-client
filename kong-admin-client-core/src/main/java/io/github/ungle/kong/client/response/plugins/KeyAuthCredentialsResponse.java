package io.github.ungle.kong.client.response.plugins;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.IdNameRelation;

public class KeyAuthCredentialsResponse {

	private String key;

	private Long ttl;

	private String id;

	@JsonProperty("created_at")
	private Long createdAt;

	private Set<String> tags;

	private IdNameRelation consumer;

	public KeyAuthCredentialsResponse() {
		super();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Long getTtl() {
		return ttl;
	}

	public void setTtl(Long ttl) {
		this.ttl = ttl;
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

}
