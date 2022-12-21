package io.github.ungle.kong.client.response.plugins;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.IdNameRelation;

public class BasicAuthCredentialsResponse {

	private String id;
	
	@JsonProperty("created_at")
	private Long createdAt;

	private Set<String> tags;

	private String username;

	private String password;
	
	private IdNameRelation consumer;

	public BasicAuthCredentialsResponse() {
		super();
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

	public IdNameRelation getConsumer() {
		return consumer;
	}

	public void setConsumer(IdNameRelation consumer) {
		this.consumer = consumer;
	}

}
