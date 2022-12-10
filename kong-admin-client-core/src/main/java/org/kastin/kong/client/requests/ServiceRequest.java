package org.kastin.kong.client.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

import org.kastin.kong.client.enums.ProtocolEnum;
import org.kastin.kong.client.model.IdNameRelation;

public class ServiceRequest extends Request {

    private String name;
    private Integer retries = 5;
    private ProtocolEnum protocol;
    private String host;
    private Integer port;
    private String path;

    @JsonProperty("connect_timeout")
    private long connectTimeout = 60000;

    @JsonProperty("write_timeout")
    private long writeTimeOut = 60000;

    @JsonProperty("read_timeout")
    private long readTimeout = 60000;

    private Set<String> tags;

    private String url;

    @JsonProperty("client_certificate")
    private IdNameRelation clientCertificate;

    public ServiceRequest() {
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

    public long getConnectTimeout() {
        return connectTimeout;
    }

    public void setConnectTimeout(long connectTimeout) {
        this.connectTimeout = connectTimeout;
    }

    public long getWriteTimeOut() {
        return writeTimeOut;
    }

    public void setWriteTimeOut(long writeTimeOut) {
        this.writeTimeOut = writeTimeOut;
    }

    public long getReadTimeout() {
        return readTimeout;
    }

    public void setReadTimeout(long readTimeout) {
        this.readTimeout = readTimeout;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public IdNameRelation getClientCertificate() {
        return clientCertificate;
    }

    public void setClientCertificate(IdNameRelation clientCertificate) {
        this.clientCertificate = clientCertificate;
    }
}
