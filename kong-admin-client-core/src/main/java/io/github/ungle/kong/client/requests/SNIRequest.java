package io.github.ungle.kong.client.requests;

import java.util.Set;

import io.github.ungle.kong.client.model.IdNameRelation;

public class SNIRequest extends Request {

	private String name;

	private IdNameRelation certificate;

	private Set<String> tags;

	public SNIRequest() {
		super();

	}

	public SNIRequest(String name, IdNameRelation certificate) {
		super();
		this.name = name;
		this.certificate = certificate;
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
