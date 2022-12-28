package io.github.ungle.kong.client.model.plugins.serverless;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.ungle.kong.client.model.plugins.PluginConfig;
import io.github.ungle.kong.client.service.ValidateUtils;

public class AWSLambdaConfig extends PluginConfig {

	@JsonProperty("aws_key")
	private String awsKey;
	@JsonProperty("aws_secret")
	private String awsSecret;
	@JsonProperty("aws_region")
	private String awsRegion;
	@JsonProperty("aws_assume_role_arn")
	private String awsAssumeRoleArn;
	@JsonProperty("aws_role_session_name")
	private String awsRoleSessionName;
	@JsonProperty("host")
	private String host;
	@JsonProperty("function_name")
	private String functionName;
	@JsonProperty("qualifier")
	private String qualifier;
	@JsonProperty("invocation_type")
	private String invocationType;
	@JsonProperty("log_type")
	private String logType;
	@JsonProperty("timeout")
	private Long timeout;
	@JsonProperty("port")
	private Integer port;
	@JsonProperty("keepalive")
	private Long keepalive;
	@JsonProperty("unhandled_status")
	private Integer unhandledStatus;
	@JsonProperty("forward_request_body")
	private Boolean forwardRequestBody;
	@JsonProperty("forward_request_headers")
	private Boolean forwardRequestHeaders;
	@JsonProperty("forward_request_method")
	private Boolean forwardRequestMethod;
	@JsonProperty("forward_request_uri")
	private Boolean forwardRequestUri;
	@JsonProperty("is_proxy_integration")
	private Boolean proxyIntegration;
	@JsonProperty("awsgateway_compatible")
	private Boolean awsgatewayCompatible;
	@JsonProperty("proxy_url")
	private String proxyUrl;
	@JsonProperty("skip_large_bodies")
	private Boolean skipLargeBodies;
	@JsonProperty("base64_encode_body")
	private Boolean base64EncodeBody;

	private AWSLambdaConfig(Builder builder) {
		this.awsKey = builder.awsKey;
		this.awsSecret = builder.awsSecret;
		this.awsRegion = builder.awsRegion;
		this.awsAssumeRoleArn = builder.awsAssumeRoleArn;
		this.awsRoleSessionName = builder.awsRoleSessionName;
		this.host = builder.host;
		this.functionName = builder.functionName;
		this.qualifier = builder.qualifier;
		this.invocationType = builder.invocationType;
		this.logType = builder.logType;
		this.timeout = builder.timeout;
		this.port = builder.port;
		this.keepalive = builder.keepalive;
		this.unhandledStatus = builder.unhandledStatus;
		this.forwardRequestBody = builder.forwardRequestBody;
		this.forwardRequestHeaders = builder.forwardRequestHeaders;
		this.forwardRequestMethod = builder.forwardRequestMethod;
		this.forwardRequestUri = builder.forwardRequestUri;
		this.proxyIntegration = builder.proxyIntegration;
		this.awsgatewayCompatible = builder.awsgatewayCompatible;
		this.proxyUrl = builder.proxyUrl;
		this.skipLargeBodies = builder.skipLargeBodies;
		this.base64EncodeBody = builder.base64EncodeBody;
	}

	public String getAwsKey() {
		return awsKey;
	}

	public String getAwsSecret() {
		return awsSecret;
	}

	public String getAwsRegion() {
		return awsRegion;
	}

	public String getAwsAssumeRoleArn() {
		return awsAssumeRoleArn;
	}

	public String getAwsRoleSessionName() {
		return awsRoleSessionName;
	}

	public String getHost() {
		return host;
	}

	public String getFunctionName() {
		return functionName;
	}

	public String getQualifier() {
		return qualifier;
	}

	public String getInvocationType() {
		return invocationType;
	}

	public String getLogType() {
		return logType;
	}

	public Long getTimeout() {
		return timeout;
	}

	public Integer getPort() {
		return port;
	}

	public Long getKeepalive() {
		return keepalive;
	}

	public Integer getUnhandledStatus() {
		return unhandledStatus;
	}

	public Boolean getForwardRequestBody() {
		return forwardRequestBody;
	}

	public Boolean getForwardRequestHeaders() {
		return forwardRequestHeaders;
	}

	public Boolean getForwardRequestMethod() {
		return forwardRequestMethod;
	}

	public Boolean getForwardRequestUri() {
		return forwardRequestUri;
	}

	public Boolean getProxyIntegration() {
		return proxyIntegration;
	}

	public Boolean getAwsgatewayCompatible() {
		return awsgatewayCompatible;
	}

	public String getProxyUrl() {
		return proxyUrl;
	}

	public Boolean getSkipLargeBodies() {
		return skipLargeBodies;
	}

	public Boolean getBase64EncodeBody() {
		return base64EncodeBody;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static final class Builder {
		private String awsKey;
		private String awsSecret;
		private String awsRegion;
		private String awsAssumeRoleArn;
		private String awsRoleSessionName;
		private String host;
		private String functionName;
		private String qualifier;
		private String invocationType;
		private String logType;
		private Long timeout;
		private Integer port;
		private Long keepalive;
		private Integer unhandledStatus;
		private Boolean forwardRequestBody;
		private Boolean forwardRequestHeaders;
		private Boolean forwardRequestMethod;
		private Boolean forwardRequestUri;
		private Boolean proxyIntegration;
		private Boolean awsgatewayCompatible;
		private String proxyUrl;
		private Boolean skipLargeBodies;
		private Boolean base64EncodeBody;

		private Builder() {
		}

		public Builder withAwsKey(String awsKey) {
			this.awsKey = awsKey;
			return this;
		}

		public Builder withAwsSecret(String awsSecret) {
			this.awsSecret = awsSecret;
			return this;
		}

		public Builder withAwsRegion(String awsRegion) {
			this.awsRegion = awsRegion;
			return this;
		}

		public Builder withAwsAssumeRoleArn(String awsAssumeRoleArn) {
			this.awsAssumeRoleArn = awsAssumeRoleArn;
			return this;
		}

		public Builder withAwsRoleSessionName(String awsRoleSessionName) {
			this.awsRoleSessionName = awsRoleSessionName;
			return this;
		}

		public Builder withHost(String host) {
			this.host = host;
			return this;
		}

		public Builder withFunctionName(String functionName) {
			this.functionName = functionName;
			return this;
		}

		public Builder withQualifier(String qualifier) {
			this.qualifier = qualifier;
			return this;
		}

		public Builder withInvocationType(String invocationType) {
			this.invocationType = invocationType;
			return this;
		}

		public Builder withLogType(String logType) {
			this.logType = logType;
			return this;
		}

		public Builder withTimeout(Long timeout) {
			this.timeout = timeout;
			return this;
		}

		public Builder withPort(Integer port) {
			this.port = port;
			return this;
		}

		public Builder withKeepalive(Long keepalive) {
			this.keepalive = keepalive;
			return this;
		}

		public Builder withUnhandledStatus(Integer unhandledStatus) {
			this.unhandledStatus = unhandledStatus;
			return this;
		}

		public Builder withForwardRequestBody(Boolean forwardRequestBody) {
			this.forwardRequestBody = forwardRequestBody;
			return this;
		}

		public Builder withForwardRequestHeaders(Boolean forwardRequestHeaders) {
			this.forwardRequestHeaders = forwardRequestHeaders;
			return this;
		}

		public Builder withForwardRequestMethod(Boolean forwardRequestMethod) {
			this.forwardRequestMethod = forwardRequestMethod;
			return this;
		}

		public Builder withForwardRequestUri(Boolean forwardRequestUri) {
			this.forwardRequestUri = forwardRequestUri;
			return this;
		}

		public Builder withProxyIntegration(Boolean proxyIntegration) {
			this.proxyIntegration = proxyIntegration;
			return this;
		}

		public Builder withAwsgatewayCompatible(Boolean awsgatewayCompatible) {
			this.awsgatewayCompatible = awsgatewayCompatible;
			return this;
		}

		public Builder withProxyUrl(String proxyUrl) {
			this.proxyUrl = proxyUrl;
			return this;
		}

		public Builder withSkipLargeBodies(Boolean skipLargeBodies) {
			this.skipLargeBodies = skipLargeBodies;
			return this;
		}

		public Builder withBase64EncodeBody(Boolean base64EncodeBody) {
			this.base64EncodeBody = base64EncodeBody;
			return this;
		}

		public AWSLambdaConfig build() {
			timeout = ValidateUtils.defaultIfNull(timeout, 60000L);
			port = ValidateUtils.defaultIfNull(port, 443);
			keepalive = ValidateUtils.defaultIfNull(keepalive, 60000L);
			forwardRequestBody = ValidateUtils.defaultIfNull(forwardRequestBody, Boolean.FALSE);
			forwardRequestHeaders = ValidateUtils.defaultIfNull(forwardRequestHeaders, Boolean.FALSE);
			forwardRequestMethod = ValidateUtils.defaultIfNull(forwardRequestMethod, Boolean.FALSE);
			forwardRequestUri = ValidateUtils.defaultIfNull(forwardRequestUri, Boolean.FALSE);
			proxyIntegration = ValidateUtils.defaultIfNull(proxyIntegration, Boolean.FALSE);
			awsgatewayCompatible = ValidateUtils.defaultIfNull(awsgatewayCompatible, Boolean.FALSE);
			skipLargeBodies = ValidateUtils.defaultIfNull(skipLargeBodies, Boolean.TRUE);
			base64EncodeBody = ValidateUtils.defaultIfNull(base64EncodeBody, Boolean.TRUE);
			return new AWSLambdaConfig(this);
		}
	}

}
