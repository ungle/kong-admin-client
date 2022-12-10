package io.github.ungle.kong.client.response;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CertificateResponse {
	private String id;

	@JsonProperty("created_at")
	private Long createdAt;

	private String cert;
	private String key;
	@JsonProperty("cert_alt")
	private String certAlt;
	@JsonProperty("key_alt")
	private String keyAlt;
	private Set<String> tags;
	private Set<String> snis;

	public CertificateResponse() {

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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getCertAlt() {
		return certAlt;
	}

	public void setCertAlt(String certAlt) {
		this.certAlt = certAlt;
	}

	public String getKeyAlt() {
		return keyAlt;
	}

	public void setKeyAlt(String keyAlt) {
		this.keyAlt = keyAlt;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

	public Set<String> getSnis() {
		return snis;
	}

	public void setSnis(Set<String> snis) {
		this.snis = snis;
	}

}
