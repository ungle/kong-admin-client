package io.github.ungle.kong.client.requests;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CACertificateRequest extends Request {
	
	private String cert;
	
	@JsonProperty("cert_digest")
	private String certDigest;

	private Set<String> tags;
	
	public CACertificateRequest() {
		super();
	}
	
    public CACertificateRequest(String cert) {
		this.cert = cert;
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
