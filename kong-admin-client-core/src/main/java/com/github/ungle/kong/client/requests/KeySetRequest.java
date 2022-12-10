package com.github.ungle.kong.client.requests;

import java.util.Set;

public class KeySetRequest extends Request {

	private String name;

	private Set<String> tags;

	public KeySetRequest() {
		super();
	}

	public KeySetRequest(String name, Set<String> tags) {
		super();
		this.name = name;
		this.tags = tags;
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
