package org.kastin.kong.client.model;

import java.util.Set;

import org.kastin.kong.client.enums.UpstreamProtocol;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HealthyCheckActive {
    @JsonProperty("https_verify_certificate")
    private Boolean httpsVerifyCertificate = true;

    private ActiveHealthyCheckUnHealthyStatus unhealthy;

    @JsonProperty("http_path")
    private String httpPath = "/";

    private Long timeout = 1L;
    private ActiveHealthyCheckHealthyStatus healthy;

    @JsonProperty("https_sni")
    private String httpsSni;

    private Integer concurrency = 10;

    private UpstreamProtocol type = UpstreamProtocol.HTTP;
    
    private Set<String> headers;

    public HealthyCheckActive() {
    }

    public Boolean getHttpsVerifyCertificate() {
        return httpsVerifyCertificate;
    }

    public void setHttpsVerifyCertificate(Boolean httpsVerifyCertificate) {
        this.httpsVerifyCertificate = httpsVerifyCertificate;
    }

    public ActiveHealthyCheckUnHealthyStatus getUnhealthy() {
        return unhealthy;
    }

    public void setUnhealthy(ActiveHealthyCheckUnHealthyStatus unhealthy) {
        this.unhealthy = unhealthy;
    }

    public String getHttpPath() {
        return httpPath;
    }

    public void setHttpPath(String httpPath) {
        this.httpPath = httpPath;
    }

    public Long getTimeout() {
        return timeout;
    }

    public void setTimeout(Long timeout) {
        this.timeout = timeout;
    }

    public ActiveHealthyCheckHealthyStatus getHealthy() {
        return healthy;
    }

    public void setHealthy(ActiveHealthyCheckHealthyStatus healthy) {
        this.healthy = healthy;
    }

    public String getHttpsSni() {
        return httpsSni;
    }

    public void setHttpsSni(String httpsSni) {
        this.httpsSni = httpsSni;
    }

    public Integer getConcurrency() {
        return concurrency;
    }

    public void setConcurrency(Integer concurrency) {
        this.concurrency = concurrency;
    }

    public UpstreamProtocol getType() {
        return type;
    }

    public void setType(UpstreamProtocol type) {
        this.type = type;
    }

	public Set<String> getHeaders() {
		return headers;
	}

	public void setHeaders(Set<String> headers) {
		this.headers = headers;
	}
}
