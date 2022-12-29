package io.github.ungle.kong.client.model.plugins.transformation;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.plugins.PluginConfig;

public class ResponseTransformerConfig extends PluginConfig {

	private JsonResponseOperation remove;
	private BasicResponseOperation rename;
	private JsonTypeResponseOperation replace;
	private JsonTypeResponseOperation add;
	private JsonTypeResponseOperation append;

	private ResponseTransformerConfig(Builder builder) {
		this.remove = builder.remove;
		this.rename = builder.rename;
		this.replace = builder.replace;
		this.add = builder.add;
		this.append = builder.append;
	}

	public JsonResponseOperation getRemove() {
		return remove;
	}

	public BasicResponseOperation getRename() {
		return rename;
	}

	public JsonTypeResponseOperation getReplace() {
		return replace;
	}

	public JsonTypeResponseOperation getAdd() {
		return add;
	}

	public JsonTypeResponseOperation getAppend() {
		return append;
	}

	public static class BasicResponseOperation {

		private List<String> headers;

		public List<String> getHeaders() {
			return headers;
		}

		public void setHeaders(List<String> headers) {
			this.headers = headers;
		}

	}

	public static class JsonResponseOperation {
		
		private List<String> headers;

		private List<String> json;
		
		public List<String> getHeaders() {
			return headers;
		}

		public void setHeaders(List<String> headers) {
			this.headers = headers;
		}

		public List<String> getJson() {
			return json;
		}

		public void setJson(List<String> json) {
			this.json = json;
		}

	}

	public static class JsonTypeResponseOperation {

		@JsonProperty("json_types")
		private List<String> jsonTypes;
		
		private List<String> headers;

		private List<String> json;
		
		public List<String> getHeaders() {
			return headers;
		}

		public void setHeaders(List<String> headers) {
			this.headers = headers;
		}

		public List<String> getJson() {
			return json;
		}

		public void setJson(List<String> json) {
			this.json = json;
		}

		public List<String> getJsonTypes() {
			return jsonTypes;
		}

		public void setJsonTypes(List<String> jsonTypes) {
			this.jsonTypes = jsonTypes;
		}

	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private JsonResponseOperation remove;
		private BasicResponseOperation rename;
		private JsonTypeResponseOperation replace;
		private JsonTypeResponseOperation add;
		private JsonTypeResponseOperation append;

		private Builder() {
		}

		public Builder withRemove(JsonResponseOperation remove) {
			this.remove = remove;
			return this;
		}

		public Builder withRename(BasicResponseOperation rename) {
			this.rename = rename;
			return this;
		}

		public Builder withReplace(JsonTypeResponseOperation replace) {
			this.replace = replace;
			return this;
		}

		public Builder withAdd(JsonTypeResponseOperation add) {
			this.add = add;
			return this;
		}

		public Builder withAppend(JsonTypeResponseOperation append) {
			this.append = append;
			return this;
		}

		public ResponseTransformerConfig build() {
			return new ResponseTransformerConfig(this);
		}
	}

}
