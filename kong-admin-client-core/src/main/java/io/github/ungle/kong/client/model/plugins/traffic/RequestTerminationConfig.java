package io.github.ungle.kong.client.model.plugins.traffic;

import com.fasterxml.jackson.annotation.JsonProperty;

import feign.Util;
import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

public class RequestTerminationConfig extends PluginConfig {

	@JsonProperty("status_code")
	private Integer statusCode;

	private String message;

	private String body;

	@JsonProperty("content_type")
	private String contentType;

	private String trigger;

	private Boolean echo;

	private RequestTerminationConfig(Builder builder) {
		this.statusCode = builder.statusCode;
		this.message = builder.message;
		this.body = builder.body;
		this.contentType = builder.contentType;
		this.trigger = builder.trigger;
		this.echo = builder.echo;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public String getMessage() {
		return message;
	}

	public String getBody() {
		return body;
	}

	public String getContentType() {
		return contentType;
	}

	public String getTrigger() {
		return trigger;
	}

	public Boolean getEcho() {
		return echo;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private Integer statusCode;
		private String message;
		private String body;
		private String contentType;
		private String trigger;
		private Boolean echo;

		private Builder() {
		}

		public Builder withStatusCode(Integer statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		public Builder withBody(String body) {
			this.body = body;
			return this;
		}

		public Builder withContentType(String contentType) {
			this.contentType = contentType;
			return this;
		}

		public Builder withTrigger(String trigger) {
			this.trigger = trigger;
			return this;
		}

		public Builder withEcho(Boolean echo) {
			this.echo = echo;
			return this;
		}
		
		private void verify() {
			if(Util.isNotBlank(message) && (Util.isNotBlank(contentType) || Util.isNotBlank(body))) {
				throw new IllegalArgumentException("message cannot be used with content_type or body");
			}
			
			if(Util.isNotBlank(contentType) && Util.isBlank(body)) {
				throw new IllegalArgumentException("content_type requires a body");
			}
			
			if(echo && (Util.isNotBlank(contentType) || Util.isNotBlank(body)) ) {
				throw new IllegalArgumentException("echo cannot be used with content_type and body");
			}
		}

		public RequestTerminationConfig build() {
			statusCode = ValidateUtils.defaultIfNull(statusCode, 503);
			echo = ValidateUtils.defaultIfNull(echo, Boolean.FALSE);
			verify();
			return new RequestTerminationConfig(this);
		}
	}
	
	

}
