package io.github.ungle.kong.client.model.plugins.transformation;

import java.util.List;

import io.github.ungle.kong.client.model.plugins.PluginConfig;

public class RequestTransformerConfig extends PluginConfig {
	private String httpMethod;
	private RequestOperation remove;
	private ReplaceRequestOperation replace;
	private RequestOperation rename;
	private RequestOperation add;
	private RequestOperation append;

	private RequestTransformerConfig(Builder builder) {
		this.httpMethod = builder.httpMethod;
		this.remove = builder.remove;
		this.replace = builder.replace;
		this.rename = builder.rename;
		this.add = builder.add;
		this.append = builder.append;
	}

	public String getHttpMethod() {
		return httpMethod;
	}

	public RequestOperation getRemove() {
		return remove;
	}

	public ReplaceRequestOperation getReplace() {
		return replace;
	}

	public RequestOperation getRename() {
		return rename;
	}

	public RequestOperation getAdd() {
		return add;
	}

	public RequestOperation getAppend() {
		return append;
	}

	public static class RequestOperation {

		private List<String> headers;

		private List<String> body;

		private List<String> querystring;
		

		public List<String> getHeaders() {
			return headers;
		}

		public void setHeaders(List<String> headers) {
			this.headers = headers;
		}

		public List<String> getBody() {
			return body;
		}

		public void setBody(List<String> body) {
			this.body = body;
		}

		public List<String> getQuerystring() {
			return querystring;
		}

		public void setQuerystring(List<String> querystring) {
			this.querystring = querystring;
		}

	}

	public static class ReplaceRequestOperation extends RequestOperation {

		private String uri;

		public ReplaceRequestOperation() {
			super();
		}

		public String getUri() {
			return uri;
		}

		public void setUri(String uri) {
			this.uri = uri;
		}

	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String httpMethod;
		private RequestOperation remove;
		private ReplaceRequestOperation replace;
		private RequestOperation rename;
		private RequestOperation add;
		private RequestOperation append;

		private Builder() {
		}

		public Builder withHttpMethod(String httpMethod) {
			this.httpMethod = httpMethod;
			return this;
		}

		public Builder withRemove(RequestOperation remove) {
			this.remove = remove;
			return this;
		}

		public Builder withReplace(ReplaceRequestOperation replace) {
			this.replace = replace;
			return this;
		}

		public Builder withRename(RequestOperation rename) {
			this.rename = rename;
			return this;
		}

		public Builder withAdd(RequestOperation add) {
			this.add = add;
			return this;
		}

		public Builder withAppend(RequestOperation append) {
			this.append = append;
			return this;
		}

		public RequestTransformerConfig build() {
			return new RequestTransformerConfig(this);
		}
	}

}
