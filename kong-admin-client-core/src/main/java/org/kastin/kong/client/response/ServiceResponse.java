package org.kastin.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import org.kastin.kong.client.enums.ProtocolEnum;
import org.kastin.kong.client.model.IdNameRelation;

public class ServiceResponse {
    private String id;

    @JsonProperty("created_at")
    private Long createdAt;

    @JsonProperty("updated_at")
    private Long updatedAt;

    private String name;
    private Integer retries;

    private ProtocolEnum protocol;
    private String host;
    private Integer port;
    private String path;

    @JsonProperty("connect_timeout")
    private Long connectTimeout;

    @JsonProperty("write_timeout")
    private Long writeTimeout;

    @JsonProperty("read_timeout")
    private Long readTimeout;
    private Set<String> tags;

    @JsonProperty("client_certificate")
    private IdNameRelation clientCertificate;


    public ServiceResponse() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Long createdAt) {
        this.createdAt = createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public ProtocolEnum getProtocol() {
        return protocol;
    }

    public void setProtocol(ProtocolEnum protocol) {
        this.protocol = protocol;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Long getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(Long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public Long getWriteTimeout() {
        return writeTimeout;
    }

    public void setWriteTimeout(Long writeTimeout) {
        this.writeTimeout = writeTimeout;
    }

    public Long getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(Long readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public IdNameRelation getClientCertificate() {
        return clientCertificate;
    }

    public void setClientCertificate(IdNameRelation clientCertificate) {
        this.clientCertificate = clientCertificate;
    }
}
