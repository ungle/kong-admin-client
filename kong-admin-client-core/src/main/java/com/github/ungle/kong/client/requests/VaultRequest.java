package com.github.ungle.kong.client.requests;

import java.util.Map;
import java.util.Set;

public class VaultRequest extends Request {

	private String prefix;

	private String name;

	private String description;

	private Map<String, Object> config;

	private Set<String> tags;

	public VaultRequest() {
		super();

	}

	public VaultRequest(String prefix, String name) {
		super();
		this.prefix = prefix;
		this.name = name;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Map<String, Object> getConfig() {
		return config;
	}

	public void setConfig(Map<String, Object> config) {
		this.config = config;
	}

	public Set<String> getTags() {
		return tags;
	}

	public void setTags(Set<String> tags) {
		this.tags = tags;
	}

}
