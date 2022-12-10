package com.github.ungle.kong.client.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ungle.kong.client.model.IdNameRelation;

public class SNIResponse {

	private String id;

	@JsonProperty("created_at")
	private Long createdAt;

	private String name;

	private IdNameRelation certificate;

	private Set<String> tags;

	public SNIResponse() {

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IdNameRelation getCertificate() {
		return certificate;
	}

	public void setCertificate(IdNameRelation certificate) {
		this.certificate = certificate;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

}
