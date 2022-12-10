package com.github.ungle.kong.client.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.ungle.kong.client.model.IdNameRelation;
import com.github.ungle.kong.client.requests.KeyRequest.PEMKeyPair;

public class KeyResponse {

	private String name;
	private String kid;
	private String jwk;
	private PEMKeyPair pem;
	private IdNameRelation set;
	private Set<String> tags;

	@JsonProperty("created_at")
	private Long createdAt;

	@JsonProperty("updated_at")
	private Long updatedAt;

	@JsonProperty("id")
	private String id;

	public KeyResponse() {

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

	public String getKid() {
		return kid;
	}

	public void setKid(String kid) {
		this.kid = kid;
	}

	public String getJwk() {
		return jwk;
	}

	public void setJwk(String jwk) {
		this.jwk = jwk;
	}

	public PEMKeyPair getPem() {
		return pem;
	}

	public void setPem(PEMKeyPair pem) {
		this.pem = pem;
	}

	public IdNameRelation getSet() {
		return set;
	}

	public void setSet(IdNameRelation set) {
		this.set = set;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

}
