package org.kastin.kong.client.model.plugins;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public class CustomizedMapConfig extends PluginConfig {

	private Map<String, Object> properties;

	private CustomizedMapConfig(Builder builder) {
		this.properties = builder.properties;
	}

	@JsonValue
	public Map<String, Object> getProperties() {
		return properties;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Map<String, Object> properties;

		private Builder() {
			properties = new HashMap<>();
		}

		private Builder(int size) {
			properties = new HashMap<>(size);
		}

		public Builder withProperties(Map<String, Object> properties) {
			this.properties.clear();
			this.properties.putAll(properties);
			return this;
		}

		public Builder addProperties(Map<String, Object> properties) {
			this.properties.putAll(properties);
			return this;
		}

		public Builder addProperty(String propertyName, Object propertyValue) {
			this.properties.put(propertyName, propertyValue);
			return this;
		}

		public CustomizedMapConfig build() {
			return new CustomizedMapConfig(this);
		}
	}

}
