package io.github.ungle.kong.client.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeySetResponse {

	private String name;

	private Set<String> tags;

	@JsonProperty("created_at")
	private Long createdAt;

	@JsonProperty("updated_at")
	private Long updatedAt;

	@JsonProperty("id")
	private String id;

	public KeySetResponse() {
		super();
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public Long getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Long updatedAt) {
		this.updatedAt = updatedAt;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

}
