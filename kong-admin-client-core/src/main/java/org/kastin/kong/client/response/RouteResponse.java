package org.kastin.kong.client.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.kastin.kong.client.enums.HttpMethod;
import org.kastin.kong.client.enums.ProtocolEnum;
import org.kastin.kong.client.model.IdNameRelation;

public class RouteResponse {

    private String id;
    @JsonProperty("created_at")
    private Long createdAt;
    @JsonProperty("updated_at")
    private Long updatedAt;
    private String name;
    private Set<ProtocolEnum> protocols;
    private Set<HttpMethod> methods;
    private List<String> paths;
    private Map<String, List<String>> headers;
    @JsonProperty("https_redirect_status_code")
    private Integer httpRedirectStatusCode;
    @JsonProperty("regex_priority")
    private Integer regexPriority;
    @JsonProperty("strip_path")
    private Boolean stripPath;
    @JsonProperty("preserve_host")
    private Boolean preserveHost;
    private Set<String> tags;
    @JsonProperty("request_buffering")
    private Boolean requestBuffering;
    @JsonProperty("response_buffering")
    private Boolean responseBuffering;
    private IdNameRelation service;

    public RouteResponse() {
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

    public Set<ProtocolEnum> getProtocols() {
        return protocols;
    }

    public void setProtocols(Set<ProtocolEnum> protocols) {
        this.protocols = protocols;
    }

    public Set<HttpMethod> getMethods() {
        return methods;
    }

    public void setMethods(Set<HttpMethod> methods) {
        this.methods = methods;
    }

    public List<String> getPaths() {
        return paths;
    }

    public void setPaths(List<String> paths) {
        this.paths = paths;
    }

    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public Integer getHttpRedirectStatusCode() {
        return httpRedirectStatusCode;
    }

    public void setHttpRedirectStatusCode(Integer httpRedirectStatusCode) {
        this.httpRedirectStatusCode = httpRedirectStatusCode;
    }

    public Integer getRegexPriority() {
        return regexPriority;
    }

    public void setRegexPriority(Integer regexPriority) {
        this.regexPriority = regexPriority;
    }

    public Boolean getStripPath() {
        return stripPath;
    }

    public void setStripPath(Boolean stripPath) {
        this.stripPath = stripPath;
    }

    public Boolean getPreserveHost() {
        return preserveHost;
    }

    public void setPreserveHost(Boolean preserveHost) {
        this.preserveHost = preserveHost;
    }

    public Set<String> getTags() {
        return tags;
    }

    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public Boolean getRequestBuffering() {
        return requestBuffering;
    }

    public void setRequestBuffering(Boolean requestBuffering) {
        this.requestBuffering = requestBuffering;
    }

    public Boolean getResponseBuffering() {
        return responseBuffering;
    }

    public void setResponseBuffering(Boolean responseBuffering) {
        this.responseBuffering = responseBuffering;
    }

    public IdNameRelation getService() {
        return service;
    }

    public void setService(IdNameRelation service) {
        this.service = service;
    }
}
