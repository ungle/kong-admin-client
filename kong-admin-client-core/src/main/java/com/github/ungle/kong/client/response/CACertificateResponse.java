package com.github.ungle.kong.client.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CACertificateResponse {

	private String id;

	@JsonProperty("created_at")
	private Long createdAt;

	private String cert;

	@JsonProperty("cert_digest")
	private String certDigest;

	private Set<String> tags;

	public CACertificateResponse() {

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

	public String getCert() {
		return cert;
	}

	public void setCert(String cert) {
		this.cert = cert;
	}

	public String getCertDigest() {
		return certDigest;
	}

	public void setCertDigest(String certDigest) {
		this.certDigest = certDigest;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

}
