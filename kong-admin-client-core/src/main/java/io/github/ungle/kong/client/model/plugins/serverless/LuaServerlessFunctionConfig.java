package io.github.ungle.kong.client.model.plugins.serverless;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.plugins.PluginConfig;

/**
 * 
 * @author ungle
 *
 */
public class LuaServerlessFunctionConfig extends PluginConfig {
	private List<String> certificate;
	private List<String> rewrite;
	private List<String> access;
	@JsonProperty("header_filter")
	private List<String> headerFilter;
	@JsonProperty("body_filter")
	private List<String> bodyFilter;
	private List<String> log;

	private LuaServerlessFunctionConfig(Builder builder) {
		this.certificate = builder.certificate;
		this.rewrite = builder.rewrite;
		this.access = builder.access;
		this.headerFilter = builder.headerFilter;
		this.bodyFilter = builder.bodyFilter;
		this.log = builder.log;
	}

	public List<String> getCertificate() {
		return certificate;
	}

	public List<String> getRewrite() {
		return rewrite;
	}

	public List<String> getAccess() {
		return access;
	}

	public List<String> getHeaderFilter() {
		return headerFilter;
	}

	public List<String> getBodyFilter() {
		return bodyFilter;
	}

	public List<String> getLog() {
		return log;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private List<String> certificate;
		private List<String> rewrite;
		private List<String> access;
		private List<String> headerFilter;
		private List<String> bodyFilter;
		private List<String> log;

		private Builder() {
		}

		public Builder withCertificate(List<String> certificate) {
			this.certificate = certificate;
			return this;
		}

		public Builder withRewrite(List<String> rewrite) {
			this.rewrite = rewrite;
			return this;
		}

		public Builder withAccess(List<String> access) {
			this.access = access;
			return this;
		}

		public Builder withHeaderFilter(List<String> headerFilter) {
			this.headerFilter = headerFilter;
			return this;
		}

		public Builder withBodyFilter(List<String> bodyFilter) {
			this.bodyFilter = bodyFilter;
			return this;
		}

		public Builder withLog(List<String> log) {
			this.log = log;
			return this;
		}

		public LuaServerlessFunctionConfig build() {
			return new LuaServerlessFunctionConfig(this);
		}
	}

}
